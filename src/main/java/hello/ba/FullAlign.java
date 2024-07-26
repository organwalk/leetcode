package hello.ba;

import hello.sort.InsSort;

import java.util.ArrayList;
import java.util.List;

public class FullAlign {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> lists = permutationsI(nums);
        System.out.println(lists);
    }

    static void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res){
        // 记录状态数量与选择数量一致时保存结果
        if (state.size() == choices.length){
            res.add(new ArrayList<>(state));
            return;
        }

        // 遍历所有选择
        for(int i = 0; i < choices.length; i++){
            int choice = choices[i];
            // 剪枝
            if (!selected[i]){
                selected[i] = true;
                state.add(choice);
                backtrack(state, choices, selected, res);
                selected[i] = false;
                state.remove(state.size() - 1);
            }
        }
    }

    static List<List<Integer>> permutationsI(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
        return res;
    }
}
