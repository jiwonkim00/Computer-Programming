public class FibonacciNumbers {

    public static void printFibonacciNumbers(int n) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        for (int i=1; i<=n; i++) {
            System.out.print(F_num(i));
            System.out.print(" ");
        }
    }
    public static int F_num(int n) {
        if (n==1)
            return 0;
        else if (n==2)
            return 1;
        return F_num(n-1) + F_num(n-2);
    }
}