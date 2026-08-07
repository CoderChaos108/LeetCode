class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list=new ArrayList<>();
        int n=s.length();
        int lim=0;
        int[] a=new int[26];
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            a[c]=i;
        }
        int l=0;
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'a';
            l++;
            lim=Math.max(lim,a[c]);
            if(i==lim){
                list.add(l);
                l=0;
                lim=0;
            }
        }
        return list;
    }
}