package leetcode_202401;

/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * ----------------------------------------------------------------------------------------
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class Leetcode_11 {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        // 利用双指针和短板效应可轻松求解
        while (left < right){
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]){
                left ++;
            }else {
                right --;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        // 示例 1
        int[] height1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result1 = maxArea(height1);
        System.out.println(result1); // 输出：49

        // 示例 2
        int[] height2 = {1, 1};
        int result2 = maxArea(height2);
        System.out.println(result2); // 输出：1
    }
}
