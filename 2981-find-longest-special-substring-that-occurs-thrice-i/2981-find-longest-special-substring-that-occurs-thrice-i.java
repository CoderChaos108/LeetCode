class Solution {
    public int maximumLength(String s) {
        HashMap<String,Integer> hm=new HashMap<>();
        int ans=-1;
        for(int i=0;i<s.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<s.length();j++){
                sb.append(s.charAt(j));
                String str=sb.toString();
                if(str.length()>1){
                    int l=str.length();
                    if(str.charAt(l-1)!=str.charAt(l-2))
                    break;
                }
                hm.put(str,hm.getOrDefault(str,0)+1);
                if(hm.get(str)>=3)
                ans=Math.max(ans,str.length());
            }
        }
        return ans;
    }
}