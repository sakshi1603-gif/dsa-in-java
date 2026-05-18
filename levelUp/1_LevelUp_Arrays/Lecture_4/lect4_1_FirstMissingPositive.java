// Arrays4_FirstMissingPositive
// Success rate: 41.16%
// Given an unsorted integer array nums, return the smallest positive integer that is not present in nums.

// You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

// Input Format:
// An integer n representing the size of the array.
// An array of integers nums of size n.

// Output Format:
// An integer representing the smallest positive integer that is not present in nums.

// Constraints:
// 1 <= nums.length <= 105
// -231 <= nums[i] <= 231 - 1
// leet code 41 interview question
import java.util.Scanner;

public class lect4_1_FirstMissingPositive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(FirstMissingPositive(n, arr));
    }

    public static int FirstMissingPositive(int n, int[] arr){

        int i = 0;

        while(i < n){

            if(arr[i] < 1 || arr[i] > n || arr[i] == i+1){
                i++;
            }
            else{

                int idx = arr[i] - 1;

                if(arr[i] == arr[idx]){
                    i++;
                }
                else{
                    int temp = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = temp;
                }
            }
        }

        for(int j = 0; j < n; j++){
            if(arr[j] != j + 1){
                return j + 1;
            }
        }

        return n + 1;
    }
}