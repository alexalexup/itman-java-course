package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuboidTest {

    @Test
    public void calcSurfaceAreaShouldReturnResultWhenResultIsMoreThanMaxIntRange() {
        entities.Cuboid a = new entities.Cuboid(10541, 10541, 10541);
        long actual = a.calcSurfaceArea();
        long expected = 2 * ((long)a.getA() * (long)a.getB() + (long)a.getB() * (long)a.getC()
                + (long)a.getA() * (long)a.getC());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcSurfaceAreaShouldReturnResultWhenArgumentsHaveMinValues() {
        entities.Cuboid a = new entities.Cuboid(1, 1, 1);
        long actual = a.calcSurfaceArea();
        long expected = 2 * (a.getA() * a.getB() + a.getB() * a.getC() + a.getA() * a.getC());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcVolumeShouldReturnResultWhenResultIsMoreThanMaxIntRange() {
        entities.Cuboid a = new entities.Cuboid(1000000, 1000000, 1000000);
        long actual = a.calcVolume();
        long expected = (long)a.getA() * (long)a.getB() * (long)a.getC();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcVolumeShouldReturnResultWhenArgumentsHaveMinValues() {
        entities.Cuboid a = new entities.Cuboid(1, 1, 1);
        long actual = a.calcVolume();
        long expected = a.getA() * a.getB() * a.getC();
        Assertions.assertEquals(expected, actual);
    }
}