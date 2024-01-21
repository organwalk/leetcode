package leetcode_202401;

import entity.TreeNode;

/**
 * 104.二叉树的最大深度
 * 给定一个二叉树 root ，返回其最大深度。
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * ----------------------------------------------------
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * 示例 2：
 * 输入：root = [1,null,2]
 * 输出：2
 */
public class Leetcode_104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            // 递归计算左右子树的深度，取较大值并加上根节点的深度
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static void main(String[] args) {
        // 示例 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        // 示例 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println(maxDepth(root1)); // Output: 3
        System.out.println(maxDepth(root2)); // Output: 2
    }
}
