class Solution {
    public int subtractProductAndSum(int n) {
        int add=0;
        int mul=1;
        while(n>0)
        {
            int f=n%10;
            add +=f;
            mul*=f;
            n/=10;
         }
         return mul-add;
    
        }
    }