// LU: DP_ Russian Doll envelope
// Success rate: 33.33%
// You are given a 2D array of integers envelopes, where envelopes[i] = [wi, hi] represents the width and the height of an envelope. One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

// Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other). Note: You cannot rotate an envelope.

// Input Format:
// envelopes is a 2D array of integers where envelopes[i] = [wi, hi] (1 ≤ wi, hi ≤ 10^5).

// Output Format:
// An integer representing the maximum number of envelopes you can Russian doll.

// Constraints:
// 1 <= envelopes.length <= 105
// envelopes[i].length == 2
// 1 <= wi, hi <= 105