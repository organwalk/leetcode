package leetcode_202401;

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
    private static class ListNode{
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        // 头插法
//        ListNode newHead = null;
//        while (head != null){
//            // 取出原链表头节点
//            ListNode node = head;
//            head = head.next;
//
//            // 头插法插入新链表
//            node.next = newHead;
//            newHead = node;
//        }
//        return newHead;
        // 迭代法
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
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
        printList(reversedHead);
    }
}
