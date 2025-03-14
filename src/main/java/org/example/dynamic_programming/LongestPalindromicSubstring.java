package org.example.dynamic_programming;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 1 || n == 0)
            return s;

        boolean[][] dp = new boolean[n][n];

        // Base cases

        int start = -1;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true; // Single character
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true; // Two characters
                start = i;
                maxLength = 2;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
