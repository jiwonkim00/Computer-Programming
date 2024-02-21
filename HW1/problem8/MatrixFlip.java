public class MatrixFlip {
    public static void printFlippedMatrix(char[][] matrix) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        for (int n= matrix.length-1; n>=0; n--) {
            for (int m= matrix[0].length-1; m>=0; m--) {
                System.out.print(matrix[n][m]);
            }
            System.out.println();
        }
    }
}