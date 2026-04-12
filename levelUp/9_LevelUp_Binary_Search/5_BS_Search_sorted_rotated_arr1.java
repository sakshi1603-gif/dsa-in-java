// LU: BS_ Search in sorted rotated array 1
// Success rate: 53.33%
// You are given an integer array nums sorted in ascending order with distinct values. The array may have been rotated at an unknown pivot index such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] where 0 <= k < nums.length. Given this rotated array and an integer target, your task is to find the index of target in nums. If target is not found, return -1.
// Your solution must have a time complexity of O(log n).

// Input format:
// The first line contains an integer n representing the size of the array.
// The second line contains n space-separated integers representing the array nums.
// The third line contains an integer target.

// Output format:
// Return the index of the target if it is in the array; otherwise, return -1.

// Constraints:
// 1 <= nums.length <= 5000
// -10^4 <= nums[i] <= 10^4
// All values of nums are unique.
// nums is an ascending array that is possibly rotated.
// -10^4 <= target <= 10^4