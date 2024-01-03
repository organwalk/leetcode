package leetcode_202401;

import java.util.*;

/**
 * 20.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * ------------------------------------------------------------------
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 */
public class Leetcode_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char ch : s.toCharArray()){
            // 如果是右括号
            if (mapping.containsKey(ch)){
                // 判断此时栈是否为空，为空加入一个字符填充，不为空则返回栈顶元素并删除
                char top = stack.isEmpty() ? '#' : stack.pop();
                // 如果被抛出的栈顶元素不等于相应的左括号，则可以直接返回false
                if (top != mapping.get(ch)){
                    return false;
                }
            }else {
                // 如果不是右括号，则将左括号纳入栈顶
                stack.push(ch);
            }
        }
        // 最终，如果栈存在残余，则说明存在未能正确匹配的括号，返回false，否则返回true
        return stack.isEmpty();
    }




}
