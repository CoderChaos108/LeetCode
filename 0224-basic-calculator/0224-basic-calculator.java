class Solution {
    public static String preprocess(String input) {
        return input.replaceAll("\\-\\(","-1*(");
    }
    public static int parse(String s) {
        StringBuilder sb=new StringBuilder();
        List<String> list=new ArrayList<>();
        int l=s.length();
        int i=0;
        while(i<l){
            char c=s.charAt(i);
            if(c==' '){
                i++;
                continue;
            }
            if(c=='-'&&(i==0||(!Character.isDigit(s.charAt(i-1))&&s.charAt(i-1)!=')'))){
                sb.append(c);
                i++;
                while(i<l&&Character.isDigit(s.charAt(i)))
                    sb.append(s.charAt(i++));
                list.add(sb.toString());
                sb.setLength(0);
            }else if(Character.isDigit(c)){
                while(i<l&&Character.isDigit(s.charAt(i)))
                    sb.append(s.charAt(i++));
                list.add(sb.toString());
                sb.setLength(0);
            }else{
                list.add(String.valueOf(c));
                i++;
            }
        }
        int x=0;
        for(i=0;i<list.size();i++){
            String op=list.get(i);
            if(op.equals("/")||op.equals("*")){
                int a=Integer.parseInt(list.get(i-1));
                int b=Integer.parseInt(list.get(i+1));
                x=op.equals("/")?a/b:a*b;
                list.set(i-1,String.valueOf(x));
                list.remove(i+1);
                list.remove(i);
                i--;
            }
        }
        int sign=1;
        x=0;
        for(String t:list){
            if(t.equals("+"))
                sign=1;
            else if(t.equals("-"))
                sign=-1;
            else
                x+=Integer.parseInt(t)*sign;
        }
        return x;
    }
    public static int calculate(String s) {
        s=preprocess('('+s+')');
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int k=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==')'){
                sb.setLength(0);
                while(st.peek()!='(')
                    sb.insert(0,st.pop());
                st.pop();
                k=parse(sb.toString());
                sb.setLength(0);
                sb.append(String.valueOf(k));
                for(int j=0;j<sb.length();j++)
                    st.push(sb.charAt(j));
                sb.setLength(0);
            }else
                st.push(c);
        }
        sb.setLength(0);
        while(!st.isEmpty())
            sb.insert(0,st.pop());
        return parse(sb.toString());
    }
}
