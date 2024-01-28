package leetcode_202401;

import entity.ListNode;
import static entity.ListNode.printListNode;

/**
 * 24.两两交换链表中的节点
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * ------------------------------
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 */
public class Leetcode_24 {
    public ListNode swapPairs(ListNode head) {
        //递归终止条件：当链表为空或只有一个节点时，无需交换，直接返回头节点。
        //对于每两个相邻的节点，进行交换，并递归处理后面的链表。
        //交换过程：设当前两个节点为 a 和 b，将 a.next 指向递归处理后的子链表的头部，同时 b.next 指向 a。
        //返回交换后的头节点，即 b。

        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        // 获取当前两个节点
        ListNode a = head;
        ListNode b = head.next;

        // 交换节点
        a.next = swapPairs(b.next);
        b.next = a;

        // 返回交换后的头节点
        return b;
    }

    public static void main(String[] args) {
        //输入：head = [1,2,3,4]
        //输出：[2,1,4,3]
        Leetcode_24 solution = new Leetcode_24();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        printListNode(solution.swapPairs(node));
    }
}
