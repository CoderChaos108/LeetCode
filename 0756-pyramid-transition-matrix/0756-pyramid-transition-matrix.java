class Solution {
    boolean possible=false;
    HashMap<String,List<Character>> hm;
    public void find(String s,int i,StringBuilder sb){
        int n=s.length();
        if(n==1){
            possible=true;
            return;
        }
        if(possible)
        return;
        if(i+2>n){
            String newBase=sb.toString();
            find(newBase,0,new StringBuilder());
            return;
        }
        List<Character> list=hm.get(s.substring(i,i+2));
        if(!hm.containsKey(s.substring(i,i+2)))
        return;
        for(char top:list){
            sb.append(top);
            find(s,i+1,sb);
            if(sb.length()!=0)
            sb.setLength(sb.length()-1);
        }
    }
    public boolean pyramidTransition(String bottom, List<String> allowed) {
            hm=new HashMap<>();
            for(String s:allowed){
                String base=s.substring(0,2);
                if(!hm.containsKey(base))
                hm.put(base,new ArrayList<Character>());
                hm.get(base).add(s.charAt(2));
            }       
            find(bottom,0,new StringBuilder());
            return possible;
    }
}