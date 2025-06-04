class MyStack {
    ArrayList<Integer> q; 
    public MyStack() {
        q=new ArrayList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        ArrayList<Integer> aux=new ArrayList<>();
        int l=q.size()-1;
        for(int i=0;i<l;i++){
            aux.add(q.get(0));
            q.remove(0);
        }
        int ret=q.get(q.size()-1);
        q.remove(0);
        for(int i:aux){
            q.add(i);
        }
        return ret;
    }
    
    public int top() {
        ArrayList<Integer> aux=new ArrayList<>();
        int l=q.size();
        int ret=0;
        for(int i=0;i<l;i++){
            aux.add(q.get(0));
            if(i==l-1)
            ret=q.get(0);
            q.remove(0);
        }
        
        for(int i:aux){
            q.add(i);
        }
        return ret;
    }
    
    public boolean empty() {
        if(q.size()==0)
        return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */