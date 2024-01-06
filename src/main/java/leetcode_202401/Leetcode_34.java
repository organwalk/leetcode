package leetcode_202401;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * -------------------------------------------------------------------------------------------
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class Leetcode_34 {
    private static int binarySearch(int[] nums, int target, boolean left){
        int low = 0;
        int height = nums.length;

        // 左闭右开
        while (low < height){
            int mid = low + (height - low) / 2;
            // 向左探索
            if (nums[mid] > target || (left && nums[mid] == target)){
                height = mid;
            }else {
                // 向右探索
                low = mid + 1;
            }
        }
        return low;
    }

    private static int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false) - 1;

        if (leftIndex <= rightIndex && rightIndex < nums.length && nums[leftIndex] == nums[rightIndex]){
            return new int[] {leftIndex, rightIndex};
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }
}
