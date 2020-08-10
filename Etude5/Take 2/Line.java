import java.util.*;
import javax.swing.JFrame;
import java.awt.*;
import java.math.*;

public class Line {
    public Color colour;
    public double scale;

    public Line(Color colour, double scale) {
        this.colour = colour;
        this.scale = scale;
    }

    public Color getColour() {
        return this.colour;
    }

    public double getScale() {
        return this.scale;
    }
}