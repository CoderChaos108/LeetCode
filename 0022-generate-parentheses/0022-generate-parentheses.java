class Solution {
    static ArrayList<String> recur(int n){
        ArrayList<String> list=new ArrayList<String>();
        HashSet<String> ans=new HashSet<>();
        if(n==1){
            list.add("()");
            return list;
        }
        int l;
            list=recur(n-1);
            StringBuilder sb=new StringBuilder();
            for(String s:list){
                l=s.length();
                for(int i=0;i<l-1;i++){
                    sb.setLength(0);
                sb.append(s);
                    if(sb.charAt(i)=='('&&sb.charAt(i+1)==')'){
                         ans.add(sb.insert(i+1,"()").toString());
                         sb.setLength(0);
                sb.append(s);
                sb.insert(i,"(");
                ans.add(sb.insert(i+2,")").toString());
                    }
                    sb.setLength(0);
                sb.append(s);
                ans.add(sb.insert(i+2,"()").toString());
                }
                ans.add(s+"()");
                ans.add("()"+s);
                ans.add('('+s+')');
            }
              return new ArrayList<>(ans);
    } 
    public List<String> generateParenthesis(int n) {
        return recur(n);
    }
}