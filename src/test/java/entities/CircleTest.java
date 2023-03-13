package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;


class CircleTest {

    @Nested
    public class CalcSquare {
        @Test
        public void shouldCalculatePerimeterWhenRadiusIsFractionalNumber() {
            Circle circle = new Circle(12.5);
            Assertions.assertEquals(Math.PI * Math.pow(12.5, 2), circle.calcSquare());
        }

        @Test
        public void shouldCalculatePerimeterWhenRadiusIsIntegerNumber() {
            Circle circle = new Circle(24.0);
            Assertions.assertEquals(Math.PI * Math.pow(24, 2), circle.calcSquare());
        }
    }

    @Nested
    public class CalcPerimeter {
        @Test
        public void shouldCalculateSquareWhenRadiusIsFractionalNumber() {
            Circle circle = new Circle(104.8);
            Assertions.assertEquals(Math.PI * 2 * 104.8, circle.calcPerimeter());
        }

        @Test
        public void shouldCalculateSquareWhenRadiusIsIntegerNumber() {
            Circle circle = new Circle(84.0);
            Assertions.assertEquals(Math.PI * 2 * 84, circle.calcPerimeter());
        }
    }

    @Nested
    public class ToString {
        @Test
        public void shouldReturnStringWithDataOboutObject() {
            Circle circle = new Circle(3.6);
            Assertions.assertEquals("Circle{radius=3.6}", circle.toString());
        }
    }

    @Nested
    public class Equals {
        @Test
        public void  shouldReturnTrueWhenBothCirclesAreSame() {
            Circle firstCircle = new Circle(3.0);
            Circle secondCircle = new Circle(3.0);
            firstCircle.equals(new StringBuilder());
            Assertions.assertEquals(firstCircle,secondCircle);
        }

        @Test
        public void  shouldReturnFalseWhenCirclesAreNotSame() {
            Circle firstCircle = new Circle(2.0);
            Circle secondCircle = new Circle(3.0);
            Assertions.assertNotEquals(firstCircle,secondCircle);
        }

        @Test
        public void  shouldReturnFalseWhenObjectFromArgumentIsNotCircle() {
            Circle firstCircle = new Circle(2.0);
            Rectangle rectangle = new Rectangle(3.0, 2.0);
            Assertions.assertNotEquals(firstCircle, rectangle);
        }

        @Test
        public void shouldReturnFalseWhenComparedObjectIsNull() {
            Circle firstCircle = new Circle(12.0);
            Assertions.assertNotEquals(firstCircle, null);
        }
    }
}