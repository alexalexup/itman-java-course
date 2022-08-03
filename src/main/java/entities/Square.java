package entities;

public class Square implements Shape {
    private double side;

    public Square (double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    @Override
    public double calcPerimeter() {
        return this.side * 4;
    }

    @Override
    public double calcSquare() {
        return Math.pow(this.side, 2);
    }

    @Override
    public String toString() {
        return "Square{side=" + this.side  + "}";
    }

    @Override
    public boolean equals (Object that) {
        if (that == null || that.getClass() != Square.class) {
            return false;
        }
        if (this.side != ((Square) that).side) {
            return false;
        }
        return true;
    }
}
