// Arrays4_Next Greater Element 3
// Success rate: 35.90%
// Given a positive integer n, find the smallest integer which has exactly the same digits as the integer n and is greater in value than n. If no such positive integer exists, return -1.

// Note that the returned integer should fit in a 32-bit integer. If there is a valid answer but it does not fit in a 32-bit integer, return -1.

// Input Format:
// A positive integer n.

// Output Format:
// A positive integer which is the next greater integer with the same digits, or -1 if no such integer exists or the result does not fit in a 32-bit integer.

// Constraints:
// 1 <= n <= 2^31 - 1

//leetcode 556
import java.util.*;

public class lect4_4_Next_Greater_Element_3 {

    public static int nextGreaterElement(int n) {

        char[] number = (n + "").toCharArray();

        int len = number.length;

        int idx = -1;

        // Step 1: find breakpoint
        for(int i = len - 2; i >= 0; i--) {

            if(number[i] < number[i + 1]) {
                idx = i;
                break;
            }
        }

        if(idx == -1) {
            return -1;
        }

        // Step 2: find next greater digit
        int smallestidx = idx + 1;

        for(int i = idx + 1; i < len; i++) {

            if(number[i] > number[idx]
               && number[i] <= number[smallestidx]) {

                smallestidx = i;
            }
        }

        // Step 3: swap
        char temp = number[idx];
        number[idx] = number[smallestidx];
        number[smallestidx] = temp;

        // Step 4: reverse right part
        int sp = idx + 1;
        int ep = len - 1;

        while(sp < ep) {

            char box = number[sp];
            number[sp] = number[ep];
            number[ep] = box;

            sp++;
            ep--;
        }

        // Step 5: overflow check
        long ans = Long.parseLong(new String(number));

        if(ans > Integer.MAX_VALUE) {
            return -1;
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        System.out.println(nextGreaterElement(n));
    }
}