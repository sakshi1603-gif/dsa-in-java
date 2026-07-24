//leetcode 901 Medium
import java.util.Stack;

public class lect1_6_OnlineStockSpan {

    static class StockSpanner {

        static class Pair {
            int price;
            int span;

            Pair(int price, int span) {
                this.price = price;
                this.span = span;
            }
        }

        Stack<Pair> st;

        public StockSpanner() {
            st = new Stack<>();
        }

        public int next(int price) {
            int span = 1;

            while (!st.isEmpty() && st.peek().price <= price) {
                span += st.peek().span;
                st.pop();
            }

            st.push(new Pair(price, span));

            return span;
        }
    }

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}