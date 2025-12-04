class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        HashMap<String,Integer> hm=new HashMap<>();
        int ans=0;
        String str="";
        for(List<String> list:responses){
            HashSet<String> set=new HashSet<>();
            for(String s:list){
                if(!set.add(s))
                continue;
                hm.put(s,hm.getOrDefault(s,0)+1);
                if(hm.get(s)>ans){
                    ans=hm.get(s);
                    str=s;
                }
                else if(hm.get(s)==ans){
                    if(s.compareTo(str)<0)
                    str=s;
                }
            }
        }
        return str;
    }
}