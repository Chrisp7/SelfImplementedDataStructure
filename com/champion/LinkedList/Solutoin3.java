package com.champion.LinkedList;

/**
 * Using recursive to remove value from a linkedlist
 * Created by CP on 09/08/2018.
 */
public class Solutoin3 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
            return head;
        }else{
            if (head.val==val){
                return removeElements(head.next,val);
            }else {
                head.next=removeElements(head.next,val);
                return head;
            }
        }
    }
}
