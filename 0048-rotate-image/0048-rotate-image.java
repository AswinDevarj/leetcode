class Solution {
    public static void transpose(int arr[][]){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
            int temp=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=temp;

        }}
    }
    public static void reverse(int arr[]){
        int st=0;
        int end=arr.length-1;
        while(st<end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;
            st++;
            end--;
        }
    } 
    public void rotate(int[][] matrix) {
        transpose(matrix);
        for(int arr[]:matrix){
            reverse(arr);
        }
        
    }
}