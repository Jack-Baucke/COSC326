public class TurtleFractal {

    public static void HilbertCurve(int n, Turtle fred, double step) {
        if (n > 0) {
            if (n % 2 == 1) {
                fred.left(90);
                HilbertCurve(n - 1, fred, step);
                fred.forward(step);
                fred.right(90);
                HilbertCurve(n - 1, fred, step);
                fred.forward(step);
                HilbertCurve(n - 1, fred, step);
                fred.right(90);
                fred.forward(step);
                HilbertCurve(n - 1, fred, step);
                fred.left(90);
            } else {
                fred.right(90);
                HilbertCurve(n - 1, fred, step);
                fred.forward(step);
                fred.left(90);
                HilbertCurve(n - 1, fred, step);
                fred.forward(step);
                HilbertCurve(n - 1, fred, step);
                fred.left(90);
                fred.forward(step);
                HilbertCurve(n - 1, fred, step);
                fred.right(90);
            }
        }
    }
    
    public static void main(String[] args) {
        Turtle fred = new Turtle(0, 0, 0);
        //fred can go forward or turn to any angle
        // 0,0-initial coordinates, 0-angle
        fred.down();
        int n = 2;
        //n - curve size 
    
        double s = Math.pow(2, n - 2);
        double step = 0.5 / (s * 3 + (s - 1));
    
        //draw the curve
        HilbertCurve(n, fred, step);
    
    }
}