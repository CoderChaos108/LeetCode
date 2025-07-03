class Solution {
    public String game(String s,int k){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++)
        sb.append((char)(s.charAt(i)+1));
        s=s+sb.toString();
        if(s.length()<k)
        return game(s,k);
        else
        return s;
    }
    public char kthCharacter(int k) {
        if(k==1)
        return 'a';
        return game("a",k).charAt(k-1);
    }
}