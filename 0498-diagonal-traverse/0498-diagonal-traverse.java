class Solution {
    public int[] findDiagonalOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;


        int[] arr = new int[ m * n ];
        HashMap<Integer, List<Integer>> mp = new HashMap<>();

        for( int i = 0; i < m; i++ ) {
            for( int j = 0; j < n; j++ ) {
                mp.putIfAbsent( (i + j), new ArrayList<>() );
                mp.get(i + j).add(mat[i][j]);
            }
        }

        int idx = 0;
        boolean flag = true;

        for( int k = 0; k < m + n - 1; k++ ) {
            List<Integer> diagonal = mp.get(k);
            if(flag) {
                Collections.reverse(diagonal);
            }

            for( int temp : diagonal ) {
                arr[idx++] = temp;
            }

            flag = !flag;
        }

        return arr;

    }
}