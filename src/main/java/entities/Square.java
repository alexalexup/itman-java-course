package entities;

public class Square implements Shape {
    public double side;

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
}
