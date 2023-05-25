package utils;

import collections.AbstractList;
import collections.ArrayList;
import collections.LinkedList;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import utils.ShapeUtils;

class ShapeUtilsTest {
    private double sumPerimeter(AbstractList<Shape> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).calcPerimeter();
        }
        return sum;
    }
    @Nested
    public class AvrPerimeter {
        @Test
        public void shouldReturnAveragePerimeterWhenShapesAreRectangles() {
            LinkedList<Shape> list = new LinkedList<>();
            list.addFirst(new Rectangle(3.0, 2.0));
            list.addFirst(new Rectangle(2.0, 8.0));
            list.addFirst(new Rectangle(3.24, 22.1));
            list.addFirst(new Rectangle(3.0, 2.0));
            Assertions.assertEquals(sumPerimeter(list) / 4, ShapeUtils.calcAvrPerimeter(list));
        }

        @Test
        public void shouldReturnAveragePerimeterWhenShapesAreRectanglesAndSquare(){
            AbstractList<Shape> list = new ArrayList<>();
            list.add(new Rectangle(3.0,2.0));
            list.add(new Rectangle( 2.0, 1.0));
            list.add(new Rectangle( 2.0, 1.0));
            list.add(new Square( 10.0));
            Assertions.assertEquals(sumPerimeter(list) / 4, ShapeUtils.calcAvrPerimeter(list));
        }

        @Test
        public void shouldReturnAveragePerimeterWhenListHaveDifferentShapes() {
            LinkedList<Shape> list = new LinkedList<>();
            list.addFirst(new Circle(3.22));
            list.addFirst(new Square(5.66));
            list.addFirst(new Rectangle(44.5, 28.9));
            Assertions.assertEquals(sumPerimeter(list) /  3, ShapeUtils.calcAvrPerimeter(list));
        }
    }

    @Nested
    public class FindMinSquareShape {
        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveSomeDifferentShapes() {
            LinkedList<Shape> list = new LinkedList<>();
            list.add(new Circle(5.6));
            list.add(new Square(4.22));
            list.add(new Square(0.66));
            list.add(new Rectangle(6.44, 2.43));
            Shape result = ShapeUtils.findMinSquareShape(list);
            Assertions.assertSame(result, list.get(2));
        }

        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveSquaresAndCircles() {
            AbstractList<Shape> list = new ArrayList<>();
            list.add( new Circle(2.2));
            list.add( new Circle(5.2));
            list.add(new Square(2.0));
            list.add(new Square(1.3));
            Shape result = ShapeUtils.findMinSquareShape(list);
            Assertions.assertEquals(list.get(3), result);
        }

        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveSomeEqualShapes() {
            LinkedList<Shape> list = new LinkedList<>();
            list.add(new Circle(25.6));
            list.add(new Square(4.22));
            list.add(new Square(4.22));
            list.add(new Circle(5.6));
            list.add(new Rectangle(6.44, 2.43));
            list.add(new Square(5.66));
            list.add(new Rectangle(6.44, 2.43));
            Shape result = ShapeUtils.findMinSquareShape(list);
            Assertions.assertEquals(list.get(6), result);
        }

        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveOnlySquares() {
            AbstractList<Shape> list = new LinkedList<>();
            list.add(new Square(5.6));
            list.add(new Square(4.22));
            list.add(new Square(4.22));
            list.add(new Square(2.43));
            list.add(new Square(5.66));
            list.add(new Square(6.44));
            Shape result = ShapeUtils.findMinSquareShape(list);
            Assertions.assertEquals(list.get(3), result);

        }
    }
}