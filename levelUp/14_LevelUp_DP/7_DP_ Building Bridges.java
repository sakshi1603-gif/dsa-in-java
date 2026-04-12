// LU: DP_ Building Bridges
// Success rate: 14.29%
// Consider a 2D map with a horizontal river passing through its center. There are n cities on the southern bank with x-coordinates a(1) … a(n) and n cities on the northern bank with x-coordinates b(1) … b(n). You want to connect as many north-south pairs of cities as possible with bridges such that no two bridges cross. Each city on the northern bank can only be connected to the corresponding city on the southern bank based on their order. The goal is to determine the maximum number of bridges that can be built under these constraints.

// Input format:
// n (number of cities)
// n integers representing the northern x-coordinates
// n integers representing the southern x-coordinates

// Output format:
// Maximum number of non-crossing bridges that can be built.

// Constraints:
// 1 ≤ n ≤ 1000
// 1 ≤ a_i, b_i ≤ 10^9