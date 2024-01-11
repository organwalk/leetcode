package leetcode_202401;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * ----------------------------------------------------------------------------------------------------
 * 示例 1:
 * 输入: s = "III"
 * 输出: 3
 * 示例 2:
 * 输入: s = "IV"
 * 输出: 4
 * 示例 3:
 * 输入: s = "IX"
 * 输出: 9
 * 示例 4:
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例 5:
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Leetcode_13 {
    public static int romanToInt(String s) {

        // 创建映射表存放罗马字符及其对应值
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {

            int currentVal = romanMap.get(s.charAt(i));

            // 如果当前字符代表的数值小于下一个字符代表的数值，则减去当前值，否则加上当前值
            if (i < s.length() - 1 && currentVal < romanMap.get(s.charAt(i + 1))) {
                result -= currentVal;
            } else {
                result += currentVal;
            }
        }

        return result;
    }

    // 测试样例
    public static void main(String[] args) {
        // 示例 1
        System.out.println(romanToInt("III")); // 输出: 3

        // 示例 2
        System.out.println(romanToInt("IV")); // 输出: 4

        // 示例 3
        System.out.println(romanToInt("IX")); // 输出: 9

        // 示例 4
        System.out.println(romanToInt("LVIII")); // 输出: 58

        // 示例 5
        System.out.println(romanToInt("MCMXCIV")); // 输出: 1994
    }
}
