package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Nested
    public class CalcPerimeter {
        @Test
        public void shouldReturnPerimeterWhenSidesAreIntegerNumbers () {
            Rectangle rectangle = new Rectangle(4.0, 6.0);
            Assertions.assertEquals(2 * 4 + 2 * 6, rectangle.calcPerimeter());
        }

        @Test
        public void shouldReturnPerimeterWhenSidesAreFractionalNumbers () {
            Rectangle rectangle = new Rectangle(22.5, 42.6);
            Assertions.assertEquals(2 * 22.5 + 2 * 42.6, rectangle.calcPerimeter());
        }
    }

    @Nested
    public class CalcSquare {
        @Test
        public void shouldReturnSquareWhenSidesAreIntegerNumbers() {
            Rectangle rectangle = new Rectangle(9.0, 12.0);
            Assertions.assertEquals( 9 * 12, rectangle.calcSquare());
        }

        @Test
        public void shouldReturnSquareWhenSidesAreFractionalNumbers() {
            Rectangle rectangle = new Rectangle(16.7, 35.2);
            Assertions.assertEquals( 16.7 * 35.2, rectangle.calcSquare());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnInformationAboutRectangle() {
            Rectangle rectangle = new Rectangle(3.0, 2.0);
            Assertions.assertEquals("Rectangle{weight=3.0, height=2.0}", rectangle.toString());
        }
    }

    @Nested
    public class Equals {
        @Test
        public void shouldReturnTrueWhenBothRectanglesAreSame() {
            Rectangle firstRectangle = new Rectangle(2.0, 3.0);
            Rectangle secondRectangle = new Rectangle(2.0, 3.0);
            Assertions.assertEquals(firstRectangle, secondRectangle);
        }

        @Test
        public void shouldReturnFalseWhenRectanglesAreNotSame() {
            Rectangle firstRectangle = new Rectangle(6.0, 3.0);
            Rectangle secondRectangle = new Rectangle(2.0, 3.0);
            Assertions.assertNotEquals(firstRectangle, secondRectangle);
        }

        @Test
        public void shouldReturnFalseWhenObjectFromArgumentIsNotRectangle() {
            Rectangle rectangle = new Rectangle(6.0, 3.0);
            Circle circle = new Circle(5.0);
            Assertions.assertNotEquals(rectangle , circle);
        }

        @Test
        public void shouldReturnFalseWhenObjectFromArgumentIsNull() {
            Rectangle rectangle = new Rectangle(6.0, 3.0);
            Assertions.assertNotEquals(rectangle , null);
        }
    }
}