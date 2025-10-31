class Solution {
    int n;
    List<Integer> list=new ArrayList<>();
    public void find(int val){
        if(val>n)
        return;
        for(int i=0;i<10;i++){
            if(i==0&&val==0){
                continue;
            }
            int newVal=val*10+i;
            if(newVal<=n){
                list.add(newVal);
                find(newVal);
            }
        }
    }
    public List<Integer> lexicalOrder(int n) {
        this.n=n;
        find(0);
        return list;
    }
}