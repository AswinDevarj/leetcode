class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int negativeCount = 0;
        int mini = Integer.MAX_VALUE;
        long sum = 0;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                int num = matrix[i][j];
                if(matrix[i][j] < 0){
                    negativeCount++;
                    num = -num;
                }
                mini = Math.min(mini, num);
                sum += num;
            }
        }

        if(negativeCount%2 == 0){ //even negative count
            return sum;
        }else{ //odd negative count
            return sum - 2 * mini;
        }
    }
}