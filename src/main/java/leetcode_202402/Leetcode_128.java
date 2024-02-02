package leetcode_202402;

import java.util.HashSet;
import java.util.Set;

/**
 * 128.最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * ---------------------------------------
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 */
public class Leetcode_128 {

    // 主要思路是利用一个哈希表存储所有不重复的数字
    // 再遍历数组，逐个判断数字是否是连续序列的起点
    // 如果是，则逐个循环判断往后有无连续数字再哈希表中
    // 在此过程中不断更新当前数字和当前连续序列长度
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            numSet.add(num);
        }

        int longRes = 0;

        for (int num : nums){
            if (!numSet.contains(num - 1)){
                int currentNum = num;
                int currentRes = 1;

                while (numSet.contains(currentNum + 1)){
                    currentNum ++;
                    currentRes ++;
                }

                longRes = Math.max(longRes, currentRes);
            }
        }
        return longRes;
    }

    public static void main(String[] args) {
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1)); // 输出: 4

        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2)); // 输出: 9
    }
}
