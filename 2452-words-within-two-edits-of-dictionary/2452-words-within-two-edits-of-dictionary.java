class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        for(String q:queries){
            for(String s:dictionary){
                int n=q.length();
                int c=0;
                for(int i=0;i<n;i++){
                    if(q.charAt(i)!=s.charAt(i))
                    c++;
                    if(c>2)
                    break;
                }
                if(c<=2){
                    ans.add(q);
                    break;
                }
            }
        }
        return ans;
    }
}