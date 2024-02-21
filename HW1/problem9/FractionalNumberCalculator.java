public class FractionalNumberCalculator {
    public static void printCalculationResult(String equation) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        String[] eqArray = equation.split(" ", 3);
        FractionalNumber num1;
        FractionalNumber num2;
        char operator= eqArray[1].charAt(0);
        if (eqArray[0].contains("/")) {
            int divIndex = eqArray[0].indexOf("/");
            num1 = new FractionalNumber(Integer.parseInt(eqArray[0].substring(0,divIndex)),Integer.parseInt(eqArray[0].substring(divIndex+1)) );
        }
        else {
            num1 = new FractionalNumber(Integer.parseInt(eqArray[0]), 1);
        }
        if (eqArray[2].contains("/")) {
            int divIndex = eqArray[2].indexOf("/");
            num2 = new FractionalNumber(Integer.parseInt(eqArray[2].substring(0,divIndex)),Integer.parseInt(eqArray[2].substring(divIndex+1)) );
        }
        else {
            num2 = new FractionalNumber(Integer.parseInt(eqArray[2]), 1);
        }
        switch (operator) {
            case '+' : {
                num1.add(num2);
                break;
            }
            case '-' : {
                num1.sub(num2);
                break;
            }
            case '*' : {
                num1.mul(num2);
                break;
            }
            case '/' : {
                num1.div(num2);
                break;
            }
        }

    }


}

class FractionalNumber {
    private int numerator;
    private int denominator;

    public FractionalNumber (int numerator, int denominator) {
        this.numerator= numerator;
        this.denominator= denominator;
    }

    public void add (FractionalNumber other) {
        int n, d;
        int l= getLCM(this.denominator, other.denominator);
        n= (this.numerator * l/this.denominator ) + (other.numerator * l/other.denominator);
        d= l;

        FractionalNumber result = new FractionalNumber(n, d);
        result.makeIrreducible();
        if (result.denominator ==1) System.out.println(result.numerator);
        else result.showNum();
    }
    public void sub (FractionalNumber other) {
        int n, d;
        int l= getLCM(this.denominator, other.denominator);
        n= (this.numerator * l/this.denominator ) - (other.numerator * l/other.denominator);
        d= l;

        FractionalNumber result = new FractionalNumber(n, d);
        result.makeIrreducible();
        if (result.denominator ==1) System.out.println(result.numerator);
        else result.showNum();
    }
    public void mul (FractionalNumber other) {
        FractionalNumber result = new FractionalNumber(this.numerator * other.numerator, this.denominator * other.denominator );
        result.makeIrreducible();
        if (result.denominator ==1) System.out.println(result.numerator);
        else result.showNum();
    }
    public void div (FractionalNumber other) {
        FractionalNumber result = new FractionalNumber(this.numerator * other.denominator, this.denominator * other.numerator);
        result.makeIrreducible();
        if (result.denominator ==1) System.out.println(result.numerator);
        else result.showNum();
    }

    public void makeIrreducible () {
        int g = getGCD(this.numerator, this.denominator);
        if (g < 0) g *= -1;
        if (g != 1){
            this.numerator /= g;
            this.denominator /= g;
        }
    }

    public int getGCD (int n1, int n2) {
        if (n2==0) return n1;
        return getGCD(n2, n1 % n2);
    }
    public int getLCM (int n1, int n2) {
        int g= getGCD(n1, n2);
        return (n1 * n2)/g ;
    }
    public void showNum () {
        System.out.println(this.numerator + "/" + this.denominator);
    }
}


