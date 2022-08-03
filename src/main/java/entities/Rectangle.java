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

    @Override
    public String toString() {
        return "Rectangle{weight=" + this.weight  + ", height=" + this.height +"}";
    }

    @Override
    public boolean equals (Object that) {
        if (that == null || that.getClass() != Square.class) {
            return false;
        }
        if (this.weight != ((Rectangle) that).weight || this.height != ((Rectangle) that).height ) {
            return false;
        }
        return true;
    }
}
