package leetcode_202401;

/**
 * 9.回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * -----------------------------------------------------------
 * 示例 1：
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Leetcode_9 {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false; // 负数或以 0 结尾的非零数字不可能是回文数
        }

        int reversed = 0;
        int original = x;

        while (x > 0) {
            int digit = x % 10; // 取模运算求余，即取末位数，例如121，商位12，余为1
            x /= 10; // 移除末位，例如121，除以10得12.1，取整数位12
            reversed = reversed * 10 + digit; // 将新数移动至反转数末尾，例如反转数为12，乘10得120，加上新末位数1为121
        }

        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
