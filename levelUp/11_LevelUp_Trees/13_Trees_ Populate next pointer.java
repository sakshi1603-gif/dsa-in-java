// LU: Trees_ Populate next pointer to Right
// Success rate: 6.45%
// You are given a perfect binary tree where all leaves are at the same level, and every parent node has two children. The task is to populate each node's next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL. Initially, all next pointers are set to NULL.

// Input Format:
// The first line contains an integer n denoting the total number of nodes (including null nodes represented by -1).
// The second line contains n integers representing the node values of the binary tree in level order, with -1 for null nodes.

// Output Format:
// Print the tree level-wise, but for each node, print its value followed by its next pointer value (if it exists) or null (if no next).

// Constraints:
// The number of nodes in the tree is in the range [0, 212 - 1].
// -1000 <= Node.val <= 1000