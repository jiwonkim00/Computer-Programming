public class DrawingFigure {
    public static void drawFigure(int n) {
        // DO NOT change the skeleton code.
        // You can add codes anywhere you want.
        for (int i=0; i<n; i++) {
            int slashNum = 4*(5-i);
            int starNum = 8*(i);
            int num=0;
            while (num< slashNum) {
                System.out.print('/');
                num++;
            }
            num=0;
            while (num<starNum) {
                System.out.print('*');
                num++;
            }
            num=0;
            while (num< slashNum) {
                System.out.print('\\');
                num++;
            }
            System.out.println("");
        }
    }
}