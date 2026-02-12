class Solution {
    public int longestBalanced(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character,Integer> hm=new HashMap<>();
            int max=1;
            int co=0;
            for(int j=i;j<s.length();j++){
              char c=s.charAt(j);
              if(!hm.containsKey(c))  
              hm.put(c,0);
              hm.put(c,hm.get(c)+1);
              if(hm.get(c)>max){
                max=hm.get(c);
                co=1;
              }
              else if(hm.get(c)==max){
                co++;
              }
              if(co==hm.size())
              ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}