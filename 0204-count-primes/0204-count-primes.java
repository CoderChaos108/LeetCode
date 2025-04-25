class Solution {
    public int countPrimes(int n) {
         char[] IsPrime=new char[n];
        int c=0;
       for(int i=2;i<n;i++){
            if(IsPrime[i]=='n')
            continue;
           if(i==2||i==3||i==5||i==7)
           IsPrime[i]='y';
           if((IsPrime[i]!='n'&&i%2!=0&&i%3!=0&&i%5!=0&&i%7!=0)||IsPrime[i]=='y'){
            IsPrime[i]='y';
            for(int j=2;i*j<n;j++){
                IsPrime[i*j]='n';
            }
           }
           if(IsPrime[i]=='y')
           c++;
       }
        return c;
    }
}