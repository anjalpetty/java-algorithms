package com.coding.linked;

public class node {
  public int data;
  public node next;

  public node(int d) {
    data = d;
    next = null;
  }

  public node(int data, node next) {
    this.data = data;
    this.next = next;
  }
}