package tasks;

public class Task551 {

    public static Node buildLinkedList() {
       Node list = new Node (12, new Node(99, new Node(37, null,null),null),null);
       list.getNext().setPrev(list);
       list.getNext().getNext().setPrev(list.getNext());
       return list;
    }

    public static class Node {
        private int element;
        private Node next;
        private Node prev;

        public Node(int element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public Node() {
        }

        public int getElement() {
            return element;
        }

        public void setElement(int element) {
            this.element = element;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
