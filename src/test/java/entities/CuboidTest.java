package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuboidTest {

    @Nested
    public class caclSurfaceArea {
        @Test
        public void shouldReturnResultWhenResultIsMoreThanMaxIntRange() {
            entities.Cuboid a = new entities.Cuboid(10541, 10541, 10541);
            long actual = a.calcSurfaceArea();
            long expected = 2 * (10541L * 10541L + 10541L * 10541L
                    + 10541L * 10541L);
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnResultWhenArgumentsHaveMinValues() {
            entities.Cuboid a = new entities.Cuboid(1, 1, 1);
            long actual = a.calcSurfaceArea();
            long expected = 6;
            Assertions.assertEquals(expected, actual);
        }

        @Test
        public void shouldReturnResultWhenResultIsMaxValue() {
            entities.Cuboid a = new entities.Cuboid(1000000, 1000000, 1000000);
            long actual = a.calcVolume();
            long expected = 1000000L * 1000000L * 1000000L;
            Assertions.assertEquals(expected, actual);
        }
    }
}