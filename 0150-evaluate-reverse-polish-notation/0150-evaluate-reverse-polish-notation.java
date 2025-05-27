class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        int a=0;
        int b=0;
        String c="";
        int l=tokens.length;
        for(int i=0;i<l;i++){
            c=tokens[i];
                if(c.equals("+")){
                b=s.pop();
                a=s.pop();    
                s.push(a+b);
                }
                else if(c.equals("-")){
                 b=s.pop();
                a=s.pop();
                s.push(a-b);
                }
                else if(c.equals("*")){
                    b=s.pop();
                a=s.pop();
                s.push(a*b);
                }
                else if(c.equals("/")){
                    b=s.pop();
                a=s.pop();
                s.push(a/b);
                }
            else{
                s.push(Integer.valueOf(c));
            }
        } 
        return s.peek();
    }
}