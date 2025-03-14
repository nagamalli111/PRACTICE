package org.example.dynamic_programming;

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;

        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: empty string
        dp[1] = 1; // Base case: single character (if not '0')

        for (int i = 2; i <= n; i++) {
            char current = s.charAt(i - 1);
            char previous = s.charAt(i - 2);

            // Check if current character is valid (1-9)
            if (current >= '1' && current <= '9') {
                dp[i] += dp[i - 1];
            }

            // Check if the two-character substring is valid (10-26)
            if (previous == '1' || (previous == '2' && current <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        DecodeWays solution = new DecodeWays();

        System.out.println(solution.numDecodings("999"));   // Output: 3
        System.out.println(solution.numDecodings("12"));    // Output: 2
        System.out.println(solution.numDecodings("06"));    // Output: 0
        System.out.println(solution.numDecodings("11106")); // Output: 2
    }
}
