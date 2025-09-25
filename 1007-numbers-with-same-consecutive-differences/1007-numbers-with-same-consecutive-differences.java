class Solution {
    int n,k;
    List<Integer> ans=new ArrayList<>();
    public void find(int j,int num){
        if(j==n-1){
            ans.add(num);
            return;
        }
        int last=num%10;
        int n1=last+k;
        int n2=last-k;
        if(n1<10){
            find(j+1,num*10+n1);
        }
        if(n2>=0&&k!=0)
        find(j+1,num*10+n2);
    }
    public int[] numsSameConsecDiff(int n2, int k2) {
        n=n2;
        k=k2;
        for(int i=1;i<10;i++)
        find(0,i);
        int[] ret=new int[ans.size()];
        for(int i=0;i<ret.length;i++)
        ret[i]=ans.get(i);
        return ret;
    }
}