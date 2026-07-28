class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        List<Character> list=new ArrayList<>();
        for(int i=0;i<n/2;i++)
        list.add(s.charAt(i));
        Collections.sort(list);
        char[] a=new char[n];
        int p=0;
        int q=n-1;
        for(char c:list){
            a[p]=c;
            a[q]=c;
            p++;
            q--;
        }
        if(n%2!=0){
            a[p]=s.charAt(n/2);
        }
        StringBuilder sb=new StringBuilder();
        for(char c:a)
        sb.append(c);
        return sb.toString();
    }
}