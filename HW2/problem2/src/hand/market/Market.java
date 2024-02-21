package hand.market;

import hand.agent.Buyer;
import hand.agent.Seller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

class Pair<K,V> {
    public K key;
    public V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class Market {
    public ArrayList<Buyer> buyers;
    public ArrayList<Seller> sellers;

    public Market(int nb, ArrayList<Double> fb, int ns, ArrayList<Double> fs) {
        buyers = createBuyers(nb, fb);
        sellers = createSellers(ns, fs);
    }

    private double getF(double x, ArrayList<Double> f) {
        int length = f.size();
        double result =0 ;
        for (int i=0; i<length-1; i++) {
            result += (f.get(i))*Math.pow(x, length-1-i);
        }
        result += f.get(length-1);
        return result;
    }

    private ArrayList<Buyer> createBuyers(int n, ArrayList<Double> f) {
        // TODO sub-problem 3
        ArrayList<Buyer> buyers = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            double price = getF((double)i/n, f);
            buyers.add(new Buyer(price));
        }
        return buyers;
    }

    private ArrayList<Seller> createSellers(int n, ArrayList<Double> f) {
        // TODO sub-problem 3
        ArrayList<Seller> sellers = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            double price = getF((double)i/n, f);
            sellers.add(new Seller(price));
        }
        return sellers;
    }

    private ArrayList<Pair<Seller, Buyer>> matchedPairs(int day, int round) {
        ArrayList<Seller> shuffledSellers = new ArrayList<>(sellers);
        ArrayList<Buyer> shuffledBuyers = new ArrayList<>(buyers);
        Collections.shuffle(shuffledSellers, new Random(71 * day + 43 * round + 7));
        Collections.shuffle(shuffledBuyers, new Random(67 * day + 29 * round + 11));
        ArrayList<Pair<Seller, Buyer>> pairs = new ArrayList<>();
        for (int i = 0; i < shuffledBuyers.size(); i++) {
            if (i < shuffledSellers.size()) {
                pairs.add(new Pair<>(shuffledSellers.get(i), shuffledBuyers.get(i)));
            }
        }
        return pairs;
    }

    public double simulate() {
        // TODO sub-problem 2 and 3
        double sum=0;
        double num=0;
        for (int day = 1; day <= 1000; day++) { // do not change this line
            sum = 0;
            num = 0;
            for (int round = 1; round <= 10; round++) { // do not change this line
                ArrayList<Pair<Seller, Buyer>> pairs = matchedPairs(day, round); // do not change this line
                for (int i=0; i<pairs.size(); i++) {
                    Pair<Seller, Buyer> pair = pairs.get(i);
                    Buyer buyer = pair.value;
                    Seller seller = pair.key;

                    if ( buyer.willTransact(seller.getExpectedPrice()) && seller.willTransact(buyer.getExpectedPrice())) {
                        buyer.makeTransaction();
                        seller.makeTransaction();
                        sum += seller.getExpectedPrice();
                        num ++;
                    }
                }
            }

            for (Buyer buyer : buyers) {
                buyer.reflect();
            }
            for (Seller seller : sellers) {
                seller.reflect();
            }
        }
        double avg;
        avg = sum/num;

        return avg;
    }
}
