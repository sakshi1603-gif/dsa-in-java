// Stack_Valid Parentheses
// Success rate: 30.02%
// Given a string s that contains only the characters '(', ')', '{', '}', '[', and ']', determine if the input string is valid.

// A string is considered valid if the following conditions are met:

// Every open bracket must be closed by the same type of bracket.
// Open brackets must be closed in the correct order.
// Every close bracket must have a corresponding open bracket of the same type.

// Input Format:
// A string s containing only the characters '(', ')', '{', '}', '[', and ']'.

// Output Format:
// A boolean value True if the string is valid, otherwise False.

// 1 <= s.length <= 104
// s consists of parentheses only '()[]{}'.

import java.util.Scanner;
import java.util.Stack;
public class Stack_Valid_Parentheses {
	public static void main(String[] args) {
		Scanner scn=new  Scanner(System.in);
		String s=scn.nextLine();
		System.out.println(Valid_Parentheses(s));
	}
	public static boolean Valid_Parentheses(String s){
		Stack<Character>st=new Stack<>();
		for(int i=0;i<s.length();i++){
			if(st.size()==0||s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
				st.push(s.charAt(i));
			}else{
				if(s.charAt(i)==')'){
					if(st.peek()=='('){
						st.pop();
					}else{
						return false;
					}
				}else if(s.charAt(i)==']'){
					if(st.peek()=='['){
						st.pop();
					}else{
						return false;
					}
				}else if(s.charAt(i)=='}'){
					if(st.peek()=='{'){
						st.pop();
					}else{
						return false;
					}
				}
			}
		}
		if(st.size()==0){
			return true;
		}else{
			return false;
		}
	}
}