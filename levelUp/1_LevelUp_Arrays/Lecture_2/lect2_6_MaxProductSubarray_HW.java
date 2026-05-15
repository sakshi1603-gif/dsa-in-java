import java.util.Scanner;

public class lect2_6_MaxProductSubarray_HW {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(MaxProductSubarray(n, arr));
    }

    public static int MaxProductSubarray(int n, int[] arr){

        int prefixProd = 1;
        int max1 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){

            if(prefixProd == 0){
                prefixProd = arr[i];
            } else{
                prefixProd *= arr[i];
            }

            max1 = Math.max(max1, prefixProd);
        }

        int suffixProd = 1;
        int max2 = Integer.MIN_VALUE;

        for(int i = n-1; i >= 0; i--){

            if(suffixProd == 0){
                suffixProd = arr[i];
            } else{
                suffixProd *= arr[i];
            }

            max2 = Math.max(max2, suffixProd);
        }

        return Math.max(max1, max2);
    }
}