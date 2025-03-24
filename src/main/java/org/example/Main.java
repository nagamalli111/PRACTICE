package org.example;

import java.util.*;
class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            dp[1][i] += dp[1][i - 1] + skill[i - 1] * mana[0];
        }

        for (int i = 2; i <= m; i++) {

            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j + 1], dp[i][j + 1] - (mana[i - 1] * skill[j]));
            }

            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + (skill[j - 1] * mana[i - 1]);
            }
        }

        return dp[m][n];

    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minTime(new int[]{1,5,2,4}, new int[]{5,1,4,2});
    }
}