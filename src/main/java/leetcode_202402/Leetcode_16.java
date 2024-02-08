package leetcode_202402;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
 * ------------------------
 * 示例 1：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 */
public class Leetcode_16 {
    public static int threeSumClosest(int[] nums, int target) {
        // 对数组进行排序
        Arrays.sort(nums);

        // 初始化最接近目标值的和
        int closestSum = Integer.MAX_VALUE;

        // 遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            // 双指针
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                // 计算当前三个数的和
                int currentSum = nums[i] + nums[left] + nums[right];
                // 如果当前和更接近目标值，则更新 closestSum
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                // 根据当前和与目标值的大小关系移动指针
                if (currentSum < target) {
                    left++;
                } else if (currentSum > target) {
                    right--;
                } else {
                    // 如果当前和等于目标值，则最接近的和就是目标值，直接返回
                    return currentSum;
                }
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        System.out.println(threeSumClosest(nums1, target1)); // 输出：2

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        System.out.println(threeSumClosest(nums2, target2)); // 输出：0
    }
}
