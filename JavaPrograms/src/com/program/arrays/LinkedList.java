package com.program.arrays;

import java.util.ListIterator;

/**
 * Implement Singly linked list.
 * 
 * @author MALLIKARJUN
 *
 */
public class LinkedList {
    
    Node head; // head of the list
    
    static class Node {
        int  value;
        Node next;
        
        Node(int value) {
            this.value = value;
            next = null;
        }
    }
    
    public void add(int value) {
        Node newNode = new Node(value); // new node to be added
        if (null == head) {
            head = newNode;
            return;
        }
        
        // traverse till the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    public void addFirst(int value) {
        Node newNode = new Node(value);
        if (null == head) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    
    public void addLast(int value) {
        add(value);
    }
    
    public void remove() {
        
    }
    
    public void reverseLinkedList() {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    public void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.addFirst(6);
        list.printList();
        
        java.util.LinkedList<Integer> l = new java.util.LinkedList<Integer>();
        ListIterator<Integer> i = l.listIterator();
        if (i.hasPrevious()) {
            System.out.println(i.previous());
        }
        
    }
    
}
