package leetcode_202401;

/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * ------------------------------------------------------
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 */
public class Leetcode_70 {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // 定义初始状态
        int[] dp = new int[n + 1];
        dp[1] = 1; // 爬1阶楼梯只有一种方法
        dp[2] = 2; // 爬2阶楼梯有两种方法

        // 基于动态规划，从第三阶开始考虑
        for (int i = 3; i <= n; i++) {
            // 每一次爬梯都可以选择1阶或2阶，即得到下面的状态转移方程
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    // 测试样例
    public static void main(String[] args) {

        // 示例 1
        int result1 = climbStairs(2);
        System.out.println(result1); // 输出: 2

        // 示例 2
        int result2 = climbStairs(3);
        System.out.println(result2); // 输出: 3
    }
}
