class Solution {
    public int[] dailyTemperatures(int[] t) {
       int[] a=new int[t.length];
       Stack<Integer> st=new Stack<>();
       for(int i=t.length-1;i>=0;i--){
        while(st.size()!=0&&t[st.peek()]<=t[i]){
            st.pop();
        }
        if(st.size()==0){
            st.push(i);
            a[i]=0;
        }
        else{
            int h=st.peek();
            st.push(i);
            a[i]=h-i;            
        }
       } 
       return a;
    }
}