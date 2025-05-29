import java.util.*;
class Solution {
    public static String preprocess(String input) {
        input=input.replaceAll("\\-\\(", "-1*(");
        return input;
    }
    public static int parse(String s) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String> list=new ArrayList<>();
        int l=s.length();
        int i=0;
        while(i<l){
            if(s.charAt(i)==' '){
                i++;
                continue;
            }
            if(s.charAt(i)=='-'&&(i==0||!Character.isDigit(s.charAt(i-1))&&s.charAt(i-1)!=')')){
                sb.append('-');
                i++;
                while(i<l&&Character.isDigit(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                list.add(sb.toString());
                sb.setLength(0);
            }else if(Character.isDigit(s.charAt(i))){
                while(i<l&&Character.isDigit(s.charAt(i))){
                    sb.append(s.charAt(i));
                    i++;
                }
                list.add(sb.toString());
                sb.setLength(0);
            }else{
                list.add(s.charAt(i)+"");
                i++;
            }
        }
        String a,b;
        int x=0;
        for(i=0;i<list.size();i++){
            if(list.get(i).equals("/")){
                a=list.get(i-1);
                b=list.get(i+1);
                x=(Integer.valueOf(a))/(Integer.valueOf(b));
                list.set(i-1,String.valueOf(x));
                list.remove(i+1);
                list.remove(i);
                i=i-1;
            }
            if(i<list.size()&&list.get(i).equals("*")){
                a=list.get(i-1);
                b=list.get(i+1);
                x=(Integer.valueOf(a))*(Integer.valueOf(b));
                list.set(i-1,String.valueOf(x));
                list.remove(i+1);
                list.remove(i);
                i=i-1;
            }
        }
        int sign=1;
        x=0;
        for(String t:list){
            if(t.equals("+")){
                sign=1;
            }else if(t.equals("-")){
                sign=-1;
            }else{
                x+=Integer.valueOf(t)*sign;
            }
        }
        return x;
    }
    public int calculate(String s) {
        s=preprocess('('+s+')');
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        int l=s.length();
        int k=0;
        for(int i=0;i<l;i++){
            if(s.charAt(i)==')'){
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
                st.push(s.charAt(i));
        }
        sb.setLength(0);
        while(!st.isEmpty())
            sb.insert(0,st.pop());
        return parse(sb.toString());
    }
}
