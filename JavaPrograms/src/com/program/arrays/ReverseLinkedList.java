package com.program.arrays;

import com.program.arrays.LinkedList.Node;

/**
 * Reverse a singly linked list.
 * 
 * Example
 * 
 * Input : 1->2->3->4->5->NULL
 * 
 * Output: 5->4->3->2->1->NULL
 * 
 * @author MALLIKARJUN
 *
 */
public class ReverseLinkedList {
    
    static Node reverseLinkedList(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.printList();
        list.reverseLinkedList();
        list.printList();
        list.add(6);
        list.printList();
        
    }
}
