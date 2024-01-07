package leetcode_202401;

import entity.ListNode;

import static entity.ListNode.printListNode;

/**
 * 206.反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * ------------------------------------------------
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 */
public class Leetcode_206 {

    public static ListNode reverseList(ListNode head) {
        // 迭代法
        ListNode prev = null;
        ListNode curr = head;

//        1 -> 2 -> 3 -> 4 -> 5
        while (curr != null) {
            /*
                null -> 1 -> 2  初始
                1 -> null -> 2
                当前节点为1，上一节点为null，于是它的下一节点指向null，而上一节点变成了刚刚说明的当前节点 1（实际上的当前节点是null）
                2 -> 1 -> null -> 3
                那么下一个需要操作的节点 2，就是一开始保存的节点1的下一个节点，
                因此，节点2为当前节点，它的下一节点指向上一个节点，而上一个节点是节点1

             */
            ListNode nextTemp = curr.next;
            curr.next = prev; // 当前节点指向上一个节点
            prev = curr; // 移动后的当前节点变成上一个节点
            curr = nextTemp; // 下一次要操作的当前节点是一开始保存的下一个节点
        }

        return prev;
        /*
            -> 头插法
            ListNode newHead = null;
            while (head != null){
                // 取出原链表头节点
                ListNode node = head;
                head = head.next;

                // 头插法插入新链表
                node.next = newHead;
                newHead = node;
            }
            return newHead;
        */
    }

    public static void main(String[] args) {
        // 示例链表: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversedHead = reverseList(head);

        // 打印反转后的链表
        printListNode(reversedHead);
    }
}
