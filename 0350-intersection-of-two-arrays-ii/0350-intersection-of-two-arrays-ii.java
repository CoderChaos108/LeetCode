class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm1=new HashMap<>();
        HashMap<Integer,Integer> hm2=new HashMap<>();
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i:nums1){
            hm1.put(i,hm1.getOrDefault(i,0)+1);
        }
        for(int i:nums2){
            hm2.put(i,hm2.getOrDefault(i,0)+1);
        }
        for(int i:hm1.keySet()){
            if(hm2.containsKey(i)){
                for(int j=0;j<Math.min(hm1.get(i),hm2.get(i));j++){
                    ans.add(i);
                }
            }
        }
        int[] a=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            a[i]=ans.get(i);
        }
        return a;
    }
}