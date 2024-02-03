package leetcode_202402;

import java.util.*;

/**
 * 438.找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * ------------------------------------------------
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 */
public class Leetcode_438 {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        // 初始化 p 的字符计数哈希表
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = p.length(); // 记录需要匹配的字符个数

        // 遍历字符串 s
        while (right < s.length()) {
            char currentChar = s.charAt(right);

            // 如果当前字符在 p 的哈希表中存在，说明是需要匹配的字符，更新计数
            if (pMap.containsKey(currentChar)) {
                pMap.put(currentChar, pMap.get(currentChar) - 1);
                if (pMap.get(currentChar) >= 0) {
                    count--;
                }
            }

            // 如果窗口大小达到 p 的长度，检查是否找到了异位词
            if (right - left == p.length() - 1) {
                if (count == 0) {
                    result.add(left);
                }

                char leftChar = s.charAt(left);

                // 移动窗口左边界，更新计数
                if (pMap.containsKey(leftChar)) {
                    pMap.put(leftChar, pMap.get(leftChar) + 1);
                    if (pMap.get(leftChar) > 0) {
                        count++;
                    }
                }

                left++; // 缩小窗口
            }

            right++; // 扩大窗口
        }

        return result;
    }

    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String p1 = "abc";
        System.out.println(findAnagrams(s1, p1)); // 输出: [0, 6]

        String s2 = "abab";
        String p2 = "ab";
        System.out.println(findAnagrams(s2, p2)); // 输出: [0, 1, 2]
    }
}
