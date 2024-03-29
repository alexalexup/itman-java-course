package entities;

public class Event implements Comparable<Event> {
    private int year;
    private int month;
    private int day;
    private String name;
    private int id;

    public Event () {
    }

    public Event (int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
   }

    public Event (int id, int year, int month, int day, String name) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
    }

   public int getYear() {
        return this.year;
   }

   public int getMonth() {
        return this.month;
   }

   public int getDay() {
        return this.day;
   }

   public String getName() {
        return this.name;
   }

   public int getId() {
        return this.id;
   }

   public void setId(int id) {
        this.id = id;
   }


    /**
     * Takes data from all fields from Object and returns it as a String value
     * @cpu O(n), n - name.length
     * @ram O(n), n - name.length
     * @return String value with data from all fields an Object
     */
    public String toString() {
        String id = "id=" + this.id;
        String year = ", year=" + this.year;
        String month= ", month=" + this.month;
        String day = ", day=" + this.day;
        String name = ", name='" + this.name + "'";
        String info = "Event{"+ id + year + month + day + name +"}";
        return info;
    }

    /**
     * Determines whether the Objects are equivalent or not.
     * @cpu O(n) , n - name.length
     * @ram O(1)
     * @param obj argument
     * @return true if Objects are equal, false if are not.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Event.class) {
            return false;
        }
        Event that = (Event) obj;
        return (this.name == null ? that.name == null : this.name.equals(that.name))
                && (this.compareTo(that) == 0)
                && (this.id == that.id);
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




