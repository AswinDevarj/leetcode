class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        int totzero = 0, totone = 0;
        long currzero = 0, currone = 0;
        long ans = 0;

        for(int i=0;i<n;i++){
            totzero += s.charAt(i)=='0'?1:0;
        }
        totone = n - totzero;

        currzero = s.charAt(0)=='0'?1:0;
        currone = s.charAt(0)=='1'?1:0;

        for(int i=1;i<n-1;i++){
            if(s.charAt(i) == '0'){
                ans += currone * (totone - currone);
                currzero++;
            }
            if(s.charAt(i) == '1'){
                ans += currzero * (totzero - currzero);
                currone++;
            }
        }

        return ans;
    }
}