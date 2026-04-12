// LU: BS_ Capacity to Ship Packages
// Success rate: 35.59%
// You are given a conveyor belt with packages that need to be shipped from one port to another within a specified number of days. The i-th package on the conveyor belt has a weight of weights[i]. Each day, you can load the ship with packages from the conveyor belt in the given order, but the total weight loaded on the ship each day cannot exceed the ship's maximum weight capacity. Your task is to find the minimum weight capacity of the ship that allows all the packages to be shipped within the given number of days.

// Input Format:
// int[] weights: An array of integers representing the weights of the packages.
// int days: An integer representing the number of days within which all packages must be shipped.

// Output Format:
// int: The minimum weight capacity of the ship that allows all packages to be shipped within the specified number of days.

// Constraints:
// 1 <= days <= weights.length <= 5 * 10^4
// 1 <= weights[i] <= 500