class Solution {
    public int maxDifference(String s) {
        int[] a=new int[26];
        
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        int so=0;
        int lo=0;
        int se=0;
        boolean notFound=true;
        for(int i:a){
            if(i==0)
            continue;
            if(i%2==0){
                if(se>i||se==0)
                se=i;
            }
            else{
                if(lo<i)
                lo=i;
                if(so>i||so==0)
                so=i;
            }
        }
        return lo-se;
    }
}