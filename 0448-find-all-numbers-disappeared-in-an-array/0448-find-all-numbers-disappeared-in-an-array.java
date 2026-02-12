class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
      List<Integer>list=new ArrayList<>();
      boolean visited[]=new boolean[nums.length+1];
      for(int i:nums){
        visited[i]=true;
      }
      for(int i=1;i<visited.length;i++){
        if(!visited[i]) list.add(i);
      }
      return list;
       
 }
}                       