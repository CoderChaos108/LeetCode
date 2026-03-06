class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int i=0;
        int j=0;
        while(i<pushed.length){
            while(!st.isEmpty()&&st.peek()==popped[j]){
                st.pop();
                j++;
            }
            st.push(pushed[i++]);
        }
        while(j<popped.length){
            if(st.pop()!=popped[j++])
            return false;
        }
        return true;
    }
}