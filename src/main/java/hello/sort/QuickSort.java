package hello.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 3, 1, 5, 2};
        int left = 0;
        int right = nums.length - 1;
        quickSort(nums, left, right);
        for (int i : nums){
            System.out.print(i + ",");
        }
    }

    static void quickSort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    static int partition(int[] nums, int left, int right){
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && nums[j] >= nums[left]){
                j--;
            }
            while (i < j && nums[i] <= nums[left]){
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, i, left);
        return i;
    }

    static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
