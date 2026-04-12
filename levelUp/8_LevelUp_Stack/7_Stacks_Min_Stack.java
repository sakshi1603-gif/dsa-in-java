// LU: Stacks_ Min Stack
// Success rate: 28.74%
// Design a stack that supports the following operations: push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class with the following methods:

// MinStack(): Initializes the stack object.
// void push(int val): Pushes the element val onto the stack.
// void pop(): Removes the element on the top of the stack.
// int top(): Retrieves the top element of the stack.
// int getMin(): Retrieves the minimum element in the stack.
// The solution must have an O(1) time complexity for each function.

// Input Format:
// The input starts with a series of operations to be performed on the MinStack, each operation being either push, pop, top, or getMin.
// For each push operation, the input includes the integer val to be pushed.

// Output Format:
// For pop, top, and getMin operations, output the results as appropriate.

// Constraints:
// -2^31 <= val <= 2^31 - 1
// Methods pop, top and getMin operations will always be called on non-empty stacks.
// At most 3 * 10^4 calls will be made to push, pop, top, and getMin