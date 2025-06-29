class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:words){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
         TreeMap<Integer,List<String>> tm=new TreeMap<>();
         for(String s:hm.keySet()){
            if(!tm.containsKey(hm.get(s))){
                List<String> list=new ArrayList<>();
                list.add(s);
                tm.put(hm.get(s),list);
            }
            else
            tm.get(hm.get(s)).add(s);
         }
        List<String> ans=new ArrayList<>();
        while(true){
            Collections.sort(tm.get(tm.lastKey()));
            for(String s:tm.get(tm.lastKey())){
                ans.add(s);
                if(ans.size()==k)
                return ans;
            }
            tm.remove(tm.lastKey());
        }
    }
}