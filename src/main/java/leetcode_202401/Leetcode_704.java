package leetcode_202401;

/**
 * 704.二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * -------------------------------
 * 示例 1:
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 */
public class Leetcode_704 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // 找到目标值，返回下标
            } else if (nums[mid] < target) {
                left = mid + 1; // 目标值在右半部分，更新左边界
            } else {
                right = mid - 1; // 目标值在左半部分，更新右边界
            }
        }

        return -1; // 没有找到目标值，返回 -1
    }

    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 3, 5, 9, 12};
        int target1 = 9;
        int target2 = 2;

        System.out.println(search(nums1, target1)); // Output: 4
        System.out.println(search(nums1, target2)); // Output: -1
    }

}
