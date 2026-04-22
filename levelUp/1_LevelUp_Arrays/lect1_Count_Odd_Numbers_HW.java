
import java.util.*;

//when the range has given

public class lect1_Count_Odd_Numbers_HW{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int low = scn.nextInt();
        int high = scn.nextInt();
        
        int ans = CountOdd(low , high );
        System.out.println(ans);
    }
    public static int CountOdd(int low , int high) {
        if(low > high) return 0;
        return (high + 1) / 2 - low / 2;
    }
}


// when they have given the array 



// public class Count_Odd_Numbers_HW{
//     public static void main(String[] args) {
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] arr = new int[n];
//         for(int i=0;i<n;i++){
//             arr[i]=scn.nextInt();
//         }
//         int ans = CountOdd(arr );
//         System.out.println(ans);
//     }
//     public static int CountOdd(int [] arr) {
//         int count = 0;
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] % 2 != 0){
//                 count++;
//             }
//         }
//         return count;
//     }
// }