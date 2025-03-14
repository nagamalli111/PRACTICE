package org.example.dynamic_programming;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int n = s.length();
        if (n <= 1)
            return n;

        int count = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i+1] = true;
                count++;
            }
        }

        for (int len = 3; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    count++;
                }
            }
        }
        return count;
    }
}
