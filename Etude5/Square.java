import java.awt.Color;

public class Square {

    double scale;
    Color color;
    Corner[] corners = new Corner[4];
    int cornerIndex;


    public Square (double scale, Color color) {
        this.scale = scale;
        this.color = color;
    }

    public double getScale() {
        return this.scale;
    }

    public Color getColor() {
        return this.color;
    }

    public Corner getCorner(int index) {
        return corners[index];
    }

    public void setCorner1(Corner corner1) {
        this.corners[0] = corner1;
    }

    public void setCorner2(Corner corner2) {
        this.corners[1] = corner2;
    }

    public void setCorner3(Corner corner3) {
        this.corners[2] = corner3;
    }

    public void setCorner4(Corner corner4) {
        this.corners[3] = corner4;
    }

    public void incrementCornerIndex() {
        this.cornerIndex = this.cornerIndex + 1;
    }

    public int getCornerIndex() {
        return this.cornerIndex;
    }
    
}