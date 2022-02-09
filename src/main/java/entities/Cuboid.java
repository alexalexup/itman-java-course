package entities;

public class Cuboid {
    private int edgeA;
    private int edgeB;
    private int edgeC;

    public Cuboid (int edgeA, int edgeB, int edgeC) {
        if ( edgeA >= 0 && edgeB >= 0 && edgeC >= 0) {
            this.edgeA = edgeA;
            this.edgeB = edgeB;
            this.edgeC = edgeC;
        }
    }

    public int getEdgeA() {
        return this.edgeA;
    }

    public int getEdgeB() {
        return this.edgeB;
    }

    public int getEdgeC() {
        return this.edgeC;
    }

    /**
     * Calculate the surface area of a cuboid
     * @cpu O(1)
     * @ram O(1)
     * @return surface area of the cuboid
     */
    public long calcSurfaceArea() {
        return  2 * ((long)this.edgeA * (long)this.edgeB
                + (long)edgeB * (long)this.edgeC + (long)this.edgeA * (long)this.edgeC);
    }

    /**
     * Calculate the volume of a cuboid
     * @cpu O(1)
     * @ram O(1)
     * @return volume of the cuboid
     */
    public long calcVolume() {
        return (long)this.edgeA * (long)this.edgeB * (long)this.edgeC;
    }
}
