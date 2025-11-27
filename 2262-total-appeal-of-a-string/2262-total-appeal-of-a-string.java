class Solution {
    public long appealSum(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        
        int[] lastIdx = new int[26];
        Arrays.fill(lastIdx, -1);
        
        long total = 0;
        
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            dp[i + 1] = dp[i] + i - lastIdx[c];
            total += dp[i + 1];
            
            lastIdx[c] = i;
        }
        
        return total;
    }
}
