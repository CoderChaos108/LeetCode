class Solution {
    public boolean isPalindrome(String s){
        int t=s.length();
        for(int i=0;i<t/2;i++){
            if(s.charAt(i)!=s.charAt(t-1-i))
            return false;
        }
        return true;
    }
    String s;
    int n;
    List<List<String>> ans=new ArrayList<>();
    public void find(List<String> list,int k){
        if(k>=n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=k+1;i<=n;i++){
            String part=s.substring(k,i);
            if(isPalindrome(part)){
                list.add(part);
                find(list,i);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String str) {
        s=str;
        n=s.length();
        find(new ArrayList<>(),0);
        return ans;
    }
}