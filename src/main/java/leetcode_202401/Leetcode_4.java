package leetcode_202401;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * ---------------------------------------------------------------------------------------
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class Leetcode_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        int[] mergedArray = new int[totalLength];

        // 合并数组
        int index1 = 0, index2 = 0, indexMerge = 0;
        // 由小到大添加
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                mergedArray[indexMerge++] = nums1[index1++];
            } else {
                mergedArray[indexMerge++] = nums2[index2++];
            }
        }

        // 将剩余的元素依次添加
        while (index1 < nums1.length) {
            mergedArray[indexMerge++] = nums1[index1++];
        }
        while (index2 < nums2.length) {
            mergedArray[indexMerge++] = nums2[index2++];
        }

        if (totalLength % 2 == 0) {
            int mid1 = totalLength / 2 - 1;
            int mid2 = totalLength / 2;
            return (mergedArray[mid1] + mergedArray[mid2]) / 2.0;
        } else {
            return mergedArray[totalLength / 2];
        }
    }

    public static void main(String[] args) {
        // 示例 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2)); // 输出：2.00000

        // 示例 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(findMedianSortedArrays(nums3, nums4)); // 输出：2.50000
    }
}
