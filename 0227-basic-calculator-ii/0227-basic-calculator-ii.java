class Solution {
    public int calculate(String s) {
        StringBuilder sb=new StringBuilder();
        ArrayList<String> list=new ArrayList<>();
        int l=s.length();
        for(int i=0;i<l;i++){
            if(s.charAt(i)==' ')
            continue;
            while(i<l&&Character.isDigit(s.charAt(i))){
                sb.append(s.charAt(i));
                i++;
            }
            if(sb.length()>0)
            list.add(sb.toString());
            sb.setLength(0);
            
            if(i<l){
            if(s.charAt(i)==' ')
            continue;
            list.add(s.charAt(i)+"");
            }
        }
        String a;
        String b;
        int x=0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).equals("/")){
                a=list.get(i-1);
                b=list.get(i+1);
                x=(Integer.valueOf(a))/(Integer.valueOf(b));
                list.set(i-1,String.valueOf(x));
                list.remove(i+1);
                list.remove(i);
                i=i-1;
            }
            if(list.get(i).equals("*")){
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
            if(Character.isDigit(t.charAt(0)))
            x=x+Integer.valueOf(t)*sign;
            else{
                if(t.equals("+"))
                sign=1;
                else
                sign=-1;
            }
        }

        return x;
    }
}