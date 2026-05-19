// Arrays4_MajorityElement
// Success rate: 69.64%
// Given an array nums of size n, return the majority element.

// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// Input Format:
// An integer n representing the size of the array.
// An array of integers nums of size n.

// Output Format:
// An integer representing the majority element in the array.

// Constraints:
// n == nums.length
// 1 <= n <= 5 * 104
// -109 <= nums[i] <= 109

// Boyer–Moore Majority Voting Algorithm
import java.util.Scanner;

public class lect4_2_MajorityElement {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(MajorityElement(n, arr));
    }

    public static int MajorityElement(int n, int[] arr){
        int val = arr[0];
        int count = 1;

        for(int i = 1; i < n; i++){

            if(arr[i] == val){
                count++;
            } 
            else{
                count--;
            }

            if(count == 0){
                val = arr[i];
                count = 1;
            }
        }

        return val;
    }
}