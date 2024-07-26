package hello.dac;

// 基于分治实现二分查找
public class DFS {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 6, 8, 12, 15, 23, 26, 31, 35};
        int target = 6;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }

    static int dfs(int[] nums, int target, int i, int j){
        if (i > j){
            return -1;
        }
        int m = (i + j) / 2;
        if (nums[m] < target){
            return dfs(nums, target, m + 1, j);
        } else if (nums[m] > target) {
            return dfs(nums, target, i, m - 1);
        }else {
            return m;
        }
    }

    static int binarySearch(int[] nums, int target){
        int n = nums.length;
        return dfs(nums, target, 0, n - 1);
    }
}
