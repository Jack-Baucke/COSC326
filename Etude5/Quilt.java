import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;

public class Quilt {

    public static ArrayList<Square> squares = new ArrayList<Square>();
    public static int size;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Square square;
        double scale;
        int red, green, blue;
        Color color;        

        while(scanner.hasNext()) {
            scale = scanner.nextDouble();
            red = scanner.nextInt();
            green = scanner.nextInt();
            blue = scanner.nextInt();
            color = new Color(red, green, blue);
            square = new Square(scale, color);
            size += scale * 100;
            squares.add(square);
        }

        Frame frame = new Frame();
        frame.add(new CustomPaintComponent());
        frame.setSize(size, size);
        frame.setVisible(true);
    }

    static class CustomPaintComponent extends Component {

        public void paint(Graphics g) {

            Graphics2D g2d = (Graphics2D)g;         
            drawSquare(Quilt.squares.get(0), 0, g2d);

        }

        int x;
        int y;
        int length;
        double lengthD;
        Square square;

        public void drawSquare(Square square, int lineIndex, Graphics g2d) {

            if (lineIndex == 0) {
                int middle = Quilt.size/2;
                g2d.setColor(Quilt.squares.get(0).getColor());
                lengthD= Quilt.squares.get(0).getScale() * 100;
                length = (int) Math.round(lengthD);
                x = middle - (length/2);
                y = middle - (length/2);
                g2d.fillRect(x, y, length, length);
                Quilt.squares.get(0).setCorner1(new Corner(x, y));
                Quilt.squares.get(0).setCorner2(new Corner(x - length, y));
                Quilt.squares.get(0).setCorner3(new Corner(x, y - length));
                Quilt.squares.get(0).setCorner4(new Corner(x - length, y - length));

                drawSquare(Quilt.squares.get(lineIndex + 1), lineIndex + 1, g2d);
            }

            if (lineIndex >= Quilt.squares.size() || Quilt.squares.get(lineIndex).getCornerIndex() == 4) {
                return;
            }

            lengthD = Quilt.squares.get(0).getScale() * 100;
            length = (int) Math.round(lengthD);

            square = Quilt.squares.get(lineIndex);

            x = square.getCorner(square.getCornerIndex()).getX() - length/2;
            y = square.getCorner(square.getCornerIndex()).getY() - length/2;
            g2d.setColor(square.getColor());
            g2d.fillRect(x, y, length, length);
            square.incrementCornerIndex();
            square.setCorner1(new Corner(x, y));
            square.setCorner2(new Corner(x - length, y));
            square.setCorner3(new Corner(x, y - length));
            square.setCorner4(new Corner(x - length, y - length));
            drawSquare(Quilt.squares.get(lineIndex + 1), lineIndex + 1, g2d);
        }
    }
}


//import java.awt.*;
// import java.awt.geom.*;
// import javax.swing.*;

// import java.util.*;

// public class HilbertCurve extends JPanel {

//     public static int size = 500;
//     //public static int length = 25;//size / ((int)Math.pow(2, 1) - 1);
//     public static int length = size;

//     public static int order;
//     public static double r;

//     public static int numLines;
//     public static int[] ratioLines = new int[3];

//     public static int linesCount = 0;

//     public static double numLinesWidth = 0;

//     public static Coord current = new Coord(5, 2);

//     public static void main(String[] args) {

//         Scanner scanner = new Scanner(System.in);
//         order = scanner.nextInt();
//         if (scanner.hasNextDouble()) {
//             r = scanner.nextDouble();
//         } else {
//             r = 1.0;
//         }

//         getNumLines();
//         setSeparatorLines();
//         setNumLinesWidth();
//         System.out.println(numLinesWidth);

//         length = size / (int) numLinesWidth;

//         // System.out.println(ratioLines[0] + " " + ratioLines[1] + " " + ratioLines[2]);
//         // System.out.println(numLines);

//         JFrame f = new JFrame("Hilbert Curve");
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         f.getContentPane().add(new HilbertCurve());
//         f.setSize(size+10, size+30);
//         f.setLocationRelativeTo(null);
//         f.setVisible(true);
//     }

//     public void paint(Graphics g) {
//         g.setColor(new Color(0, 0, 0));
//         downRightUp(g, order);
//     }

//     public static void downRightUp(Graphics g, int order) { // U
//         if (order != 0) {
//             rightDownLeft(g, order-1);
//             down(g);//drawLine
//             downRightUp(g, order-1);
//             right(g);//drawLine
//             downRightUp(g, order-1);
//             up(g);//drawLine
//             leftUpRight(g, order-1);
//         }
//     }

