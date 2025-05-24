
class Solution {
    
    static List<List<Integer>> recur(List<Integer> a) {
        List<List<Integer>> ans=new ArrayList<>();
        if(a.size()==1){
            ans.add(new ArrayList<>(a));
            return ans;
        }
        for(int i:a){
            List<Integer> check=new ArrayList<>();
            for(int j:a){
                if(j==i)continue;
                check.add(j);
            }
            List<List<Integer>> list=recur(check);
            for(List<Integer> l:list){
                List<Integer> newList=new ArrayList<>(l);
                newList.add(0,i);
                ans.add(newList);
            }
        }

        return ans;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> input=new ArrayList<>();
        for(int num:nums){
            input.add(num);
        }

        return recur(input);
    }
}