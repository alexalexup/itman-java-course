package entities;

public class Rectangle implements Shape {
    private double weight;
    private double height;

    public Rectangle(double weight, double height) {
        this.height = height;
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calcPerimeter() {
        return this.weight * 2 + this.height * 2;
    }

    @Override
    public double calcSquare() {
        return this.weight * this.height;
    }
}
