package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task432Test {
    @Test
    public void FirstTest () {
        long a = 0L;
        long[] b = Task432.calcPrimeNumbers(a);
        for (int i =0; i < b.length; i++) {
            System.out.println("!!!!!  " + b[i]);
        }


    }

}