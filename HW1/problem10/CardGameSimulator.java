public class CardGameSimulator {
    private static final Player[] players = new Player[2];

    public static void simulateCardGame(String inputA, String inputB) {

        players[0] = new Player("A");
        players[1] = new Player("B");

        players[0].setCard(inputA);
        players[1].setCard(inputB);
        for (Player player : players) {
            player.sortCard();
        }

        players[0].playCard(0);
        int pp=1;
        while(true) {
            play(pp);

            if (players[pp].current == -1 ) {
                return;
            }

            if (pp==0) pp=1;
            else if(pp==1) pp=0;
            else return;
        }

    }

    private static void printLoseMessage(Player player) {
        System.out.printf("Player %s loses the game!\n", player);
    }
    public static void play(int p) {
        int o;
        if (p==0) o=1;
        else if (p==1) o=0;
        else return;

        players[p].current = players[p].findNextIndex(players[o].deck[players[o].current].number, players[o].deck[players[o].current].shape);

        if (players[p].current == -1) {
            printLoseMessage(players[p]);
            return;
        }
        else {
            players[p].playCard(players[p].current);
        }
    }

}


class Player {
    private String name;
    Card[] deck ;
    int[] usedIndex = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    int current=0;
    int used=0;

    public void playCard(int cardIndex) {
        usedIndex[used] = cardIndex;
        used++;
        System.out.printf("Player %s: %s\n", name, deck[cardIndex]);
    }

    @Override
    public String toString() {
        return name;
    }

    public boolean isUsed(int n) {
        for (int i=0; i<10; i++) {
            if (usedIndex[i]==n) {
                return true;
            }
        }
        return false;
    }

    public int findNextIndex(int num, char shape ) {
        for (int i=0; i<10; i++) {
            if (deck[i].number == num) {
                if(!isUsed(i)) {
                    return i;
                }
            }
        }
        for (int i=0; i<10; i++) {
            if (deck[i].shape == shape) {
                if(!isUsed(i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Player(String name) {
        this.name= name;
    }

    public void setCard(String input) {
        deck = new Card[10];
        int i=0;
        for (String c : input.split(" ", 10)) {
            Card card = new Card();
            deck[i] = card;
            deck[i].number = Integer.parseInt("" + c.charAt(0));
            deck[i].shape = c.charAt(1);
            i++;
        }
    }
    public void sortCard() {
        for (int i=0; i<9; i++) {
            for (int j=i+1; j<10; j++) {
                if (deck[i].number < deck[j].number) {
                    Card temp = deck[i];
                    deck[i] = deck[j];
                    deck[j] = temp;
                }
                else if(deck[i].number == deck[j].number) {
                    if ((deck[i].shape =='X')&&(deck[j].shape == 'O')) {
                        Card temp = deck[i];
                        deck[i] = deck[j];
                        deck[j] = temp;
                    }
                }
            }
        }
    }

}

class Card {
    int number;
    char shape;

    @Override
    public String toString() {
        return "" + number + shape;
    }
}
