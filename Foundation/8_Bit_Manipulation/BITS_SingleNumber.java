// You are given a non-empty array of integers, nums, where every element appears exactly twice except for one unique element that appears only once. Your task is to find and return the unique element.

// Input Format:
// An array nums of integers with the above constraints.

// Output Format:
// A single integer that represents the unique element which appears only once in the array.

import java.util.Scanner;
public class BITS_SingleNumber {
	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		int n =scn.nextInt();
		int [] arr=new int [n];
        for(int i=0 ;i<n;i++){
            arr[i]= scn.nextInt();
        }
		int num=singleNumber(arr);
		System.out.println(num);
	}
	public static int singleNumber(int [] arr){
		int xor =0;
		for(int i =0 ;i<arr.length;i++){
			xor = xor^arr[i];
		}
		return xor;
	}
}