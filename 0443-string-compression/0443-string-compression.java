class Solution {
    public int compress(char[] c) {
        StringBuilder sb=new StringBuilder();
        sb.append(c[0]);
        int l=1;
        int len=c.length;
        for(int i=1;i<len;i++){
            if(c[i-1]!=c[i]){
                if(l!=1)
                sb.append(String.valueOf(l));
                sb.append(c[i]);
                l=1;
            }
            else
            l++;
        }
        if(l!=1)
        sb.append(String.valueOf(l));
        len=sb.length();
        for(int i=0;i<len;i++){
            c[i]=sb.charAt(i);
        }
        return sb.length();
    }
}