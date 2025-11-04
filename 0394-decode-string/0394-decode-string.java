class Solution {
    public String decode(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(!Character.isDigit(c)){
                sb.append(c);
            }
            else{
                int k=0;
                while(Character.isDigit(s.charAt(i))){
                    k=k*10+s.charAt(i)-'0';
                    i++;
                }
                i++;
                StringBuilder builder=new StringBuilder();
                int braces=1;
                while(braces!=0){
                    if(s.charAt(i)=='[')
                    braces++;
                    else if(s.charAt(i)==']'){
                    if(--braces==0)
                    break;
                    }
                    builder.append(s.charAt(i));
                    i++;
                }
                String t=decode(builder.toString());
                for(int j=0;j<k;j++)
                sb.append(t);
            }
        }
        return sb.toString();
    }
    public String decodeString(String s) {
        return decode(s);
    }
}