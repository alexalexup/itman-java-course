package entities;

public class Cuboid {
    public int a;
    public int b;
    public int c;

    public Cuboid (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public long calcSurfaceArea() {
        return (long)(2 * ( a * b + a * c + b * c));
    }

    public long calcVolume() {
        return (long)(a * b * c);
    }
}
