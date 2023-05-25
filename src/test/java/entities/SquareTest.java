package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SquareTest {

    @Nested
    public class CalcSquare {
        @Test
        public void shouldReturnSquareWhenSideIsIntegerNumber() {
            Square square = new Square(47.0);
            Assertions.assertEquals(Math.pow(47, 2), square.calcSquare());
        }

        @Test
        public void shouldReturnSquareWhenSideIsFractionalNumber() {
            Square square = new Square(36.5);
            Assertions.assertEquals(Math.pow(36.5, 2), square.calcSquare());
        }
    }

    @Nested
    public class CalcPerimeter {
        @Test
        public void shouldReturnPerimeterWhenSideIsInteger() {
            Square square = new Square(128.0);
            Assertions.assertEquals(128 * 4, square.calcPerimeter());
        }

        @Test
        public void shouldReturnPerimeterWhenSideIsFractionalNumber() {
            Square square = new Square(44.8);
            Assertions.assertEquals(44.8 * 4, square.calcPerimeter());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnInformationAboutSquare() {
            Square square = new Square(6.0);
            Assertions.assertEquals("Square{side=6.0}", square.toString() );
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenBothSquaresAreSame() {
            Square first = new Square(3.0);
            Square second = new Square(3.0);
            Assertions.assertEquals(first, second);
        }

        @Test
        public void shouldReturnFalseWhenSquaresAreNotSame() {
            Square first = new Square(3.0);
            Square second = new Square(4.0);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldReturnFalseWhenObjectFromArgumentIsNotSquare() {
            Square first = new Square(3.0);
            Rectangle second = new Rectangle(4.0, 3.0);
            Assertions.assertNotEquals(first, second);
        }

        @Test
        public void shouldReturnFalseWhenObjectFromArgumentIsNull() {
            Square first = new Square(3.0);
            Assertions.assertNotEquals(first, null);
        }
    }
}