//     public static void rightDownLeft(Graphics g, int order) { // D
//         if (order != 0) {
//             downRightUp(g, order-1);
//             right(g);// drawLine
//             rightDownLeft(g, order-1);
//             down(g);// drawLine
//             rightDownLeft(g, order-1);
//             left(g);// drawLine
//             upLeftDown(g, order-1);
//         }
//     }

//     public static void leftUpRight(Graphics g, int order) { // C
//         if (order != 0) {
//             upLeftDown(g, order-1);
//             left(g);//drawLine
//             leftUpRight(g, order-1);
//             up(g);//drawLine
//             leftUpRight(g, order-1);
//             right(g);//drawLine
//             downRightUp(g, order-1);
//         }
//     }

//     public static void upLeftDown(Graphics g, int order) { // A
//         if (order != 0) {
//             leftUpRight(g, order-1);
//             up(g);//draw
//             upLeftDown(g, order-1);
//             left(g);//draw
//             upLeftDown(g, order-1);
//             down(g);//draw
//             rightDownLeft(g, order-1);
//         }
//     }

//     public static void left(Graphics g) {

//         if (linesCount == ratioLines[0] || linesCount == ratioLines[1] || linesCount == ratioLines[2]) {
//             g.drawLine(current.getX(), current.getY(), (int) (current.getX() - (r*length)), current.getY());
//             current = new Coord((int) (current.getX() - (r*length)), current.getY());
//             System.out.println("LONG BOI! left");
//         } else {        
//             g.drawLine(current.getX(), current.getY(), current.getX() - length, current.getY());
//             current = new Coord(current.getX() - length, current.getY());
//             System.out.println("LEFT"); 
//         }          
//         linesCount++;
//     }

//     public static void right(Graphics g) {
//         if (linesCount == ratioLines[0] || linesCount == ratioLines[1] || linesCount == ratioLines[2]) {
//             g.drawLine(current.getX(), current.getY(), (int) (current.getX() + (r * length)), current.getY());
//             current = new Coord((int) (current.getX() + (r * length)), current.getY());
//             System.out.println("LONG BOI! right");
//         } else {
//             g.drawLine(current.getX(), current.getY(), current.getX() + length, current.getY());
//             current = new Coord(current.getX() + length, current.getY());
//             System.out.println("RIGHT");
//         }        
//         linesCount++;
//     }

//      public static void up(Graphics g) {
//         if (linesCount == ratioLines[0] || linesCount == ratioLines[1] || linesCount == ratioLines[2]) {
//             g.drawLine(current.getX(), current.getY(), current.getX(), (int) (current.getY() - (r * length)));
//             current = new Coord(current.getX(), (int) (current.getY() - (r * length)));
//             System.out.println("LONG BOI! up");
//         } else {
//             g.drawLine(current.getX(), current.getY(), current.getX(), current.getY() - length);
//             current = new Coord(current.getX(), current.getY() - length);
//             System.out.println("UP");
//         }        
//         linesCount++;
//     }

//     public static void down(Graphics g) {
//         if (linesCount == ratioLines[0] || linesCount == ratioLines[1] || linesCount == ratioLines[2]) {
//             g.drawLine(current.getX(), current.getY(), current.getX(), (int) (current.getY() + (r * length)));
//             current = new Coord(current.getX(), (int) (current.getY() + (r * length)));
//             System.out.println("LONG BOI! down");
//         } else {
//             g.drawLine(current.getX(), current.getY(), current.getX(), current.getY() + length);
//             current = new Coord(current.getX(), current.getY() + length);
//             System.out.println("DOWN");
//         }        
//         linesCount++;
//     }

//     public static void getNumLines() {
//         int i = 0;
//         while (i < order) {
//             numLines *= 4;
//             numLines += 3;
//             i++;
//         }
//     }

//     public static void setSeparatorLines() {
//         int x = numLines - 3;
//         x = x/4;

//         if (order == 1) {
//             ratioLines[0] = 0;
//             ratioLines[1] = 1;
//             ratioLines[2] = 2;
//         } else {        
//             ratioLines[0] = x;
//             ratioLines[1] = x + (x+1);
//             ratioLines[2] = x + (x+1) + (x+1);
//         }
//     }

//     public static void setNumLinesWidth() {
//         for (int i = 1; i <= order; i++) {
//             numLinesWidth *= 2;
//             if (i == order) {
//                 numLinesWidth += r;
//             } else {
//                 numLinesWidth += 1;
//             }
//         }
//     }
// }
