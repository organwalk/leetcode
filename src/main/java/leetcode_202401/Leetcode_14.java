package leetcode_202401;

import java.util.Objects;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * ------------------------------------
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Leetcode_14 {
    public static String longestCommonPrefix(String[] strs) {

        // 先排除特殊情况
        if (Objects.isNull(strs) || strs.length == 0){
            return "";
        }

        // 取第一个字符串数组的元素为一层遍历对象
        for (int i = 0; i < strs[0].length(); i++){
            // 获取当前的字母
            char current = strs[0].charAt(i);

            // 遍历所有字符串数组
            for (int j = 1; j < strs.length; j++) {
                // 如果i大于其他元素数组的边界，说明第一个元素比当前比较元素的长度更长，则匹配结束
                // 或者尝试从其他元素里匹配相同索引的值，但此值与当前需要比较的字符不一致，则匹配结束
                if (i >= strs[j].length() || strs[j].charAt(i) != current) {
                    // 从第一个元素里切割出匹配的元素
                    return strs[0].substring(0, i);
                }
            }
        }

        // 否则第一个元素都是匹配的
        return strs[0];

    }

    // 测试样例
    public static void main(String[] args) {

        // 示例 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1)); // 输出："fl"

        // 示例 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs2)); // 输出：""
    }
}
