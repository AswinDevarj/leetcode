class Solution {
    public int secondHighest(String s) {
        Set<Integer>set = new HashSet<>();
        char[]ch = s.toCharArray();
        for(int i=0; i<ch.length; i++)
        {
            if(ch[i]>='0' && ch[i]<='9')
            {
                if(!set.contains(ch[i]))
                {
                    set.add(ch[i]-'0');
                }
            }
        }
        int[]arr = new int[set.size()];
        int k =0;
        for(int a : set)
        {
            arr[k++] = a;
        }
        Arrays.sort(arr);
        if(arr.length<2)
        {
            return -1;
        }
        return arr[arr.length-2];
    }
}