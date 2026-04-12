// LU: BS_ Search a 2D Matrix
// Success rate: 46.43%
// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution with a time complexity of O(log(m * n)).

// Input Format:
// The first line contains two space-separated integers m and n, representing the number of rows and columns of the matrix.
// The next m lines each contain n space-separated integers representing the elements of the matrix.
// The last line contains the integer target.

// Output Format:
// Print true if the target is found in the matrix, otherwise print false.

// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10^4 <= matrix[i][j], target <= 10^4