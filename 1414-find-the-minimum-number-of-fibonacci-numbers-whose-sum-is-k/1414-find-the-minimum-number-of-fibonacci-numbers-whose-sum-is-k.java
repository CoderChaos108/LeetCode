class Solution {
    List<Integer> list=new ArrayList<>();
    public int recur(int n){
        if(n==0)
        return 0;
        int itr=0;
        while(itr<list.size()&&list.get(itr)<=n){
        itr++;
        }
        n=n-list.get(itr-1);
        return 1+recur(n);
    }
    public int findMinFibonacciNumbers(int k) {
       int a=1;
       int b=1;
       list.add(1);
       while((long)a+b<=k){
        list.add(a+b);
        int t=a;
        a=b;
        b=t+b;
       }
        return recur(k);
    }
}