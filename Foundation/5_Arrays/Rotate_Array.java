//question no 5 
// Arrays2_Rotate Array
// Success rate: 32.86%
// Given an integer array nums of size N, rotate the array to the right by k steps, where k is non-negative.

// Input Format:
// The first line contains an integer n denoting size of the array.
// Next line contains the elements of array.
// Next line contains the integer k.

// Output Format:
// Output the updated array.

// Constraints:
// 1<=N<=10^6
// 1<=k<=10^6
// -10^5<=arr[i]<=10^5
import java.util.*;
public class Rotate_Array{

    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int k = scn.nextInt();
        
        k = k%n;
        reversePart(arr,0,n-1);
        reversePart(arr,0,k-1);
        reversePart(arr,k,n-1);
        
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    public static void reversePart(int[]arr, int s, int e){
        int sp = s;
        int ep = e;
        while(sp < ep){
            int temp = arr[sp];
            arr[sp] = arr[ep];
            arr[ep] = temp;
            sp++;
            ep--;
        }

    }
}
