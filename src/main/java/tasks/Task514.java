package tasks;
import collections.Stack;

public class Task514 {

    /**
     * Solve which books are left after passing the queue
     * @cpu O(n + m), n - books.length, m - queue.length
     * @ram O(n + m), n - books.length, m - queue.length
     * @return value of the last element from the stack
     */
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
