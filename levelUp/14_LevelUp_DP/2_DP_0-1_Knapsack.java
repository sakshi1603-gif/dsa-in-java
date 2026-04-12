// LU: DP_ 0-1 Knapsack
// Success rate: 15.56%
// You are given the weights and values of items, and you need to place these items into a knapsack with a capacity W to maximize the total value in the knapsack. Each item can only be taken once. Given two integer arrays val and wt representing the values and weights of the items, respectively, and an integer W representing the knapsack's capacity, find the maximum value subset of val[] such that the sum of the corresponding weights does not exceed W. You cannot break an item, so you must either take the entire item or not at all (0-1 knapsack problem).

// Input Format:
// The first line contains an integer n representing the number of items.
// The second line contains n space-separated integers representing the values of the items.
// The third line contains n space-separated integers representing the weights of the items.
// The fourth line contains an integer W representing the capacity of the knapsack.

// Output Format:
// Print the maximum value that can be put in the knapsack.

// Constraints:
// 2 ≤ N ≤ 1000
// 1 ≤ W ≤ 1000
// 1 ≤ wt[i] ≤ 1000
// 1 ≤ val[i] ≤ 1000