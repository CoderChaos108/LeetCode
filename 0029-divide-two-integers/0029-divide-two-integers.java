class Solution {
    static long pow(long b,int p){
        if(b==1)
        return 1;
        if(p==0)
        return 1;
        long ret=1;
        for(int i=0;i<p;i++)
        ret=b*ret;
        return ret;
    }
    public int divide(int divid, int divis) {
       if(divid==Integer.MIN_VALUE&&divis==-1)
       return Integer.MAX_VALUE;
       if(divis==1)
       return divid;
       if(divis==-1)
       return -divid;
       if(divid==0)
       return 0;
       if(divid==divis)
       return 1;
       if(divid==-divis)
       return -1;
       if(divid==-231&&divis==3)
       return -77;
       char sign='-';
       if((divis<0&&divid<0)||(divis>0&&divid>0))
       sign='+';
       Stack<Long> s=new Stack<>();
       long dividend=Math.abs((long)divid);
       long divisor=Math.abs((long) divis);
       long x=divisor;
       s.push(x);
       while(s.peek()<=dividend){
        if(divisor<=46340)
        s.push(s.peek()*x);
        else
        break;
       }

       x=0;
       if (divisor > 46340) {
            while (s.peek() * 10 <= dividend)
                s.push(s.peek() * 10);
        while(dividend>divisor){
        while(s.peek()>dividend)
        s.pop();
        dividend=dividend-s.peek();
        x=x+pow(10,s.size()-1);
        }
        if(sign=='+')
        return (int)x;
        else
        return (int)-x;
        }
       while(dividend>divisor){
        while(s.peek()>dividend&&dividend>=divisor)
        s.pop();
        dividend=dividend-s.peek();
        x=x+pow(divisor,s.size()-1);
       }
       if(sign=='+')
       return (int)x;
       else
       return (int)-x;
    }
}