package etude04;

import java.util.ArrayList;
import java.util.Scanner;

public class cordlessPhones {

    public static Coord centre;
    public static int largestCount = 0;
    public static int radius = 0;
    public static ArrayList<Coord> points = new ArrayList<Coord>();
    private static double largestRadius = 0.0;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        while(sc.hasNext()){
            Double siteX = Double.parseDouble(sc.next());
            Double siteY = Double.parseDouble(sc.next());
            points.add(new Coord(siteX, siteY));

        }

        for (int a = 0; a < points.size(); a++) {
            for (int b = a + 1; b < points.size(); b++) {
                for (int c = b + 1; c < points.size(); c++) {

                    Coord center = calculateCenter(points.get(a), points.get(b), points.get(c));
                    double radius = calculateRadius(points.get(a), center);
                    int count = 0;

                    for (Coord point : points) {
                        if (isWithin(center, point, radius)) {
                            count++;
                        }
                        if (count > 11) {
                            break;
                        }
                    }
                    if (count <= 11) {
                        if (radius > largestRadius) {
                            largestRadius = radius;
                        }
                    }
                }
            }
        }
        
        System.out.println(largestRadius);
    }

    public static Coord calculateCenter(Coord i, Coord j, Coord k) {
        double yDelta_1 = j.getY() - i.getY();
        double xDelta_1 = j.getX() - i.getX();

        double yDelta_2 = k.getY() - j.getY();
        double xDelta_2 = k.getX() - j.getX();

        double slope1 = yDelta_1 / xDelta_1;
        double slope2 = yDelta_2 / xDelta_2;

        double x_center = (slope1 * slope2 * (i.getY() - k.getY()) + slope2 * (i.getX() + j.getX()) - slope1 * (j.getX() + k.getX())) / (2 * (slope2 - slope1) );

        double y_center = -1 * (x_center - (i.getX() + j.getX()) / 2) / slope1 + (i.getY() + j.getY()) / 2;

        Coord center = new Coord(x_center, y_center);
        return center;
    } 
    
    public static double calculateRadius(Coord i, Coord center) {

        double deltaX = Math.pow(i.getX() - center.getX(), 2);
        double deltaY = Math.pow(i.getY() - center.getY(), 2);

        double radius = Math.sqrt(deltaX + deltaY);

        return radius;
    }

    public static boolean isWithin(Coord center, Coord test, double radius) {
        double deltaX = Math.pow(test.getX() - center.getX(), 2);
        double deltaY = Math.pow(test.getY() - center.getY(), 2);

        double distance = Math.sqrt(deltaX + deltaY);

        if (distance < radius) {
            return true;
        }
        return false;
    }
}