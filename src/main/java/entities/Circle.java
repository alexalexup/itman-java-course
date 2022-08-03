package entities;

public class Circle implements Shape{
    private double radius;

    public double getRadius() {
        return this.radius;
    }

    public Circle (double radius) {
        this.radius = radius;
    }

    @Override
    public double calcPerimeter() {
        return Math.PI * 2 * this.radius;
    }

    @Override
    public double calcSquare() {
        return Math.PI * Math.pow(this.radius, 2.0);
    }
}
