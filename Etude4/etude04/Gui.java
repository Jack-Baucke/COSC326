package etude04;

public class Gui {

    public static void main(String[] args) {

        circleCentre(1.0, 0.0, 5.0, 7.0, 9.0, 4.0);

    }

    public static void circleCentre(double x1, double y1, double x2, double y2, double x3, double y3) {
        double yDelta_1 = y2 - y1;
        double xDelta_1 = x2 - x1;

        double yDelta_2 = y3 - y2;
        double xDelta_2 = x3 - x2;

        double slope1 = yDelta_1 / xDelta_1;
        double slope2 = yDelta_2 / xDelta_2;

        double x_center = (slope1 * slope2 * (y1 - y3) + slope2 * (x1 + x2) - slope1 * (x2 + x3)) / (2 * (slope2 - slope1) );

        double y_center = -1 * (x_center - (x1 + x2) / 2) / slope1 + (y1 + y2) / 2;

        System.out.println(x_center + " " + y_center);
    }
}