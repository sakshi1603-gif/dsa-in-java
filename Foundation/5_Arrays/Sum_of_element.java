// question no 1 
// Arrays1_Sum of Array
// Success rate: 35.57%
// Given n length Array, You have to return sum of all the elements.

// Input Format:
// Each of the test cases have 2 lines.
// First Line contains the size of the array n, while the second contains the n elements of the array.

// Output Format:
// Return an integer which is sum of all the array elements.

// Constraints:
// 2 <= array length <= 10^5
// -10^4 <= array[i] <= 10^4

import java.util.Scanner;
public class Sum_of_element {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int [] arr=new int [n];
        for(int i=0 ;i<n;i++){
            arr[i]= scn.nextInt();
        }
        int sum=0;
        for(int i=0;i<n;i++){
            sum= sum+arr[i];
        }

        System.out.print("sum "+sum);
    }
}