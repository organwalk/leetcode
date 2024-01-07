package leetcode_202401;


import entity.ListNode;

import static entity.ListNode.printListNode;

/**
 * 19.删除链表的倒数第N个结点
 */
public class Leetcode_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 定义一个虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义快指针和慢指针
        ListNode fast = dummy;
        ListNode slow = dummy;

        // 先让快指针走n+1步
        for (int i = 0; i < n + 1; i++){
            fast = fast.next;
        }

        // 那么在快慢指针同时移动时，其慢指针总是能走到被删除节点的前一个节点
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        // 将慢指针的下一个节点指向被删除节点的下一个节点，即完成删除操作
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(head, 2);
        printListNode(result);
    }
}
