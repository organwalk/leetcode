package leetcode_202401;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 */
public class Leetcode_22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate("", 0, 0, n, result);
        return result;
    }

    private void generate(String current, int left, int right, int n, List<String> result) {
        // 递归终止条件
        if (left == n && right == n) {
            result.add(current);
            return;
        }

        // 尝试添加左括号
        if (left < n) {
            generate(current + '(', left + 1, right, n, result);
        }

        // 尝试添加右括号
        if (right < left) {
            generate(current + ')', left, right + 1, n, result);
        }
    }

    public static void main(String[] args) {
        Leetcode_22 solution = new Leetcode_22();
        System.out.println(solution.generateParenthesis(1));
    }
}
