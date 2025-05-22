class MinStack {
    ArrayList<Integer> list;
    ArrayList<Integer> min;
    int t;
    public MinStack() {
        list=new ArrayList<Integer>();
        min=new ArrayList<Integer>();
        t=0;
    }
    
    public void push(int val) {
        list.add(val);
        if(min.size()==0||val<=min.get(min.size()-1))
        min.add(val);
    }
    
    public void pop() {
        t=list.get(list.size()-1);
        list.remove(list.size()-1);
        if(min.get(min.size()-1)==t)
        min.remove(min.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return min.get(min.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */