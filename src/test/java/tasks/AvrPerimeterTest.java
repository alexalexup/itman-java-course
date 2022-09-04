package tasks;

import collections.LinkedList;
import collections.List;
import entities.Circle;
import entities.Rectangle;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import entities.Shape;

class AvrPerimeterTest {
    private double sumPerimeter(List list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum = sum + ((Shape) list.get(i)).calcPerimeter();
        }
        return sum;
    }

    @Nested
    public class CalcAvrPerimeter {
        @Test
        public void shouldReturnAveragePerimeterWhenShapesAreRectangles() {
            LinkedList list = new LinkedList();
            list.addFirst(new Rectangle(3, 2));
            list.addFirst(new Rectangle(2, 8));
            list.addFirst(new Rectangle(3.24, 22.1));
            list.addFirst(new Rectangle(3, 2));
            Assertions.assertEquals(sumPerimeter(list) / 4, AvrPerimeter.calcAvrPerimeter(list));
        }

        @Test
        public void shouldReturnAveragePerimeterWhenListHaveDifferentShapes() {
            LinkedList list = new LinkedList();
            list.addFirst(new Circle(3.22));
            list.addFirst(new Square(5.66));
            list.addFirst(new Rectangle(44.5, 28.9));
            Assertions.assertEquals(sumPerimeter(list) /  3, AvrPerimeter.calcAvrPerimeter(list));
        }
    }
}