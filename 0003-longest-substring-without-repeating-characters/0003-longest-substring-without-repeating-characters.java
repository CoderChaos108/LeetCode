class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0||s.length()==1)
        return s.length();
        StringBuilder sb=new StringBuilder("");
        int l=0;
        int i=0;
        while(i<s.length()-l)
        {
            sb.append(s.charAt(i));
            HashSet<Character> set=new HashSet<>();
            set.add(s.charAt(i));
            for(int j=i+1;j<s.length();j++)
            {
                if(set.contains(s.charAt(j)))
                break;
                set.add(s.charAt(j));   
                sb.append(s.charAt(j));
            }
            if(sb.length()>l)
            l=sb.length();
            sb.setLength(0);
            i++;
        }
        return l;
    }
}