class BrowserHistory {
    Stack<String> forward;
    Stack<String> backward;
    public BrowserHistory(String homepage) {
        forward=new Stack<>();
        backward=new Stack<>();
        backward.push(homepage);
    }
    
    public void visit(String url) {
        forward.clear();
        backward.push(url);
    }
    
    public String back(int steps) {
        steps=Math.min(steps,backward.size()-1);
        for(int i=0;i<steps;i++)
        forward.push(backward.pop());
        return backward.peek();
    }
    
    public String forward(int steps) {
        steps=Math.min(steps,forward.size());
        for(int i=0;i<steps;i++){
            backward.push(forward.pop());
        }
        return backward.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */