package org.example.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void backtrack(List<List<Integer>> results, List<Integer> current, int[] candidates, int target, int index) {
        if (target == 0) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] <= target) {
                current.add(candidates[i]);
                backtrack(results, current, candidates, target - candidates[i], i);
                current.removeLast();
            }
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), candidates, target, 0);
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        combinationSum(nums, target);
    }
}
