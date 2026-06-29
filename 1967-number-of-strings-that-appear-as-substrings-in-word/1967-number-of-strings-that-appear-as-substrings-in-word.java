class Solution {
    public int numOfStrings(String[] patterns, String word) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:patterns){
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        int ans=0;
        for(int i=0;i<word.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<word.length();j++){
                    sb.append(word.charAt(j));
                    String s=sb.toString();
                    if(hm.containsKey(s)){
                        ans=ans+hm.get(s);
                        hm.remove(s);
                    }
            }
        }
        return ans;
    }
}