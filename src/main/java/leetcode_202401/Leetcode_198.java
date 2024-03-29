package leetcode_202401;

/**
 * 198.打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * ------------------------------------------------------------------------------------
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Leetcode_198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // 创建动态规划数组
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 动态规划递推
        for (int i = 2; i < n; i++) {
            // 偷窃当前房屋：那么前一个房屋就不能偷窃，因此偷窃金额为 dp[i-2] + nums[i]。
            // 不偷当前房屋：那么偷窃金额为前一个房屋的偷窃金额，即 dp[i-1]。
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Leetcode_198 solution = new Leetcode_198();

        System.out.println(solution.rob(new int[]{1,2,3,1}));   //Output: 4
        System.out.println(solution.rob(new int[]{2,7,9,3,1})); //Output: 12
    }
}
