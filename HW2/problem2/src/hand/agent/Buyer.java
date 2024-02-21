package hand.agent;

public class Buyer extends Agent {

    public Buyer(double maximumPrice) {
        super(maximumPrice);
    }

    @Override
    public boolean willTransact(double price) {
        // TODO sub-problem 1
        if (hadTransaction) { return false; }
        return !(price > expectedPrice);
    }

    @Override
    public void reflect() {
        // TODO sub-problem 1
        if (hadTransaction) { expectedPrice -= adjustment; }
        else { expectedPrice += adjustment; }

        if(expectedPrice > priceLimit) { expectedPrice = priceLimit; }
        hadTransaction = false;
    }
}
