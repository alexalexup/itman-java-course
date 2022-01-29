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

    public int getMin(int min) {
        return this.min = min;
    }

    public int getMax(int max) {
        return this.max = max;
    }

    public long getCount(int count) {
        return this.count = count;
    }

    public double getAverage(double average) {
        return this.average = average;
    }

    public double getMedian(double median) {
        return this.median = median;
    }

    public String toString() {
        String min = "min=" + this.min + ", ";
        String max = "max=" + this.max + ", ";
        String count = "count=" + this.count + ", ";
        String average = "average=" + this.average + ", ";
        String median = "median=" + this.median + "}";
        String info = "Statistic{" + min + max + count + average + median;
        return info;
    }

    public boolean equals(Statistic that) {
        return that != null ? (this.min == that.min
                && this.max == that.max && this.count == that.count
                && this.median == that.median) : false;
    }
}

