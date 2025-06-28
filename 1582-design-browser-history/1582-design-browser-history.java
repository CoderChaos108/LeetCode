class BrowserHistory {
    List<String> list;
    int p;
    public BrowserHistory(String homepage) {
        list=new ArrayList<>();
        list.add(homepage);
        p=0;
    }
    
    public void visit(String url) {
        list=list.subList(0,p+1);
        list.add(url);
        p=list.size()-1;
    }
    
    public String back(int steps) {
        steps=Math.min(steps,p);
        p=p-steps;
        return list.get(p);
    }
    
    public String forward(int steps) {
        steps=Math.min(steps,list.size()-1-p);
        p=p+steps;
        return list.get(p);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */