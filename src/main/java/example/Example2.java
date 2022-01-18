package example;

public class Example2 {

    public static int f (int n, int[] a) {
        int cnt = 0;
        for (int i = 0, j = 0; i < n; i++) {
            System.out.println("!!!!" + i);
            while (j < n && a[i] < a[j]) {
                j++;
                cnt++;
                System.out.print("&&&&&&" + j + " ");
            }
            System.out.println("");
        }
        return cnt;
    }
}
