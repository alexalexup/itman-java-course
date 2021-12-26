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
        return  2 * ((long)a * (long)b + (long)b * (long)c + (long)a * (long)c);
    }

    public long calcVolume() {
        return (long)a * (long)b * (long)c;
    }
}
