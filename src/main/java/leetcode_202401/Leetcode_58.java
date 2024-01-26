package leetcode_202401;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * ----------------------------------------------------------------------------
 * 示例 1：
 * 输入：s = "Hello World"
 * 输出：5
 * 解释：最后一个单词是“World”，长度为5。
 * 示例 2：
 * 输入：s = "   fly me   to   the moon  "
 * 输出：4
 * 解释：最后一个单词是“moon”，长度为4。
 * 示例 3：
 * 输入：s = "luffy is still joyboy"
 * 输出：6
 * 解释：最后一个单词是长度为6的“joyboy”。
 */
public class Leetcode_58 {
    public int lengthOfLastWord(String s) {
        String trimmed = s.trim();

        int end = trimmed.length() - 1;

        while (end >= 0 && trimmed.charAt(end) != ' '){
            end--;
        }

        return trimmed.length() - end - 1;
    }

    public static void main(String[] args) {
        Leetcode_58 solution = new Leetcode_58();
        // 测试示例
        System.out.println(solution.lengthOfLastWord("Hello World"));  // Output: 5
        System.out.println(solution.lengthOfLastWord("   fly me   to   the moon  "));  // Output: 4
        System.out.println(solution.lengthOfLastWord("luffy is still joyboy"));  // Output: 6
    }
}
