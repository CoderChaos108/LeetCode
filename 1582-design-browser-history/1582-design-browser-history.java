class BrowserHistory {
    public class ListNode{
        String val;
        ListNode next;
        ListNode prev;
        ListNode (String val){
            this.val=val;
        }
    }
    ListNode current,head,tail;
    public BrowserHistory(String homepage) {
        head=new ListNode(homepage);
        tail=head;
        current=head;
    }
    
    public void visit(String url) {
        current.next=new ListNode(url);
        current.next.prev=current;
        current=current.next;
        tail=current;
    }
    
    public String back(int steps) {
        for(int i=0;i<steps;i++){
            if(current==head)
            break;
            current=current.prev;
        }
        return current.val;
    }
    
    public String forward(int steps) {
        for(int i=0;i<steps;i++){
            if(current==tail)
            break;
            current=current.next;
        }
        return current.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */