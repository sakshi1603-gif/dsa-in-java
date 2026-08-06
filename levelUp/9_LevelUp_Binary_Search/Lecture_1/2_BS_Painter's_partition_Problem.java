// LU: BS_ Painter's partition Problem
// Success rate: 38.82%
// Dilpreet wants to paint his dog's home, which consists of n boards of different lengths. The length of the i-th board is given by arr[i], where arr[] is an array of n integers. He hired k painters for the job, and each painter takes 1 unit time to paint 1 unit length of the board. The goal is to find the minimum time required to paint all the boards if all painters start together, with the constraint that each painter can only paint a continuous section of the boards (e.g., boards numbered {2,3,4} or only board {1}, but not boards {2,4,5}).

// Input Format:
// The first line contains an integer n, the number of boards.
// The second line contains n space-separated integers representing the lengths of the boards.
// The third line contains an integer k, the number of painters.
// Output Format:
// Print the minimum time required to paint all the boards.

// Constraints:
// 1 ≤ n ≤ 10^5
// 1 ≤ k ≤ 10^5
// 1 ≤ arr[i] ≤ 10^5