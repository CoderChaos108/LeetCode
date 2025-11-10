class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> list=new ArrayList<>();
        int itr=0;
        for(int i=1;i<=n&&itr<target.length;i++){
            list.add("Push");
            if(i!=target[itr]){
                list.add("Pop");
            }
            else
            itr++;
        }
        return list;
    }
}