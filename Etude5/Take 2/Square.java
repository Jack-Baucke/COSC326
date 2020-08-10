public class Square {

    public Coord[] corners = new Coord[4];
    public int lineIndex;
    public int cornerIndex;
    public int length;
    public Square parent;

    public Square(Coord tl, int lineIndex, int length, Square parent) {
        this.corners[0] = tl;
        this.corners[1] = new Coord(tl.getX() + length, tl.getY());
        this.corners[2] = new Coord(tl.getX(), tl.getY() + length);
        this.corners[3] = new Coord(tl.getX() + length, tl.getY() + length);
        this.lineIndex = lineIndex;
        this.length = length;
        this.parent = parent;
    }

    public Coord getCorner(int i) {
        return this.corners[i];
    }

    public void setCorner(Coord corner, int i) {
        this.corners[i] = corner;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    public int getCornerIndex() {
        return this.cornerIndex;
    }

    public void setCornerIndex(int cornerIndex) {
        this.cornerIndex = cornerIndex;
    }
    
    public Square getParent() {
        return this.parent;
    }

    public void setParent(Square parent) {
        this.parent = parent;
    }

}