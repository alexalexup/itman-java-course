package entities;

public class Event {
    private int year;
    private int month;
    private int day;
    private String name;

    public Event () {
    }

    public Event (int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
   }

   public int getYear() {
        return year;
   }

   public int getMonth() {
        return month;
   }

   public int getDay() {
        return day;
   }

   public String getName() {
        return this.name;
   }

    /**
     * Takes data from all fields from Object and returns it as a String value
     * @cpu O(n), n - name.length
     * @ram O(n), n - name.length
     * @return String value with data from all fields an Object
     */
    public String toString() {
        String year = "year=" + this.year;
        String month= ", month=" + this.month;
        String day = ", day=" + this.day;
        String name = ", name='" + this.name + "'";
        String info = "Event{" + year + month + day + name +"}";
        return info;
    }

    /**
     * Determines whether the events are equivalent or not.
     * @cpu O(n) , n - name.length
     * @ram O(1)
     * @param that Object by class Event
     * @return true if all fields from Objects are equal, false if are not.
     */
    public boolean equals(Event that) {
        return that != null
                && (this.name == null ? that.name == null : this.name.equals(that.name))
                && (this.compareTo(that) == 0);
    }

    /**
     * Compares the dates of two events
     * @cpu O(1)
     * @ram O(1)
     * @param that Object by class Event
     * @return zero if events are equal, positive number if that event is less, negative number if that event is bigger
     */
    public int compareTo(Event that) {
        if ((this.year == that.year) && (this.month == that.month) && (this.day == that.day)){
            return 0;
        }
        if ((this.year > that.year) ||
                (this.year == that.year && this.month > that.month) ||
                (this.year == that.year && this.month == that.month && this.day > that.day)) {
            return 1;
        }
        return -1;
    }
}




