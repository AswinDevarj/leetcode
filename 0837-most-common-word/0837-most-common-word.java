class Solution {
    public String mostCommonWord(String para, String[] banned) {
        Map<String,Integer> arr=new TreeMap<>();
        
        String[] str=para.toLowerCase().replaceAll("[^a-z]"," ").split(" ");
        for(int i=0;i<str.length;i++){
            if(!str[i].isEmpty()){
           arr.put(str[i],arr.getOrDefault(str[i],0)+1);
            }
        }
        for(int i=0;i<banned.length;i++){
       arr.remove(banned[i].toLowerCase());
        }
        String res="";
        int max=Integer.MIN_VALUE;
        for(String l:arr.keySet()){
            if(max<arr.get(l)){
                max=arr.get(l);
                res=l;
            }
        }
        
        return res;
        
    }
}