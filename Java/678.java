// Approach 2: Greedy
class Solution {
    public boolean checkValidString(String s) {
        int lo = 0;
        int hi = 0;
        for (char ch : s.toCharArray()) {
            lo += (ch == '(') ? 1 : -1;
            hi += (ch != ')') ? 1 : -1;
            if (hi < 0) {
                break;
            }
            if (lo < 0) {
                lo = 0;
            }
        }
        return lo == 0;
    }
}

// Approach 1: Dyanmic Programming
// class Solution {
//     public boolean checkValidString(String s) {
//         int n = s.length();
//         if (n == 0) {
//             return true;
//         }
//         char[] str = s.toCharArray();
//         boolean[][] dp = new boolean[n][n];
//         for (int i = 0; i < n; i++) {
//             if (str[i] == '*') {
//                 dp[i][i] = true;
//             }
//             if (i < n - 1 && (str[i] == '(' || str[i] == '*') && (str[i+1] == ')' || str[i+1] == '*')) {
//                 dp[i][i+1] = true;
//             }
//         }
//         for (int size = 2; size < n; size++) {
//             for (int i = 0; i < n-size; i++) {
//                 if (str[i] == '*' && dp[i+1][i+size]) {
//                     dp[i][i+size] = true;
//                 } else if (str[i] == '(' || str[i] == '*') {
//                     for (int k = i+1; k <= i+size; k++) {
//                         if ((str[k] == ')' || str[k] == '*') &&
//                             (k == i+1 || dp[i+1][k-1]) &&
//                             (k == i+size || dp[k+1][i+size])) {
//                             dp[i][i+size] = true;
//                         }
//                     }
//                 }
//             }
//         }
//         return dp[0][n-1];
//     }
// }