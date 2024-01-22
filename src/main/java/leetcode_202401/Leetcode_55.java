package leetcode_202401;

/**
 * 55.跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * -------------------------------------------------------------
 * 示例 1：
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 */
public class Leetcode_55 {
    public static boolean canJump(int[] nums) {
        int maxReach = 0; // 记录当前可以到达的最远位置

        for (int i = 0; i < nums.length; i++) {
            // 判断是否可以到达当前位置
            if (i > maxReach) {
                return false;
            }

            // 更新最远位置
            maxReach = Math.max(maxReach, i + nums[i]);

            // 如果最远位置已经到达或超过数组末尾，说明可以到达最后一个下标
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4};
        int[] nums2 = {3, 2, 1, 0, 4};

        System.out.println(canJump(nums1)); // Output: true
        System.out.println(canJump(nums2)); // Output: false
    }
}
