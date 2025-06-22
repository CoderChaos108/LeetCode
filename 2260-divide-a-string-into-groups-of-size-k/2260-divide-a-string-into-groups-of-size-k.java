class Solution {
    public String[] divideString(String s, int k, char fill) {
        int size=s.length()/k;
        if(s.length()%k!=0)
        size++;
        String[] a=new String[size];
        int x=0;
        for(int i=0;i<s.length();i=i+k){
            if(i+k>s.length()){
                StringBuilder sb=new StringBuilder();
                sb.append(s.substring(i,s.length()));
                while(sb.length()!=k)
                sb.append(fill);
                a[x]=sb.toString();
                break;
            }
            a[x]=s.substring(i,i+k);
            x++;
        }
        return a;
    }
}