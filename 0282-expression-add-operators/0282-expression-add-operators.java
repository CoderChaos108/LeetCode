class Solution {
    List<String> list=new ArrayList<>();
    public long parse(String s){
    Stack<Long> stack=new Stack<>();
    long num=0;
    char op='+';

    for(int i=0;i<s.length();i++){
        char c=s.charAt(i);

        if(Character.isDigit(c)){
            num=num*10+(c-'0');
        }

        if(!Character.isDigit(c)||i==s.length()-1){

            if(op=='+'){
                stack.push(num);
            }
            else if(op=='-'){
                stack.push(-num);
            }
            else if(op=='*'){
                stack.push(stack.pop()*num);
            }

            op=c;
            num=0;
        }
    }

    long ans=0;

    while(!stack.isEmpty()){
        ans=ans+stack.pop();
    }

    return ans;
}
    public void find(int i,int target,String s,StringBuilder sb){

    if(i==s.length()){
        if(parse(sb.toString())==target){
            list.add(sb.toString());
        }
        return;
    }

    char c=s.charAt(i);

    if(i==0){
        sb.append(c);
        find(i+1,target,s,sb);
        sb.setLength(sb.length()-1);

    }
    else{

        sb.append('-').append(c);
        find(i+1,target,s,sb);
        sb.setLength(sb.length()-2);

        sb.append(c);
        find(i+1,target,s,sb);
        sb.setLength(sb.length()-1);

        sb.append('+').append(c);
        find(i+1,target,s,sb);
        sb.setLength(sb.length()-2);

        sb.append('*').append(c);
        find(i+1,target,s,sb);
        sb.setLength(sb.length()-2);
    }
}
    public List<String> addOperators(String num, int target) {
        find(0,target,num,new StringBuilder());
        return list;
    }
}