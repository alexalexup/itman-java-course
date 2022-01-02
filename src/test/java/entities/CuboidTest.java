package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuboidTest {

    @Test
    public void calcSurfaceAreaShouldReturnResultWhenResultIsMoreThanMaxIntRange() {
        entities.Cuboid a = new entities.Cuboid(10541, 10541, 10541);
        long actual = a.calcSurfaceArea();
        long expected = 2 * ( a.a * a.b + a.b * a.c + a.a * a.c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcSurfaceAreaShouldReturnResultWhenArgumentsHaveMinValues() {
        entities.Cuboid a = new entities.Cuboid(1, 1, 1);
        long actual = a.calcSurfaceArea();
        long expected = 2 * (a.a * a.b + a.b * a.c + a.a * a.c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcVolumeShouldReturnResultWhenResultIsMoreThanMaxIntRange() {
        entities.Cuboid a = new entities.Cuboid(1000000, 1000000, 1000000);
        long actual = a.calcVolume();
        long expected = (long)a.a * (long)a.b * (long)a.c;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calcVolumeShouldReturnResultWhenArgumentsHaveMinValues() {
        entities.Cuboid a = new entities.Cuboid(1, 1, 1);
        long actual = a.calcVolume();
        long expected = a.a * a.b * a.c;
        Assertions.assertEquals(expected, actual);
    }

}