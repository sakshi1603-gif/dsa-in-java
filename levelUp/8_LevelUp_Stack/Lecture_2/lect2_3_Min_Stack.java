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
import java.util.*;

class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
    }

    public void push(int val) {
        if (st.isEmpty()) {
            min = val;
            st.push(0L);
            return;
        }

        long diff = (long) val - min;
        st.push(diff);

        if (diff < 0) {
            min = val;
        }
    }

    public void pop() {
        long diff = st.pop();

        if (diff < 0) {
            min = min - diff;
        }
    }

    public int top() {
        long diff = st.peek();

        if (diff <= 0) {
            return (int) min;
        }

        return (int) (min + diff);
    }

    public int getMin() {
        return (int) min;
    }
}

public class lect2_3_Min_Stack {
    public static void main(String[] args) {
        MinStack obj = new MinStack();

        obj.push(-2);
        obj.push(0);
        obj.push(-3);

        System.out.println("Min: " + obj.getMin()); // -3

        obj.pop();

        System.out.println("Top: " + obj.top());    // 0
        System.out.println("Min: " + obj.getMin()); // -2

        obj.push(-5);
        System.out.println("Min: " + obj.getMin()); // -5

        obj.pop();
        System.out.println("Min: " + obj.getMin()); // -2
    }
}