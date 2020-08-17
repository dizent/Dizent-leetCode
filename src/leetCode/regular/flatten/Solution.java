package leetCode.regular.flatten;

import java.util.LinkedList;

public class Solution {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        Node next = head.next;
        Node child = head.child;
        if(child != null){
            head.next = child;
            child.prev = head;
            head.child = null;
        }
        flatten(head.next);
        if(next != null){
            while(head.next != null){
                head = head.next;
            }
            head.next = next;
            next.prev = head;
            flatten(head.next);
        }
        return head;
    }

    public Node flatten(Node child,Node next){
        Node node = null;
        if(child != null){
            node = child;
            child.next = flatten(child.next);
        }else{
            flatten(next.next);
        }
        return node;
    }

    public static void main(String[] args) {
        Node first = new Node();
    }
}
