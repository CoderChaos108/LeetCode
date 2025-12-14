class Solution {
    public String reverseWords(String s) {
        Set<Character> set=Set.of('a','e','i','o','u');
        String[] a=s.split(" ");
        String first=a[0];
        int vows=0;
        for(int i=0;i<first.length();i++){
            if(set.contains(first.charAt(i)))
            vows++;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(first+" ");
        for(int i=1;i<a.length;i++){
            String word=a[i];
            int c=0;
            for(int j=0;j<word.length();j++){
                if(set.contains(word.charAt(j)))
                c++;
                if(c>vows)
                break;
            }
            StringBuilder rev=new StringBuilder();
            if(c==vows){
                for(int j=word.length()-1;j>=0;j--){
                    rev.append(word.charAt(j));
                }
                rev.append(" ");
            }
            else
            rev.append(word+" ");
            sb.append(rev);
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }
}