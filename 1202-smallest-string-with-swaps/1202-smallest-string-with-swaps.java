class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=pairs.size();
        DSU dsu=new DSU(s.length());
        for(List<Integer>l:pairs){
            int x=l.get(0);
            int y=l.get(1);

            if(dsu.find(x)!=dsu.find(y)){
                dsu.union(x,y);
            }
        }
        HashMap<Integer,PriorityQueue<Character>>map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            int id=dsu.find(i);
            map.putIfAbsent(id,new PriorityQueue<>());
            map.get(id).add(s.charAt(i));
        }
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<s.length();i++){
            int root=dsu.find(i);
            sb.append(map.get(root).poll());
        }
        return sb.toString();
    }
}
class DSU {
    int[] parent;
    int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0; // Initialize rank
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);

        if (rx == ry) return; // Already in the same set

        if (rank[rx] < rank[ry]) {
            parent[rx] = ry;
        } else if (rank[rx] > rank[ry]) {
            parent[ry] = rx;
        } else {
            parent[ry] = rx;
            rank[rx]++;
        }
    }
}