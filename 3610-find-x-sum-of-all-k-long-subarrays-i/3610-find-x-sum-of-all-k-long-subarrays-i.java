class Solution{
    public int[] findXSum(int[] nums,int k,int x){
        int n=nums.length;
        int[] ans=new int[n-k+1];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<k;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        ans[0]=computeXSum(hm,x);
        for(int i=k;i<n;i++){
            int out=nums[i-k];
            int in=nums[i];
            hm.put(out,hm.get(out)-1);
            if(hm.get(out)==0)hm.remove(out);
            hm.put(in,hm.getOrDefault(in,0)+1);
            ans[i-k+1]=computeXSum(hm,x);
        }
        return ans;
    }

    private int computeXSum(HashMap<Integer,Integer> hm,int x){
        List<Integer> list=new ArrayList<>(hm.keySet());
        Collections.sort(list,(a,b)->{
            if(!hm.get(a).equals(hm.get(b)))
            return hm.get(b)-hm.get(a);
            return b-a;
        });
        int sum=0;
        for(int i=0;i<Math.min(x,list.size());i++){
            int val=list.get(i);
            sum+=val*hm.get(val);
        }
        return sum;
    }
}
