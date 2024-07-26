package hello.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        float[] nums = new float[]{0.49F, 0.96F, 0.82F, 0.09F, 0.57F, 0.43F, 0.91F, 0.75F, 0.15F, 0.37F};
        bucket(nums);
        for (float num : nums){
            System.out.print(num + ",");
        }
    }
    static void bucket(float[] nums){
        int k = nums.length / 2;
        // 创建桶列表
        List<List<Float>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++){
            buckets.add(new ArrayList<>());
        }
        // 指定桶存放元素
        for (float num : nums){
            int i = (int) (num * k);
            buckets.get(i).add(num);
        }
        // 对桶内元素进行排序
        for (List<Float> bucket : buckets){
            Collections.sort(bucket);
        }
        // 合并所有桶内元素
        int i = 0;
        for (List<Float> bucket : buckets){
            for (float num : bucket){
                nums[i++] = num;
            }
        }
    }
}
