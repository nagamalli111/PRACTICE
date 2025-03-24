package org.example.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public void backtrack(List<List<Integer>> results, List<Integer> current, int[] nums, int index) {
        results.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(results, current, nums, i + 1);
            current.removeLast();
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums, 0);
        return results;
    }
}
