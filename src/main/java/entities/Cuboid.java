package entities;

public class Cuboid {
    private int a;
    private int b;
    private int c;

    public Cuboid (int a, int b, int c) {
        if ( a >= 0 && b >= 0 && c >= 0) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public long calcSurfaceArea() {
        return  2 * ((long)a * (long)b + (long)b * (long)c + (long)a * (long)c);
    }

    public long calcVolume() {
        return (long)a * (long)b * (long)c;
    }
}
