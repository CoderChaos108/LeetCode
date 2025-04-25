class Solution {
    public int countPrimes(int n) {
         boolean[] IsPrime=new boolean[n];
        int c=0;
       for(int i=2;i<Math.sqrt(n);i++){
            if(IsPrime[i]==true)
            continue;
           if(i==2||i==3||i==5||i==7)
           IsPrime[i]=false;
           if((IsPrime[i]!=true&&i%2!=0&&i%3!=0&&i%5!=0&&i%7!=0)||IsPrime[i]==false){
            IsPrime[i]=false;
            for(int j=2;i*j<n;j++){
                IsPrime[i*j]=true;;
            }
           }
       }
       for(int i=2;i<IsPrime.length;i++){
        if(IsPrime[i]==false)
        c++;
       }
        return c;
    }
}