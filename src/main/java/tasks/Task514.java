package tasks;
import collections.Stack;

public class Task514 {

    public static int solve(int[] books, int[] queue) {
        Stack stack = new Stack();
        for (int i = 0; i < books.length; i++) {
            stack.push(books[i]);
        }
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] == -1) {
                if (stack.isEmpty() == false) {
                    stack.pop();
                }
            } else {
               if (stack.isEmpty()) {
                   stack.push(1);
               } else {
                   stack.push(stack.peek() + 1);
               }
            }
        }
        return  stack.isEmpty() ? 0 : stack.peek();
    }
}
