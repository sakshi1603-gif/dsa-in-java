// LU: Stacks_ Max Frequency Stack
// Success rate: 24.29%
// Design a stack-like data structure that allows you to push elements onto the stack and pop the most frequent element from it.

// Implement the FreqStack class with the following methods:

// FreqStack(): Constructs an empty frequency stack.
// void push(int val): Pushes an integer val onto the top of the stack.
// int pop(): Removes and returns the most frequent element in the stack. If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.

// Input Format:
// The input begins with a series of operations to be performed on the frequency stack, each operation being either a push or pop.
// For each push operation, the input includes the integer val to be pushed.

// Output Format:
// For each pop operation, output the integer that is removed from the stack.

// Constraints:
// 0 <= val <= 109
// At most 2 * 10^4 calls will be made to push and pop.
// It is guaranteed that there will be at least one element in the stack before calling pop