package com.coding.string;

import java.util.Stack;

/*
 Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

An input string is valid if:

 1. Open brackets must be closed by the same type of brackets.
 2. Open brackets must be closed in the correct order.

*/
public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("()"));
    System.out.println(isValid("([{})"));
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i=0; i<s.length(); i++) {
      if (!stack.isEmpty()) {
        Character c = stack.peek();
        if (s.charAt(i) == ')' && c == '(') {
          stack.pop();
        } else if (s.charAt(i) == '}' && c == '{') {
          stack.pop();
        } else if (s.charAt(i) == ']' && c == '[') {
          stack.pop();
        } else {
          stack.push(s.charAt(i));
        }
      } else {
        stack.push(s.charAt(i));
      }
    }
    return stack.isEmpty();
  }
}
