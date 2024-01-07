package leetcode_202401;

import entity.ListNode;

import static entity.ListNode.printListNode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * --------------------------------------------------------------------------
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 */
public class Leetcode_21 {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 创建虚拟头结点，并将当前指针指向虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 遍历两个链表
        while (l1 != null && l2 != null){
            // 当l1节点的值小于或等于l2节点的值时
            // 将当前指针的下一个指针指向l1节点，而原本的l1则变成原l1节点的下一个节点
            if (l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }else {
                current.next = l2;
                l2 = l2.next;
            }
            // current是从虚拟头节点出发的，于是总是需要更新为最新状态，即其下一个节点
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        // 示例 1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode mergedList = mergeTwoLists(l1, l2);
        printListNode(mergedList);

        // 示例 2
        ListNode mergedEmptyLists = mergeTwoLists(null, null);
        printListNode(mergedEmptyLists);

        // 示例 3
        ListNode l4 = new ListNode(0);

        ListNode mergedSingleEmptyList = mergeTwoLists(null, l4);
        printListNode(mergedSingleEmptyList);
    }
}
