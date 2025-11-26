class Solution {
    public void solve(int[] nums,int i,List<Integer> ds,HashSet<List<Integer>> res,int prev)
    {
        if(i==nums.length)
        {
            if(ds.size()>=2)
                res.add(new ArrayList<Integer> (ds));
            return;
        }
        if(prev==-1 || nums[i]>=nums[prev])
        {
            ds.add(nums[i]);
            solve(nums,i+1,ds,res,i);
            ds.remove(ds.size()-1);
        }
        solve(nums,i+1,ds,res,prev);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashSet<List<Integer>> res=new LinkedHashSet<>();
        List<Integer> ds=new ArrayList<>();
        solve(nums,0,ds,res,-1);
        List<List<Integer>> ans=new ArrayList<>();
        for(List<Integer> arr : res)
            ans.add(new ArrayList<Integer>(arr));
        return ans;
    }
}