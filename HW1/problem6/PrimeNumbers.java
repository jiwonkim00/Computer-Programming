public class PrimeNumbers {
    public static void printPrimeNumbers(int n) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        int[] prime = new int[100];
        prime[0]=2;
        prime[1]=3;

        for (int i=2; i<prime.length; i++) {
            for (int j= prime[i-1]+1; ; j++) {
                if (! isPrime(j)) continue;
                else {
                    prime[i]=j;
                    break;
                }
            }
        }
        for (int i=0; i<n; i++) {
            System.out.print(prime[i]);
            System.out.print(" ");
        }

    }
    public static boolean isPrime(int n) {
        for (int i=2; i<Math.sqrt(n)+1; i++) {
            if (n%i ==0) return false;
        }
        return true;
    }
}
