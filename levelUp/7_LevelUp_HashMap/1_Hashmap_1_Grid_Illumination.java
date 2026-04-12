// LU: Hashmap 1_Grid Illumination
// Success rate: 34.72%
// You are given a 2D grid of size n x n, where each cell has a lamp that is initially turned off. A 2D array lamps is provided where lamps[i] = [rowi, coli] indicates that the lamp at grid[rowi][coli] is turned on. When a lamp is turned on, it illuminates its cell and all cells in the same row, column, or diagonal.

// Another 2D array queries is provided where queries[j] = [rowj, colj]. For each query, determine if the cell grid[rowj][colj] is illuminated. After answering the query, turn off the lamp at grid[rowj][colj] and its 8 adjacent lamps if they exist.

// Return an array ans where ans[j] is 1 if the cell in the j-th query was illuminated, and 0 if it was not.

// Input Format:
// n (int): The size of the grid.
// lamps (2D array of integers): Array where each element is [rowi, coli], representing the positions of the lamps.
// queries (2D array of integers): Array where each element is [rowj, colj], representing the positions for the queries.

// Output Format:
// An array of integers ans, where each element ans[j] is 1 if the cell in the j-th query was illuminated, otherwise 0.

// Constraints:
// 1 <= n <= 109
// 0 <= lamps.length <= 20000
// 0 <= queries.length <= 20000
// lamps[i].length == 2
// 0 <= rowi, coli < n
// queries[j].length == 2
// 0 <= rowj, colj < n
