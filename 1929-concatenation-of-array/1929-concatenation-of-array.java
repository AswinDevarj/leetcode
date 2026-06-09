class Solution {
    public int[] getConcatenation(int[] nums) {
        int n1=nums.length;//n1=3
        int n2=2*n1;// 2*3=6=n2
        int arr[]=new int[n2];
        for(int i=0; i<arr.length;i++)
        {
            arr[i]=nums[i%n1];

        }
        return arr;


    }
}