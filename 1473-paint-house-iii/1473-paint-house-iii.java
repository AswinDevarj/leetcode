//Key Points:-
//1. here the dp array is based on house index, color on previous index and the target value for neighbours.
//2. if the color of the previous index and the current index of house is same, then don't decrement the target value
//3. if the color of the previous index is different from the current index, then decrement the target value since new group is formed

//NOTE:- Here the max value is taken as 1e8 because the max cost of painting all the houses can be 1e6(max of m * max of cost[i])
class Solution {
    int t[][][];
    int MAX=(int)1e8;
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        t=new int[houses.length+1][n+1][target+1];
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[0].length;j++)
                Arrays.fill(t[i][j],-1);
        }
        //initially previous color is 0
        int ans=helper(houses,cost,n,houses.length-1,0,target);
        return ans==MAX?-1:ans;
    }
    
    //ind => house index
    //prev => color of previous house
    //target => number of groups which can be formed
    private int helper(int[] houses,int[][] cost,int n,int ind,int prev,int target){
        //ideal and valid case
        if(ind<0 && target==0){
            return 0;
        }
        
        //invalid
        else if(ind<0 || target<0){
            return MAX;    
        }
        
        //memoizing
        if(t[ind][prev][target]!=-1){
            return t[ind][prev][target];
        }
        
        //if the house is already painted
        if(houses[ind]!=0){
            //since the color has changed, so decrement target
            if(prev==0 || prev!=houses[ind]){
                t[ind][prev][target]=helper(houses,cost,n,ind-1,houses[ind],target-1);
            }
            //color is same so no need to change value of target
            else{
                t[ind][prev][target]=helper(houses,cost,n,ind-1,houses[ind],target);
            }
            return t[ind][prev][target];
        }
        
        //finding the color which gives minimum cost when the house is not already painted
        int min=MAX;
        
        for(int i=1;i<=n;i++){
            int temp=Integer.MAX_VALUE;
            //decrement target and change the previous color to i
            if(prev==0 || prev!=i){
                temp=helper(houses,cost,n,ind-1,i,target-1);
            }
            //no change in target value
            else{
                temp=helper(houses,cost,n,ind-1,i,target);
            }
            //evaluating min cost
            min=Math.min(min,temp+cost[ind][i-1]);
        }
        
        //storing
        t[ind][prev][target]=min;
        return min;
    }
}