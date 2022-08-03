package tasks;


import collections.LinkedList;
import entities.Circle;
import entities.Rectangle;
import entities.Square;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


class MinSquareTest {

    @Nested
    public class FindMinSquareShape {
        @Test
        public void  shouldFindShapeWithMinSquareWhenListHaveSomeDifferentShapes() {
            LinkedList list = new LinkedList();
            list.addFirst(new Circle(5.6));
            list.addFirst(new Square(4.22));
            list.addFirst(new Square(5.66));
            list.addFirst(new Rectangle(6.44, 2.43));
            Object result = MinSquare.findMinSquareShape(list);
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
            Object result = MinSquare.findMinSquareShape(list);
            Assertions.assertSame(result, list.get(0));
        }
    }
}