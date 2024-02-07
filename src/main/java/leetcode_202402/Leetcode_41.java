package leetcode_202402;

/**
 * 41.缺失的第一个正整数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * ----------------------------------------------------
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 */
public class Leetcode_41 {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            while (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1)); // 输出: 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2)); // 输出: 2

        int[] nums3 = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive(nums3)); // 输出: 1
    }
}
