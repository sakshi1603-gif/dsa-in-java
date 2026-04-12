// LU: Trees_Delete Node in a BST
// Success rate: 12.50%
// Given a root node reference of a Binary Search Tree (BST) and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// The deletion process consists of two main stages:
// Search for the node to remove.
// If the node is found, delete the node from the tree.

// Input Format:
// An integer n representing the number of nodes, including -1 for null nodes.
// n integers representing the elements of the binary tree in level-order traversal (with -1 representing null nodes).
// An integer key representing the value of the node to be deleted.

// Output Format:
// Level-order traversal of the updated tree after deleting the node with the given key.

// Constraints:
// The number of nodes in the tree is in the range [0, 10^4].
// -10^5 <= Node.val <= 10^5
// Each node has a unique value.
// root is a valid binary search tree.
// -10^5 <= key <= 10^5