package entities.items;
import utils.StringBuilder;

public class Game extends Item {
    protected int playersMin;
    protected int playersMax;

    /**
     * Get playersMin from Game object
     * @cpu O(1)
     * @ram O(1)
     * return playersMin from Game object
     */
    public int getPlayersMin() {
        return playersMin;
    }

    /**
     * Get playersMax from Game object
     * @cpu O(1)
     * @ram O(1)
     * return playersMax from Game object
     */
    public int getPlayersMax() {
        return playersMax;
    }

    /**
     * Create object by Game class and set value for fields
     * @cpu O(n), n - title.length
     * @ram O(n), n - title.length
     * @param id argument
     * @param title argument
     * @param price argument
     * @param playersMin argument
     * @param playersMax argument
     * return object by Game class
     */
    public Game(int id, String title, int price, int playersMin, int playersMax) {
        super(id, title, price);
        this.playersMin = playersMin;
        this.playersMax = playersMax;
    }

    public String toString() {
        StringBuilder string = new StringBuilder()
                .append("Game")
                .append("{")
                .append(super.toString())
                .append(", playersMin=")
                .append(this.playersMin)
                .append(", playersMax=")
                .append(this.playersMax)
                .append("}");
        return string.toString();
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
        if (that == null || that.getClass() != Game.class ) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (this.getPlayersMin() == ((Game) that).getPlayersMin()
                && this.getPlayersMax() == ((Game) that).getPlayersMax()
                && super.equals((Item)that)) {
            return true;
        }
        return false;
    }
}
