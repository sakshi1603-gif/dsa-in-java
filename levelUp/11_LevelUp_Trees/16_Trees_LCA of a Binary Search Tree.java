// LU: Trees_LCA of a Binary Search Tree
// Success rate: 71.43%
// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

// The lowest common ancestor is defined as the lowest node in the tree that has both the given nodes as descendants (a node can be a descendant of itself).

// Input format:
// The first line contains an integer n representing the number of nodes in the BST, including -1 for null nodes.
// The second line contains n integers representing the elements of the BST in level-order traversal (-1 represents null nodes).
// The third line contains two integers p and q, representing the values of the nodes whose LCA needs to be found.

// Output format:
// The value of the lowest common ancestor node.

// Constraints:
// The number of nodes in the tree is in the range [2, 10^5].
// -10^9 <= Node.val <= 10^9
// All Node.val are unique.
// p != q
// p and q will exist in the BST.