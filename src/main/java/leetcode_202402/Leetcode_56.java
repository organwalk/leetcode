package leetcode_202402;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56.合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * -------------------
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Leetcode_56 {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        // 根据区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++){
            int[] nextInterval = intervals[i];
            // 如果当前区间的结束位置大于等于下一个区间的起始位置，发生重叠
            if (currentInterval[1] >= nextInterval[0]){
                // 合并区间
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            }else {
                result.add(currentInterval);
                // 更新
                currentInterval = nextInterval;
            }
        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals1))); // 输出: [[1,6],[8,10],[15,18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        System.out.println(Arrays.deepToString(merge(intervals2))); // 输出: [[1,5]]
    }
}
