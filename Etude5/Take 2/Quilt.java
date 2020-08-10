import java.util.*;
import javax.swing.JFrame;
import java.awt.*;
import java.math.*;

public class Quilt extends JFrame {

    public static ArrayList<Line> lines = new ArrayList<Line>();
    public static int frameSize;
    public static int i = 0;
    public static Square current = null;
    public static int squareCount = 0;
    public static int squareLimit;

    public Quilt() {
        setSize(frameSize, frameSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        double scale;
        double total = 0;
        Color colour;
        

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            String[] input = scanner.nextLine().split(" ");
            scale = Double.parseDouble(input[0]);
            total += scale;
            // System.out.println(scale);
            colour = new Color(Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]));
            // System.out.println(colour.toString());
            lines.add(new Line(colour, scale));
            
        }

        int prev = 0;
        for (int j = 0; i < lines.size(); j++) {
            if (j == 0) {
                prev = 1;
                squareLimit += prev;
            } else {
                prev *= 4;
                squareLimit += prev;
            }
        }

        frameSize = (int) Math.round(total * 100);
        new Quilt();

    }

    public void paint(Graphics g) {

        while(squareCount < squareLimit) {

            g.setColor(lines.get(i).getColour());

            if (squareCount == 0) {                

                int x = (int) Math.round(frameSize - (lines.get(i).getScale() * 100)) / 2;
                int y = (int) Math.round(frameSize - (lines.get(i).getScale() * 100)) / 2;
                int length = (int) Math.round(lines.get(i).getScale() * 100); 

                g.fillRect(x, y, length, length);
                squareCount++;
                current = new Square(new Coord(x, y), i, length, null);

            } else {

                if (current.getCornerIndex() < 4) {
                    int length = (int) Math.round(lines.get(i).getScale() * 100);
                    int x = current.getParent().getCorner(current.getCornerIndex()).getX() - length/2;
                    int y = current.getParent().getCorner(current.getCornerIndex()).getY() - length/2;
                    g.fillRect(x, y, length, length);
                    squareCount++;
                    current.setCornerIndex(current.getCornerIndex() + 1);
                    current = new Square(new Coord(x, y), i, length, current);
                } else {
                    current = current.getParent();
                    i--;
                }              
            }
            i++;
        }
    }
}