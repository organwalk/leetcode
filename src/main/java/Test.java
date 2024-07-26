import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] tests = test(nums, 13);
        for (int i : tests){
            System.out.println(i);
        }
    }

    static int[] test(int[] nums, int target){
        int size = nums.length;
        Map<Integer, Integer> dic = new HashMap<>();
        for (int i = 0; i < size; i++){
            if (dic.containsKey(target - nums[i])){
                return new int[]{dic.get(target - nums[i]), i};
            }
            dic.put(nums[i], i);
        }
        return new int[0];
    }
}
