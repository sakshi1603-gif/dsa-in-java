// BITS 2_Divide 2 Integers
// Success rate: 29.23%
// Given two integers, dividend and divisor, divide the dividend by the divisor without using multiplication, division, or mod operators. The result should be truncated toward zero, meaning the fractional part is discarded.

// Return the quotient after dividing dividend by divisor. The result must be within the 32-bit signed integer range:
// [−2^31,2^31−1][−2^31,2 ^31 −1]. If the result exceeds this range, return the boundary value instead.

// Input Format:
// Two integers, dividend and divisor.

// Output Format:
// An integer representing the quotient of the division.

// Constraints:
// -2^31 <= dividend, divisor <= 2^31 - 1
// divisor != 0

import java.util.*;

public class lect2_3_Divide_2_Integers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int dividend = scn.nextInt();
        int divisor = scn.nextInt();

        int ans = Divide(dividend, divisor);
        System.out.println(ans);
    }

    public static int Divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = dividend;
        long b = divisor;

        int sign = 1;

        if (a < 0) sign *= -1;
        if (b < 0) sign *= -1;

        a = Math.abs(a);
        b = Math.abs(b);

        long temp = 0;
        long q = 0;

        for (int i = 31; i >= 0; i--) {
            if (temp + (b << i) <= a) {
                temp += (b << i);
                q |= (1L << i);
            }
        }

        return (int)(sign * q);
    }
}