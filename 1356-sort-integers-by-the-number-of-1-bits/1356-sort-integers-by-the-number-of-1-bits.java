class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] ar=new Integer[arr.length];
        for(int i=0;i<ar.length;i++)
        ar[i]=arr[i];
        Arrays.sort(ar,(a,b)->{
            int c1=0;
            int c2=0;
            String s1=Integer.toBinaryString(a);
            String s2=Integer.toBinaryString(b);
            for(int i=0;i<s1.length();i++){
                if(s1.charAt(i)=='1')
                c1++;
            }
            for(int i=0;i<s2.length();i++){
                if(s2.charAt(i)=='1')
                c2++;
            }
            if(c1!=c2){
                return c1-c2;
            }
            else
            return a-b;
        });
        for(int i=0;i<ar.length;i++)
        arr[i]=ar[i];
        return arr;
    }
}