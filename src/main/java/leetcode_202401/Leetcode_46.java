package leetcode_202401;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * ------------------------------------------------------------------------
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class Leetcode_46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backTrack(nums, used, current, result);
        return result;

    }

    private static void backTrack(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result){
        if (current.size() == nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        // 遍历未使用的数字
        for (int i = 0; i < nums.length; i++){
            if (!used[i]){
                // 选择当前数字
                current.add(nums[i]);
                used[i] = true;

                // 递归调用，继续寻找全排列
                backTrack(nums, used, current, result);

                // 回溯，当递归返回后，移除最后添加的一个数字（因为我们只选择了一个数字进行添加）
                current.remove(current.size() - 1);
                used[i] = false;



            }
        }
    }

    public static void main(String[] args) {
        // 示例 1
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = permute(nums1);
        System.out.println(result1); // 输出：[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]

        // 示例 2
        int[] nums2 = {0, 1};
        List<List<Integer>> result2 = permute(nums2);
        System.out.println(result2); // 输出：[[0, 1], [1, 0]]

        // 示例 3
        int[] nums3 = {1};
        List<List<Integer>> result3 = permute(nums3);
        System.out.println(result3); // 输出：[[1]]
    }
}
