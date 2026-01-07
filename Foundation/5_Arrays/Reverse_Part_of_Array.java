import java.util.Scanner;
public class Reverse_Part_of_Array {
	public static void main(String[] args) {
		Scanner scn = new  Scanner (System.in);
		 int n =scn.nextInt();
        int [] arr=new int [n];
		for(int i = 0 ;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int start= scn.nextInt();
		int end= scn.nextInt();
		reverse(arr,start,end);
		for(int i = 0 ;i<n;i++){
			System.out.print(arr[i]+" ");
		}
	}
	public static void reverse(int [] arr,int sp,int ep){
		int n = arr.length;
		for(int i=0;sp<ep;i++){
			int temp =arr[sp];
			arr[sp]=arr[ep];
			arr[ep]=temp;
			sp++;
			ep--;
		}
		
		
	} 
}