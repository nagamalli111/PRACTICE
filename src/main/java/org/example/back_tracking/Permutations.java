package org.example.back_tracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public void backtrack(List<List<Integer>> results, List<Integer> current, int[] nums, boolean[] used) {
        if (current.size() == nums.length) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;

            current.add(nums[i]);
            used[i] = true;
            backtrack(results, current, nums, used);
            current.removeLast();
            used[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(results, new ArrayList<>(), nums, new boolean[nums.length]);
        return results;
    }
}
