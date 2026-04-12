//Given n length array "arr". 
//Find the pair with maximum value of arr[i] - arr[j]. 
//You need to print max value of (arr[i] - arr[j]) possible and not the (i,j) itself.
import java.util.Scanner;
public class max_diff {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        int maxelem = max(arr);
        System.out.println(maxelem);
    }

    public static int max(int[] arr) {
        int n = arr.length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { 
                int diff = Math.abs(arr[i] - arr[j]);
                if (diff > max) {
                    max = diff;
                }
            }
        }
        return max;
    }
}
