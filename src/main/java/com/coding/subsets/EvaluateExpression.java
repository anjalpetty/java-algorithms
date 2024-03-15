package com.coding.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find all possible ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.

Input: "1+2*3"
Output: 7, 9
Explanation:
  1+(2*3) => 7
  (1+2)*3 => 9

Input: "2*3-4-5"
Output: 8, -12, 7, -7, -3
Explanation:
  2*(3-(4-5)) => 8
  2*(3-4-5) => -12
  2*3-(4-5) => 7
  2*(3-4)-5 => -7
  (2*3)-4-5 => -3
 */
class EvaluateExpression {

  public static void main(String[] args) {
    List<Integer> result = diffWaysToEvaluateExpression("1+2*3");
    System.out.println("Expression evaluations: " + result);

    result = diffWaysToEvaluateExpression2("2*3-4-5");
    System.out.println("Expression evaluations: " + result);
  }

  public static List<Integer> diffWaysToEvaluateExpression(String input) {
    List<Integer> result = new ArrayList<>();
    // base case: if the input string is a number, parse and add it to output.
    if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
      result.add(Integer.parseInt(input));
    } else {
      for (int i = 0; i < input.length(); i++) {
        char chr = input.charAt(i);
        if (!Character.isDigit(chr)) {
          // break the equation here into two parts and make recursively calls
          List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
          List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
          for (int part1 : leftParts) {
            for (int part2 : rightParts) {
              if (chr == '+')
                result.add(part1 + part2);
              else if (chr == '-')
                result.add(part1 - part2);
              else if (chr == '*')
                result.add(part1 * part2);
            }
          }
        }
      }
    }
    return result;
  }

  // memoization map
  static Map<String, List<Integer>> map = new HashMap<>();

  public static List<Integer> diffWaysToEvaluateExpression2(String input) {
    if (map.containsKey(input))
      return map.get(input);
    List<Integer> result = new ArrayList<>();
    // base case: if the input string is a number, parse and return it.
    if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
      result.add(Integer.parseInt(input));
    } else {
      for (int i = 0; i < input.length(); i++) {
        char chr = input.charAt(i);
        if (!Character.isDigit(chr)) {
          List<Integer> leftParts = diffWaysToEvaluateExpression2(input.substring(0, i));
          List<Integer> rightParts = diffWaysToEvaluateExpression2(input.substring(i + 1));
          for (int part1 : leftParts) {
            for (int part2 : rightParts) {
              if (chr == '+')
                result.add(part1 + part2);
              else if (chr == '-')
                result.add(part1 - part2);
              else if (chr == '*')
                result.add(part1 * part2);
            }
          }
        }
      }
    }
    map.put(input, result);
    return result;
  }
}