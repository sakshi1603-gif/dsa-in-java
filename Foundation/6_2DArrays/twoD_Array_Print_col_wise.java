import java.util.Scanner;
public class twoD_Array_Print_col_wise {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
		int m =scn.nextInt();
        int [][] arr=new int [n][m];
        for(int i=0 ;i<n;i++){
			for(int j=0;j<m;j++){
				 arr[i][j]= scn.nextInt();
			}
        }

        for(int j=0;j<m;j++){
			for(int i=0;i<n;i++){
				 System.out.print(arr[i][j]+" ");
			}
        System.out.println();  
        }

    }
}