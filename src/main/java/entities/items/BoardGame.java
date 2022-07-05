package entities.items;

import utils.StringBuilder;

public class BoardGame extends Game {
    protected int timeMin;
    protected int timeMax;

    /**
     * Get timeMin from BoardGame object
     * @cpu O(1)
     * @ram O(1)
     * return timeMin from BoardGame object
     */
    public int getTimeMin() {
        return timeMin;
    }

    /**
     * Get timeMax from BoardGame object
     * @cpu O(1)
     * @ram O(1)
     * return timeMax from BoardGame object
     */
    public int getTimeMax() {
        return timeMax;
    }

    /**
     * Create object by BoardGame class and set value for fields
     * @cpu O(n), n - title.length
     * @ram O(n), n - title.length
     * @param id         argument
     * @param title      argument
     * @param price      argument
     * @param playersMin argument
     * @param playersMax argument
     * @param timeMin argument
     * @param timeMax argument
     * @return object by BoardGame class
     */
    public BoardGame (int id, String title, int price, int playersMin, int playersMax, int timeMin, int timeMax) {
        super(id, title, price, playersMin, playersMax);
        this.timeMax = timeMax;
        this.timeMin = timeMin;
    }

    /**
     * Return String with data from fields by BoardGame
     * @cpu O(n), n - super.title.length
     * @ram O(n), n - super.title.length
     * return String with data from fields by BoardGame
     */
    public String toString() {
        StringBuilder string = new StringBuilder()
                .append("BoardGame")
                .append("{")
                .append(super.toString())
                .append(", timeMin=")
                .append(this.timeMin)
                .append(", timeMax=")
                .append(this.timeMax)
                .append("}");
        return string.toString();
    }

    /**
     * Compare fields from objects by Game class
     * @cpu O(n), n - this.title.length
     * @ram O(1)
     * @param that object by Game class
     * return true if  fields from objects are equal, if are not - false
     */
    protected boolean compareBoardGameFields(BoardGame that) {
        if (this.getTimeMin() ==  that.getTimeMin() && this.getTimeMax() == that.getTimeMax()) {
            return true;
        }
        return false;
    }

    /**
     * Compare two objects
     * @cpu O(n), n - this.title.length
     * @ram O(1)
     * @param that object
     * return true if  objects are equal, if are not - false
     */
    @Override
    public boolean equals(Object that) {
        if (that == null || that.getClass() != BoardGame.class ) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (this.compareItemFields((Item) that)
                && this.compareGameFields((Game) that)
                && this.compareBoardGameFields((BoardGame) that)) {
            return true;
        }
        return false;
    }
}
