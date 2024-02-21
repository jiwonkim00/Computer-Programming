public class NumberCounter {
    public static void countNumbers(String str0, String str1, String str2) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        int num0= Integer.parseInt(str0);
        int num1= Integer.parseInt(str1);
        int num2= Integer.parseInt(str2);
        int mul = num0 * num1 * num2;

        int[] mulArray = new int[Integer.toString(mul).length()];

        for (int i=0; i<mulArray.length; i++) {
            mulArray[i]= mul % 10;
            mul /= 10;
        } 

        for (int i=0; i<(mulArray.length); i++) {
            for (int j=0; j<(mulArray.length); j++) {
                if (mulArray[i]< mulArray[j]) {
                    int temp= mulArray[i];
                    mulArray[i]= mulArray[j];
                    mulArray[j]= temp;
                }
            }
        }

        int counter=1;
        for (int i=0; i<(mulArray.length-1); i++) {
            if (mulArray[i]==mulArray[i+1]) {
                counter+=1;
            }
            else {
                printNumberCount(mulArray[i], counter);
                counter=1;
            }
        }
        printNumberCount(mulArray[mulArray.length-1], counter);
    }

    private static void printNumberCount(int number, int count) {
        System.out.printf("%d: %d times\n", number, count);
    }
}
