package com.coding.tree;

// leetcode 208. Implement Trie (Prefix Tree)
public class Trie {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("cap");
    trie.insert("cat");
    trie.insert("can");

    System.out.println("is cat found: " + trie.search("cat"));
    System.out.println("is cab found: " + trie.search("cab"));
  }

  private node root;

  public Trie() {
    root = new node('\0');
  }

  class node {
    private char c;
    public boolean isWord;
    public node[] children;

    public node(char c) {
      this.c = c;
      isWord = false;
      children = new node[26];
    }
  }

  // time: O(M) where M is number of characters in word, space: O(M)
  public void insert(String word) {
    node curr = root;
    for (int i=0; i<word.length(); i++) {
      char c = word.charAt(i);
      if (curr.children[c - 'a'] == null) {
        curr.children[c - 'a'] = new node(c);
      }
      curr = curr.children[c - 'a'];
    }
    curr.isWord = true;
  }

  // space: O(1)
  public boolean search(String word) {
    node n = getNode(word);
    return n != null && n.isWord;
  }

  // space: O(M)
  public boolean startsWith(String prefix) {
    return getNode(prefix) != null;
  }

  public node getRoot() {
    return root;
  }

  // helper function
  private node getNode(String word) {
    node curr = root;
    for (int i=0; i<word.length(); i++) {
      char c = word.charAt(i);

      if (curr.children[c - 'a'] == null) {
        return null;
      }
      curr = curr.children[c - 'a'];
    }
    return curr;
  }

}
