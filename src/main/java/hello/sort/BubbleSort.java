package hello.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 1, 5, 2};
        for (int i = nums.length - 1; i > 0; i--){
            boolean flag = false;
            for (int j = 0; j < i; j++){
                if (nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
            if(!flag) break;
        }
        for (int i : nums){
            System.out.print(i + ",");
        }
    }
}
