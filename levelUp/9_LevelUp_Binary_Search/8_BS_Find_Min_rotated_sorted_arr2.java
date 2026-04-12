
// LU: BS_ Find Minimum in rotated sorted array 2
// Success rate: 67.86%
// Suppose an array of length n, sorted in ascending order, is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:

// [4,5,6,7,0,1,4] if it was rotated 4 times.
// [0,1,4,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given a sorted rotated array nums that may contain duplicates, return the minimum element of this array.

// You must write an algorithm that runs in O(log n) time.

// Input Format:
// The first line contains a single integer n denoting the number of elements in the array.
// The second line contains n space-separated integers denoting the elements of the array nums.

// Output Format:
// Print a single integer, which is the minimum element of the rotated array.

// Constraints:
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums is sorted and rotated between 1 and n times.