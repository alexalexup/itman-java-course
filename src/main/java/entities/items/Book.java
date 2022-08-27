package entities.items;
import utils.StringBuilder;

import java.util.Objects;

public class Book extends Item {
    protected String author;
    protected int pages;

    /**
     * Get author from Book object
     * @cpu O(n), n - author.length
     * @ram O(n), n - author.length
     * return author from Item object
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get pages from Book object
     * @cpu O(1)
     * @ram O(1)
     * return pages from Book object
     */
    public int getPages() {
        return pages;
    }

    /**
     * Create object by Book class and set value for fields
     * @cpu O(n + m), n - title.length, m - author.length
     * @ram O(n + m), title.length, m - author.length
     * @param id argument
     * @param title argument
     * @param price argument
     * @param author argument
     * @param pages argument
     * return object by Book class
     */
    public Book(int id, String title, int price, String author, int pages) {
        super(id, title, price);
        this.author = author;
        this.pages = pages;
    }

    /**
     * Return String with  information about Book object
     * @cpu O(n + m), n - super.title.length, m - this.author.length
     * @ram O(n + m), n - super.title.length, m - this.author.length
     * return String with data from fields by Book object
     */
    @Override
    public String toString(){
        StringBuilder string = new StringBuilder()
                .append("Book")
                .append("{")
                .append(super.toString())
                .append(", author='")
                .append(this.author)
                .append("', pages=")
                .append(this.pages)
                .append("}");
        return string.toString();
    }

    /**
     * Compare two objects
     * @cpu O(n + m), n - this.title.length, m - this.author.length
     * @ram O(1)
     * @param that object
     * return true if  objects are equal, if are not - false
     */
    @Override
    public boolean equals(Object that) {
        if (that == null || that.getClass() != Book.class ) {
            return false;
        }
        if (this == that) {
            return true;
        }
        if (Objects.equals(this.author, ((Book)that).author)
                && this.getPages() == ((Book) that).getPages()
                && super.equals((Book)that)) {
            return true;
        }
        return false;
    }
}
