class Solution {
    public boolean check(String s1,String s2){
        if(s1.length()!=s2.length())
        return false;
        int[] a1=new int[26];
        int[] a2=new int[26];
        for(int i=0;i<s1.length();i++){
            a1[s1.charAt(i)-'a']++;
            a2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(a1[i]!=a2[i])
            return false;
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> ans=new ArrayList<>();
        boolean[] removed=new boolean[words.length];
        for(int i=0;i<words.length;i++){
            if(removed[i])
            continue;
            String s1=words[i];
            ans.add(s1);
            for(int j=i+1;j<words.length;j++){
                String s2=words[j];
                if(check(s1,s2))
                removed[j]=true;
                else
                break;
            }
        }
        return ans;
    }
}