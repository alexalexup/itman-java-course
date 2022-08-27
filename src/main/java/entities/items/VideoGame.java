package entities.items;

import utils.StringBuilder;

import java.util.Objects;

public class VideoGame extends Game {
    protected String platform;

    /**
     * Get platform from VideoGame object
     * @cpu O(n), n - platform.length
     * @ram O(n), n - platform.length
     * return platform from VideoGame object
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Create object by VideoGame class and set value for fields
     * @cpu O(n + m), n - title.length, m - platform.length
     * @ram O(n + m), n - title.length, m - platform.length
     * @param id         argument
     * @param title      argument
     * @param price      argument
     * @param playersMin argument
     * @param playersMax argument
     * @param platform argument
     * @return object by VideoGame class
     */
    public VideoGame(int id, String title, int price, int playersMin, int playersMax, String platform) {
        super(id, title, price, playersMin, playersMax);
        this.platform = platform;
    }

    /**
     * Return String with data from fields by VideoGame
     * @cpu O(n + m), n - super.title.length, m - this.platform.length
     * @ram O(n + m), n - super.title.length, m - this.platform.length
     * return String with data from fields by VideoGame
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder()
                .append("VideoGame")
                .append("{")
                .append(super.toString())
                .append(", platform='")
                .append(this.platform)
                .append("'}");
        return  string.toString();

    }

    /**
     * Compare two objects
     * @cpu O(n + m), n - this.title.length, m - this.platform.length
     * @ram O(1)
     * @param that object
     * return true if  objects are equal, if are not - false
     */
    @Override
    public boolean equals(Object that) {
        if (that == null || that.getClass() != VideoGame.class) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (Objects.equals(this.platform, ((VideoGame)that).platform) && super.equals((Game)that)) {
            return true;
        }
        return false;
    }
}
