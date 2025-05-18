class Solution {
    public List<List<Integer>> generate(int n) {
        ArrayList<List<Integer>> ans=new ArrayList<List<Integer>>();
            for(int i=0;i<n;i++){
                ArrayList<Integer> list=new ArrayList<Integer>();
                if(i==0)
                list.add(1);
                else if(i==1){
                list.add(1);
                list.add(1);
                }
                else{
                ArrayList<Integer> temp = new ArrayList<>(ans.get(i-1));
                for(int j=0;j<=i;j++){
                    if(j==0||j==i)
                    list.add(1);
                    else
                    list.add(temp.get(j)+temp.get(j-1));
            }
                }
            ans.add(list);
            }
            return ans;
    }
}