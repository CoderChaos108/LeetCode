class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> f=new ArrayList<Integer>();
        int c=0;
        int p=0;
        for(int i=0;i<nums.length;i++){
            if(c==0)
            f.add(c);
            c++;
            f.set(p,c);
            if(i!=nums.length-1&&nums[i+1]!=nums[i]){
                c=0;
                p++;
            }
        }
        p=0;
        int i=0;
        int s=0;
        while(i<nums.length){
            nums[s]=nums[i];
            s++;
            i=i+f.get(p);
            p++;
        }
        return s;
   }
}