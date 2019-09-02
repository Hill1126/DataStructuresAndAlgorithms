package cn.hill.linkedlist.demo;

import cn.hill.linkedlist.LinkedListUtils.LinkedListUtils;
import cn.hill.linkedlist.node.SingleLinkedNode;

/**
 * @author HILL
 * @version V1.0
 * @date 2019/8/2
 **/
public class SingleLinkedDemo {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        SingleLinkedNode head = LinkedListUtils.creatSingleList(arr);
        LinkedListUtils.printLinked(head);
        deleteTail(head);
        LinkedListUtils.printLinked(head);
        deleteByIndex(head,4);
    }

    public static void deleteTail(SingleLinkedNode head){
        if (head == null){
            return;
        }
        while (head.next.next!=null){
            head = head.next;
        }
        head.next = null;
    }

    public static SingleLinkedNode deleteHead(SingleLinkedNode head){
        if (head!=null){
            head = head.next;
            return head;
        }
        return null;

    }

    /**
     *
     * @Author: HILL
     * @date: 2019/8/2 16:48
     * @param: [head, index]  要删除的链表和该链表所在的位置。（以0作为起点）
     * @return: void
    **/
    public static void deleteByIndex(SingleLinkedNode head,int index){
        if(head==null || index<0){
            return;
        }
        //创建一个哨兵
        SingleLinkedNode sentry = new SingleLinkedNode();
        sentry.next = head;

        int current = 0;
        while (current<index-1){
            sentry = sentry.next;
            current++;
        }
        SingleLinkedNode next = sentry.next.next;
        sentry.next = next;
        LinkedListUtils.printLinked(head);

    }

}
