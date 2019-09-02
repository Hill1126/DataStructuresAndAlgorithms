package cn.hill.linkedlist.LinkedListUtils;

import cn.hill.linkedlist.node.SingleLinkedNode;
import org.junit.Test;

/**
 * @author HILL
 * @version V1.0
 * @date 2019/8/2
 * 链表创建工具
 **/
public class LinkedListUtils {

    /**
     *
     * @Author: HILL
     * @date: 2019/8/2 16:01
     * @param: [arr]
     * @return: cn.hill.linkedlist.node.SingleLinkedNode 单向链表的头节点
     *
    **/
    public static SingleLinkedNode creatSingleList( int[] arr ){
        SingleLinkedNode<Integer> head = new SingleLinkedNode<>();
        SingleLinkedNode<Integer> tail = head;
        if (arr != null && arr.length>0){
            for (int i=0;i<arr.length;i++){
                SingleLinkedNode<Integer> node = new SingleLinkedNode<>();
                node.value = arr[i];
                tail.next = node;
                tail = node;
            }
            return head.next;

        }else {
            return null;
        }

    }

    @Test
    public void fun(){
        int[] arr = {1,2,3,};
        printLinked(LinkedListUtils.creatSingleList(arr));
    }

    public static void printLinked(SingleLinkedNode head) {
        SingleLinkedNode singleLinkedNode =  head;
        while (singleLinkedNode!=null){
            System.out.print(singleLinkedNode.value+"-");
            singleLinkedNode = singleLinkedNode.next;
        }
        System.out.println();
    }
}
