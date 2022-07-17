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

    public String toString() {
        StringBuilder string = new StringBuilder();
        return string.append("Pair{left=")
                .append(this.left)
                .append(", right=")
                .append(this.right)
                .append("}")
                .toString();
    }

    public boolean equals(Pair that) {
        if (that == null || this.right != that.right || this.left != that.left) {
            return false;
        }
        return true;
    }
}
