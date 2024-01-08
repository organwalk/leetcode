package leetcode_202401;

/**
 * 7.整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * ---------------------------------------------------------------
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class Leetcode_7 {
    public static int reverse(int x) {
        int reversed = 0;

        while (x != 0){
            int digit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)){
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }
        return reversed;
    }

    public static void main(String[] args) {

        // 示例 1
        int x1 = 123;
        System.out.println(reverse(x1)); // 输出：321

        // 示例 2
        int x2 = -123;
        System.out.println(reverse(x2)); // 输出：-321

        // 示例 3
        int x3 = 120;
        System.out.println(reverse(x3)); // 输出：21

        // 示例 4
        int x4 = 0;
        System.out.println(reverse(x4)); // 输出：0
    }
}
