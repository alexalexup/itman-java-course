package entities;

import utils.StringBuilder;

public class Pair {
    private int left;
    private int right;

    public Pair (int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }

    /**
     * Return String with data obout object from Pair class
     * @cpu O(1)
     * @ram O(1)
     * @return String with data obout object from Pair class
     */
    public String toString() {
        StringBuilder string = new StringBuilder();
        return string.append("Pair{left=")
                .append(this.left)
                .append(", right=")
                .append(this.right)
                .append("}")
                .toString();
    }

    /**
     * Сhecks whether the data in the objects are the same or not
     * @cpu O(1)
     * @ram O(1)
     * @return True when data from objets are same and false when are not
     */
    public boolean equals(Pair that) {
        if (that == null || this.right != that.right || this.left != that.left) {
            return false;
        }
        return true;
    }
}
