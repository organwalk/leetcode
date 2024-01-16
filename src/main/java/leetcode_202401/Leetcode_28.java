package leetcode_202401;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 * ----------------------------------------------------
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 */
public class Leetcode_28 {
    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()){
            return 0;
        }

        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i<= m - n; i++){
            int j;
            for (j = 0; j < n; j++){
                if (haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
            }
            if (j == n){
                return i;
            }

        }
        return -1;

    }

    // 测试样例
    public static void main(String[] args) {

        // 示例 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int result1 = strStr(haystack1, needle1);
        System.out.println(result1); // 输出：0

        // 示例 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int result2 = strStr(haystack2, needle2);
        System.out.println(result2); // 输出：-1
    }
}
