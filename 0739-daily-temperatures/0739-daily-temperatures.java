class Solution {
    public int[] dailyTemperatures(int[] t) {
       Stack<int[]> st=new Stack<>();
       for(int i=t.length-1;i>=0;i--){
        while(st.size()!=0&&st.peek()[0]<=t[i]){
            st.pop();
        }
        if(st.size()==0){
            int a[]={t[i],i};
            st.push(a);
            t[i]=0;
        }
        else{
            int h=st.peek()[1];
            int a[]={t[i],i};
            st.push(a);
            t[i]=h-i;
        }
       } 
       return t;
    }
}