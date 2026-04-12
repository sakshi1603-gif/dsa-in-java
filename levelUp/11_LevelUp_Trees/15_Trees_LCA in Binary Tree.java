// LU: Trees_LCA in Binary Tree
// Success rate: 42.86%
// You are given a Binary Tree with all unique values and two node values, n1 and n2. The task is to find the lowest common ancestor (LCA) of these two nodes. We assume that both n1 and n2 are either present in the tree or neither of them are present.

// LCA Definition: The lowest common ancestor is the deepest node in the tree that has both n1 and n2 as descendants (where we allow a node to be a descendant of itself).

// Input Format:
// An integer n representing the number of nodes, including -1 for null nodes.
// n integers representing the elements of the binary tree in level-order traversal (with -1 representing null nodes).
// Two integers, n1 and n2, representing the values of the nodes for which the LCA is to be found.

// Output Format:
// Return the data value of the lowest common ancestor of the two nodes n1 and n2.

// Constraints:
// 1 ≤ Number of nodes ≤ 10^5
// 1 ≤ Data of a node ≤ 10^5