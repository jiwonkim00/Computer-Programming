public class CharacterCounter {
    public static void countCharacter(String str) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        char[] inputArray = str.toCharArray();
        int length = str.length();
        char temp;
        int counter=1;
        //bubble-sort
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                if (inputArray[i]<inputArray[j]) {
                    temp = inputArray[i];
                    inputArray[i]=inputArray[j];
                    inputArray[j]= temp;
                }
            }
        }

        for (int i=0; i<(length-1); i++) {
            if (inputArray[i]==inputArray[i+1]) {
                counter+=1;
            }
            else {
                printCount(inputArray[i], counter);
                counter=1;
            }
        }
        printCount(inputArray[length-1], counter);


    }

    private static void printCount(char character, int count) {
        System.out.printf("%c: %d times\n", character, count);
    }
}