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

    public int setNumber(int number) {
        return this.number = number;
    }

    public Ticket () {
    }

    public String toString() {
        if (this.number == 0) {
            String info = "";
            return info;
        } else {
            String info = "Ticket{number="  + this.number + ", " + "place='" + this.place +"'}";
            return info;
        }
    }
    public boolean equals(Ticket that) {
        if ( that == null) {
            return false;
        }
        if (this.number == that.number) {
            if (this.place == null && that.place == null) {
                return true;
            } else if (this.place != null && that.place == null && this.place == null && that.place != null) {
                return false;
            } else if (this.place != null && that.place != null) {
                if (this.place.equals(that.place)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
