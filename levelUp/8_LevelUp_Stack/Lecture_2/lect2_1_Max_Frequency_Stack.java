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
import java.util.HashMap;
import java.util.Stack;

class FreqStack {
    HashMap<Integer, Stack<Integer>> st;
    HashMap<Integer, Integer> freq;
    int maxfreq;

    public FreqStack() {
        st = new HashMap<>();
        freq = new HashMap<>();
        maxfreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0);
        f++;
        freq.put(val, f);

        if (!st.containsKey(f)) {
            st.put(f, new Stack<>());
        }

        maxfreq = Math.max(maxfreq, f);
        st.get(f).push(val);
    }

    public int pop() {
        int ans = st.get(maxfreq).pop();

        int f = freq.get(ans);
        f--;
        freq.put(ans, f);

        if (st.get(maxfreq).isEmpty()) {
            st.remove(maxfreq);
            maxfreq--;
        }

        return ans;
    }
}

public class lect2_1_Max_Frequency_Stack {
    public static void main(String[] args) {
        FreqStack fs = new FreqStack();

        fs.push(5);
        fs.push(7);
        fs.push(5);
        fs.push(7);
        fs.push(4);
        fs.push(5);

        System.out.println(fs.pop()); // 5
        System.out.println(fs.pop()); // 7
        System.out.println(fs.pop()); // 5
        System.out.println(fs.pop()); // 4
    }
}