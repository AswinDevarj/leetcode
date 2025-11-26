class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;

        if (len == 0) {
            return arr;
        }

        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        Map<Integer, Integer> map = new HashMap();
        int rank = 1;

        for (int i : sorted) {
            if (!map.containsKey(i))
                map.put(i, rank++);
        }

        for (int i = 0; i < len; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}