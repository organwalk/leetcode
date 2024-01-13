package leetcode_202401;

/**
 * 283.移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * ---------------------------------------------------------------------
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 */
public class Leetcode_283 {
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;

        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[nonZeroIndex++] = nums[i];
            }
        }

        for (int i = nonZeroIndex; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    // 测试样例
    public static void main(String[] args) {

        // 示例 1
        int[] nums1 = {0, 1, 0, 3, 12};
        moveZeroes(nums1);
        printArray(nums1); // 输出: [1, 3, 12, 0, 0]

        // 示例 2
        int[] nums2 = {0};
        moveZeroes(nums2);
        printArray(nums2); // 输出: [0]
    }

    // 打印数组的辅助方法
    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
