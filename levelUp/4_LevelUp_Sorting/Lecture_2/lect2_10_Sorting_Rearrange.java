// LU: Sorting_Rearrange SubArray
// Success rate: 50.00%
// Given N elements and [s,e], Rearrange the SubArray so that

// a) arr[s] should go to correct sorted position in [s,e]
// b) all elements <=arr[s] should go to leftside of arr[s]
// c) all elements > arr[s] should go to rightside of arr[s]

// Input Format:
// The first line contains three integers n, s and e representing the size of array. subarray start and subarray end.
// The second line contains n elements of array.

// Output Format:
// Print the array after rearranging the subarray.

// Constraints:
// 1<= N <= 10 ^ 6
// 1<= A[i] <=10 ^ 9
import java.util.*;

public class lect2_10_Sorting_Rearrange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
		int s = sc.nextInt();
        int e = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Sorting_Rearrange(arr ,s , e);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }

        sc.close();
    }
	public static void Sorting_Rearrange(int[] arr  ,int s , int e ) {
        int pivot = arr[s];
        int p1 = s+1;
        int p2 =  e;

        while (p1 <= p2) {
            if (arr[p1] <= pivot) {
                p1++;
            } else if (arr[p2] > pivot) {
                p2--;
            } else {
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;
                p1++;
                p2--;
            }
        }

        arr[s] = arr[p2];
        arr[p2] = pivot;
    }

}