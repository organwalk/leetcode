package hello.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 1, 5, 2};
        int n = nums.length;
        for (int i = 0; i < n - 1; i++){
            int k = i;
            for (int j = i + 1; j < n; j++){
                if (nums[j] < nums[k]){
                    k = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
        for (int i : nums){
            System.out.print(i + ",");
        }
    }
}
