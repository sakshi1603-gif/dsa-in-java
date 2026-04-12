import java.util.Scanner;
public class Count_Greater {
	public static void main(String[] args) {
		Scanner scn = new  Scanner (System.in);
		 int n =scn.nextInt();
        int [] arr=new int [n];
		for(int i = 0 ;i<n;i++){
			arr[i]=scn.nextInt();
		}
		int count = CountGreater(arr);
		System.out.println(count);
		
	}
	public static int CountGreater(int [] arr ){
		int n=arr.length;
		int max=arr[0];
		for(int i =0 ;i<n;i++){
			if(arr[i]>max){
				max=arr[i];
			}
		}
		int countmax=0;
		for(int i =0 ;i<n;i++){
			if(arr[i]==max){
				countmax++;
			}
		}
		return (n-countmax);
	} 
}