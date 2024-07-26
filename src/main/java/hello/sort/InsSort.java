package hello.sort;

public class InsSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 1, 5, 2};
        for (int i = 1; i < nums.length; i++){
            int base = nums[i];
            int j = i - 1;
            while (j>=0 && nums[j] > base){
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
        for (int i : nums){
            System.out.print(i + ",");
        }
    }
}
