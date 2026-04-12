// LU: BS_ Find Minimum in rotated sorted array
// Success rate: 44.00%
// Suppose you have an array of length n sorted in ascending order and then rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

// [4,5,6,7,0,1,2] if it was rotated 4 times.
// [0,1,2,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

// Given a sorted rotated array nums of unique elements, return the minimum element of this array. You must write an algorithm that runs in O(log n) time.

// Input Format:
// The first line contains an integer n, the length of the array.
// The second line contains n space-separated integers representing the elements of the array nums.

// Output Format:
// Output a single integer, which is the minimum element of the array.

// Constraints:
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// All the integers of nums are unique.
// nums is sorted and rotated between 1 and n times.