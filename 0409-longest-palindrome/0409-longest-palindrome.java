class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int[] count = new int[128]; // for ASCII characters
        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int longest = 0;
        boolean hasOdd = false;

        for (int freq : count) {
            if (freq % 2 == 0) {
                longest += freq;
            } else {
                longest += freq - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) longest++;
        return longest;
    }
}
