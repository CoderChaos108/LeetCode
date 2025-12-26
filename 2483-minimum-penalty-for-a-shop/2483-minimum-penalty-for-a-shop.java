class Solution {
    public int bestClosingTime(String customers) {
       int[] pre=new int[customers.length()];
       int[] post=new int[pre.length];
       int pen=0;
       for(int i=0;i<customers.length()-1;i++){
           if(customers.charAt(i)=='N')
           pen++;
           pre[i+1]=pen;
       }
       pen=0;
       for(int i=customers.length()-1;i>=0;i--){
            if(customers.charAt(i)=='Y')
            pen++;
            post[i]=pen;
       }
       int j=0;
       int min=Integer.MAX_VALUE;
        for(int i=0;i<pre.length;i++){
            if(pre[i]+post[i]<min){
                min=pre[i]+post[i];
                j=i;
            }
        }
        pen=0;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='N')
            pen++;
        }
        if(pen<min)
        return customers.length();
        return j;
    }
}