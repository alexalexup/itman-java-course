package entities;

public class Event {
    public int year;
    public int month;
    public int day;
    public String name;

    public Event () {
    }

    public Event (int year, int month, int day, String name) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.name = name;
   }

    public String toString() {
        String year = "year=" + this.year;
        String month= ", month=" + this.month;
        String day = ", day=" + this.day;
        String name = ", name='" + this.name + "'";
        if (this.year == 0 || this.month == 0 || this.day == 0) {
            String info = "";
            return info;
        }
        String info = "Event{" + year + month + day + name +"}";
        return info;
    }
}


