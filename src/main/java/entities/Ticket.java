package entities;

public class Ticket {
    private int number;
    private String place;

    public Ticket (int number, String place) {
        this.number = number;
        this.place = place;
    }

    public int getNumber() {
        return number;
    }

    public String getPlace() {
        return place;
    }

    public Ticket () {
    }

    /**
     * Takes data from all fields from Object and returns it as a String value
     * @cpu O(n), n - this.place
     * @ram O(n), n - this.place
     * @return String value with data from all fields an Object
     */
    public String toString() {
        String info = "Ticket{number="  + this.number + ", " + "place='" + this.place +"'}";
        return info;
    }

    /**
     * Determines whether the objects are equivalent or not.
     * @cpu O(n), n - place.length;
     * @ram O(1)
     * @param obj argument
     * @return true if  objects are equal, false if are not.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Ticket.class) {
            return false;
        }
        Ticket that = (Ticket) obj;
        return that != null
                && (this.place == null ? that.place == null :  this.place.equals(that.place))
                && (this.number == that.number);
    }
}
