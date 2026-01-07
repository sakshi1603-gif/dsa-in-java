import java.util.Scanner;
public class Max_element{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int [] arr=new int [n];
        for(int i=0 ;i<n;i++){
            arr[i]= scn.nextInt();
        }
		int maxelem = max(arr);
		System.out.println(maxelem);
    }
	public static int max(int[]arr ){
		int n = arr.length;
		int max=arr[0];
		for(int i=1;i<n;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		return max;
	}
}