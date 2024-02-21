public class IncreasingString {
    public static void printLongestIncreasingSubstringLength(String inputString) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        char[] charArray = new char[inputString.length()];
        int[] counterArray = new int[inputString.length()];
        for (int i=0; i<inputString.length(); i++) {
            charArray[i]= inputString.charAt(i);
        }
        int counter=1;

        for (int i=0; i<charArray.length-1; i++) {
            if (charArray[i]<charArray[i+1]) {
                counter++;
            }
            else {
                counterArray[i] = counter;
                counter = 1;
            }
        }
        counterArray[charArray.length-1] = counter;

        int max=0;
        for (int i : counterArray) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println(max);
    }
}