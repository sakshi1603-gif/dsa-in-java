// LU: Tress_Vertical Order Traversal of a Binary Tree
// Success rate: 35.48%
// Given the root of a binary tree, calculate its vertical order traversal. The root node is positioned at (0, 0). For each node at position (row, col), its left child will be at position (row + 1, col - 1), and its right child will be at position (row + 1, col + 1). The vertical order traversal is a list of top-to-bottom orderings for each column index, starting from the leftmost column and ending at the rightmost column. If multiple nodes share the same row and column, they should be sorted by their values.

// Input format:
// First line: The number of elements in the binary tree.
// Next lines: The level-order traversal of the binary tree, where -1 denotes a null node.

// Output format:
// A list of lists where each list contains nodes in the vertical order traversal, starting from the leftmost column to the rightmost column.

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.data <= 1000