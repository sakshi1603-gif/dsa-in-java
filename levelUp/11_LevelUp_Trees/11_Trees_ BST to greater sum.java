// LU: Trees_ BST to greater sum
// Success rate: 4.17%
// Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus the sum of all keys greater than the original key in the BST.

// A binary search tree is a tree that satisfies these constraints:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Input Format:
// The first line contains an integer n representing the number of nodes in the tree (including -1 for null nodes).
// The second line contains n integers representing the level-order traversal of the tree.

// Output Format:
// Print the level-order traversal of the Greater Tree.

// Constraints:
// The number of nodes in the tree is in the range [1, 100].
// 0 <= Node.val <= 100
// All the values in the tree are unique.