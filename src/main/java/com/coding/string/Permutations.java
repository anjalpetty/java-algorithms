package com.coding.string;

import java.util.*;

public class Permutations {

  public static void main(String[] args) {
    permute("123", "");
    permute("eat", 0, "eat".length() - 1);
    System.out.println(isAnagram("anagram", "nagaram"));
    List<List<String>> group = groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    System.out.println(group);

    System.out.println(findStringAnagrams("abbcabc", "abc"));
  }

  //  eat, aet, ate, aet, eta, tea
  // method-01
  public static void permute(String str, String anag) {

    if (str.length() == 0) {
      System.out.println(anag + " ");
      return;
    }
    for (int i=0; i< str.length(); i++) {
      char ch = str.charAt(i);
      String temp = str.substring(0, i) + str.substring(i+1);

      permute(temp, anag + ch);
    }
  }

  // method-02
  public static void permute(String str, int start, int end) {
    if (start == end) {
      System.out.println(str);
    }
    else {
      for (int i = start; i <= end; i++) {
        str = swap(str, start, i);
        permute(str, start + 1, end);
        str = swap(str, start, i);
      }
    }
  }
  private static String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }

  // approach 01 - sort and check charset
  // approach 02 - hashmap to count number of unique characters
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] s1 = s.toCharArray();
    Arrays.sort(s1);
    char[] t1 = t.toCharArray();
    Arrays.sort(t1);

    return true ? new String(s1).equals(new String(t1)) : false;
  }

  // Given an array of strings strs, group the anagrams together. You can return the answer in any order.
  // Input: strs = ["eat","tea","tan","ate","nat","bat"]
  // Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> group = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();
    for (String s: strs) {

      int[] count = new int[26];
      for (int i=0; i<s.length(); i++) {
        count[s.charAt(i)-'a']++;
      }

      StringBuilder sb = new StringBuilder();
      for (int i=0; i<count.length; i++) {
        sb.append(count[i]);
        sb.append('#');
      }
      String rep = sb.toString();
      if (!map.containsKey(rep)) {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(rep, list);
      } else {
        List<String> list = map.get(rep);
        list.add(s);
        map.put(rep, list);
      }
    }
    for (List<String> val: map.values()) {
      group.add(val);
    }
    return group;
  }

  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<String> list = new ArrayList<>();
    List<Integer> resultIndices = new ArrayList<Integer>();
    list = permutations(pattern, "", list);
    for (int i = 0; i< list.size(); i++) {
      if (str.contains(list.get(i))) {
        resultIndices.add(i);
      }
    }
    return resultIndices;
  }

  public static List<String> permutations(String str, String permute, List<String> list) {
    if (str.length() ==0) {
      list.add(permute);
    }

    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      String temp = str.substring(0, i) + str.substring(i+1);
      permutations(temp, permute+ch, list);
    }
    return list;
  }
}
