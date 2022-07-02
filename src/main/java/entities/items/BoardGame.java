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
}
