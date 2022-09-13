package tasks;

import collections.LinkedList;
import collections.List;
import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ShapeTaskTest {
    private double sumPerimeter(List list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + ((Shape) list.get(i)).calcPerimeter();
        }
        return sum;
    }
    @Nested
    public class AvrPerimeter {
        @Test
        public void shouldReturnAveragePerimeterWhenShapesAreRectangles() {
            LinkedList list = new LinkedList();
            list.addFirst(new Rectangle(3, 2));
            list.addFirst(new Rectangle(2, 8));
            list.addFirst(new Rectangle(3.24, 22.1));
            list.addFirst(new Rectangle(3, 2));
            Assertions.assertEquals(sumPerimeter(list) / 4, ShapeTask.calcAvrPerimeter(list));
        }

        @Test
        public void shouldReturnAveragePerimeterWhenListHaveDifferentShapes() {
            LinkedList list = new LinkedList();
            list.addFirst(new Circle(3.22));
            list.addFirst(new Square(5.66));
            list.addFirst(new Rectangle(44.5, 28.9));
            Assertions.assertEquals(sumPerimeter(list) /  3, ShapeTask.calcAvrPerimeter(list));
        }
    }

    @Nested
    public class FindMinSquareShape {
        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveSomeDifferentShapes() {
            LinkedList list = new LinkedList();
            list.addFirst(new Circle(5.6));
            list.addFirst(new Square(4.22));
            list.addFirst(new Square(5.66));
            list.addFirst(new Rectangle(6.44, 2.43));
            Object result = ShapeTask.findMinSquareShape(list);
            Assertions.assertSame(result, list.get(0));
        }

        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveSomeEqualShapes() {
            LinkedList list = new LinkedList();
            list.addFirst(new Circle(5.6));
            list.addFirst(new Square(4.22));
            list.addFirst(new Square(4.22));
            list.addFirst(new Rectangle(6.44, 2.43));
            list.addFirst(new Square(5.66));
            list.addFirst(new Rectangle(6.44, 2.43));
            Object result = ShapeTask.findMinSquareShape(list);
            Assertions.assertEquals(list.get(0), result);
        }

        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveOnlySquares() {
            LinkedList list = new LinkedList();
            list.addFirst(new Square(5.6));
            list.addFirst(new Square(4.22));
            list.addFirst(new Square(4.22));
            list.addFirst(new Square(2.43));
            list.addFirst(new Square(5.66));
            list.addFirst(new Square(6.44));
            Object result = ShapeTask.findMinSquareShape(list);
            Assertions.assertEquals(list.get(2) , result);
        }
    }
}