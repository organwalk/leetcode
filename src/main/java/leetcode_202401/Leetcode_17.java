package leetcode_202401;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17.电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * --------------------------------------------------------------------
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 */
public class Leetcode_17 {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()){
            return result;
        }

        // 建立数字与字母的映射关系
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder current = new StringBuilder();

        backtrack(digits, map, 0, current, result);

        return result;

    }

    private static void backtrack(String digits, Map<Character, String> map, int index, StringBuilder current, List<String> result){

        if (index == digits.length()){
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);

        for (int i = 0; i < letters.length(); i++){
            current.append(letters.charAt(i));
            backtrack(digits, map, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23")); // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(""));    // []
        System.out.println(letterCombinations("2"));   // ["a","b","c"]
    }
}
