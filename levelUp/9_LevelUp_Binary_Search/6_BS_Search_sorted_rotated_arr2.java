// LU: BS_ Search in sorted rotated array 2
// Success rate: 48.84%
// Given an integer array nums that is sorted in non-decreasing order (with possible duplicate values), it has been rotated at an unknown pivot index k (where 0 <= k < nums.length). The resulting array looks like [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]. For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at index 5 and become [4,5,6,6,7,0,1,2,4,4].

// Given the rotated array nums and an integer target, return true if target exists in nums, otherwise return false.

// You should minimize the number of overall operation steps.

// Input Format:
// n (integer): the number of elements in the array.
// nums (array of integers): the rotated array of size n.
// target (integer): the target value to search for in nums.

// Output Format:
// A boolean value true or false indicating whether the target exists in nums.

// Constraints:
// 1 <= n <= 5000
// -10^4 <= nums[i] <= 10^4
// nums is sorted and rotated at an unknown index.
// Duplicates are allowed in the array.