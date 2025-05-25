class Solution {
    public  int longestPalindrome(String[] words) {

        StringBuilder sb=new StringBuilder();
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:words)
        hm.put(s,hm.getOrDefault(s,0)+1);
        int c=0;
        boolean mid=false;
        for(String s:words){
            if(!hm.containsKey(s))
            continue;
            if(s.charAt(0)==s.charAt(1)){
                if(hm.get(s)%2==0){
                    c=c+hm.get(s);
                }
                else{
                mid=true;
                if(hm.get(s)>1)
                c=c+(hm.get(s)-1);
                }
                hm.remove(s);
            }
            else{
            sb.setLength(0);
            sb.append(s.charAt(1));
            sb.append(s.charAt(0));
            if(hm.containsKey(sb.toString())){
                c=c+2;
                hm.put(sb.toString(),hm.get(sb.toString())-1);
                hm.put(s,hm.get(s)-1);
                if(hm.get(s)==0||hm.get(sb.toString())==0){
                hm.remove(s);
                hm.remove(sb.toString());
                }
            }
            }
        }
        if(mid)
        c++;
        c=c*2;
        return c;
    }
}