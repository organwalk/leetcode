package leetcode_202401;

/**
 * 53.最大子数组之和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * --------------------------------------------------------------------------------
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 */
public class Leetcode_53 {
    public static int maxSubArray(int[] nums) {
        // nums非空检验
        if(nums == null || nums.length == 0){
            return 0;
        }

        // 定义两个数组进行最大值存放
        int currentMax = nums[0]; // 当前子数组最大和
        int globalMax = nums[0]; // 全局最大和

        // 遍历nums数组，因为currentMax已经存储了第一个元素的值，
        // 那么为了实现前者与后者的比较，则需要从第二个元素开始
        for (int i = 1; i < nums.length; i ++){
            currentMax = Math.max(nums[i], currentMax + nums[i]); // 不断更新当前子数组最大和
            globalMax = Math.max(globalMax, currentMax); // 更新全局最大和
        }

        return globalMax;
    }

    public static void main(String[] args) {

        // 示例 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums1)); // 输出：6

        // 示例 2
        int[] nums2 = {1};
        System.out.println(maxSubArray(nums2)); // 输出：1

        // 示例 3
        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums3)); // 输出：23
    }
}
