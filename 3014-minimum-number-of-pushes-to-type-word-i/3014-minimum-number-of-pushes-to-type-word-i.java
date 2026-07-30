class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int ans=0;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(char key:hm.keySet()){
            list.add(hm.get(key));
        }
        Collections.sort(list);
        for(int j=0;j<list.size();j++){
            int push=j/8+1;
            ans=ans+push*list.get(j);

        }    
        return ans;
    }
}