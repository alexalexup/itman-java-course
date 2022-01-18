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
     * @cpu O(1)
     * @ram O(1)
     * @return String value with data from all fields an Object
     */
    public String toString() {
        String info = "Ticket{number="  + this.number + ", " + "place='" + this.place +"'}";
        return info;
    }

    /**
     * Determines whether the tickets are equivalent or not.
     * @cpu O(1)
     * @ram O(1)
     * @param that Object by class Ticket
     * @return true if all fields from Objects are equal, false if are not.
     */
    public boolean equals(Ticket that) {
        boolean result = this.number == that.number && this.place.equals(that.place);
        return result;
    }
}
