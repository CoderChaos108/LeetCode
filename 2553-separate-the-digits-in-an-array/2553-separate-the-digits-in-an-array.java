class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<>();
        for(int n:nums){
            String s=String.valueOf(n);
            for(int i=0;i<s.length();i++)
            list.add(s.charAt(i)-'0');
        }
        int[] a=new int[list.size()];
        for(int i=0;i<a.length;i++){
            a[i]=list.get(i);
        }
        return a;
    }
}