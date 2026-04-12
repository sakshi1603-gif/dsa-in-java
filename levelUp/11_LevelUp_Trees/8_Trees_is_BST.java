// LU: Trees_ isBST
// Success rate: 36.36%
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

// Input Format:
// The first line contains an integer n, the number of nodes in the binary tree.
// The second line contains n space-separated integers representing the level-order traversal of the binary tree where -1 denotes a null node.

// Output Format:
// Return true if the tree is a valid BST, otherwise false.

// Constraints:
// The number of nodes in the tree is in the range [1, 104].
// -2^31 <= Node.val <= 2^31 - 1