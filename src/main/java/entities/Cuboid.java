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
        return  2 * ((long)(a * b) + (long)(b * c) + (long)( a * c));
    }

    public long calcVolume() {
        return (long)(a * b) * (long)(c);
    }
}
