package entities.items;
import utils.StringBuilder;

import java.util.Objects;

public class Item {
    protected String title;
    protected int price;
    protected int id;

    /**
     * Get id from Item object
     * @cpu O(1)
     * @ram O(1)
     * return id from Item object
     */
    public int getId() {
        return id;
    }

    /**
     * Get title from Item object
     * @cpu O(n), n - title.length
     * @ram O(n), n - title.length
     * return title from Item object
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get price from Item object
     * @cpu O(1)
     * @ram O(1)
     * return price from Item object
     */
    public int getPrice() {
        return price;
    }

    /**
     * Create object by Item class and set value for fields
     * @cpu O(n), n - title.length
     * @ram O(n), n - title.length
     * @param id argument
     * @param title argument
     * @param price argument
     * return object by Item class
     */
    public Item (int id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    /**
     * Return String with data from fields by Item
     * @cpu O(n), n - this.title.length
     * @ram O(n), n - this.title.length
     * return String with data from fields by Item
     */
    public String toString() {
        StringBuilder string = new StringBuilder()
                .append("Item{id=")
                .append(this.id)
                .append(", title='")
                .append(this.title)
                .append("', price=")
                .append(this.price)
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
        if (that == null || this.getClass() != that.getClass() ) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (Objects.equals(this.title, ((Item)that).title)
                && this.getPrice() == ((Item) that).getPrice()
                && this.getId() == ((Item) that).getId()) {
            return true;
        }
        return false;
    }
}