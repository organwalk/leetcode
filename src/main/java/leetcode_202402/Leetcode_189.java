package leetcode_202402;

import java.util.Arrays;

/**
 * 189.轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *示例 1:
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 */
public class Leetcode_189 {
    public static void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return ;
        }
        int n = nums.length;
        k = k % n; // 取余防止k超出数组长度后异常


        // 先翻转整个数组
        // 例如：[1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
        reverse(nums, 0, n -1);

        // 再翻转前k个元素
        // 例如：[7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
        reverse(nums, 0, k - 1);

        // 再翻转一次后k个元素，以使其保持原来顺序
        // 例如：[5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.println(Arrays.toString(nums1)); // 输出: [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.println(Arrays.toString(nums2)); // 输出: [3, 99, -1, -100]
    }
}
