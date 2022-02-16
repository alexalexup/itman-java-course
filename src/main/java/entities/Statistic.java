package entities;

public class Statistic {
    private int min;
    private int max;
    private long count;
    private double average;
    private double median;

    public Statistic(int min, int max, long count, double average, double median) {
        this.min = min;
        this.max = max;
        this.count = count;
        this.average = average;
        this.median = median;
    }

    public int getMin() {
        return this.min = min;
    }

    public int getMax() {
        return this.max = max;
    }

    public long getCount() {
        return this.count = count;
    }

    public double getAverage() {
        return this.average = average;
    }

    public double getMedian() {
        return this.median = median;
    }

    /**
     * Takes data from all fields from Object and returns it as a String value
     * @cpu O(1)
     * @ram O(1)
     * @return String value with data from all fields an Object
     */
    public String toString() {
        String min = "min=" + this.min + ", ";
        String max = "max=" + this.max + ", ";
        String count = "count=" + this.count + ", ";
        String average = "average=" + this.average + ", ";
        String median = "median=" + this.median + "}";
        String info = "Statistic{" + min + max + count + average + median;
        return info;
    }

    /**
     * Compare two statistics
     * @cpu O(1)
     * @ram O(1)
     * @return true when both statistics are equal, false are not equal
     */
    public boolean equals(Statistic that) {
        if ( that != null && this.min == that.min
                          && this.max == that.max
                          && this.count == that.count
                          && this.average == that.average
                          && this.median == that.median) {
            return true;
        }
        return false;
    }
}

