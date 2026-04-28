class Solution {
    public String repeatLimitedString(String s,int repeatLimit) {
       
        int k=repeatLimit;
        List<Character> order=new ArrayList<>();
        int[] a=new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        for(int i=25;i>=0;i--){
            if(a[i]!=0)
            order.add((char)(i+'a'));
        }
        int i=0;
        StringBuilder sb=new StringBuilder();

        while(i<order.size()){
            char ic=order.get(i);

            if(a[ic-'a']==0){
                i++;
                continue;
            }

            int t=Math.min(k,a[ic-'a']);
            for(int x=0;x<t;x++)
                sb.append(ic);
    
            a[ic-'a']=a[ic-'a']-t;

            if(a[ic-'a']!=0){
                int j=i+1;
                while(j<order.size()){
                    char jc=order.get(j);
                    if(a[jc-'a']!=0){
                        sb.append(jc);
                        a[jc-'a']--;
                        break;
                    }
                    j++;
                }
                if(j==order.size())
                    return sb.toString();
            }
        }

        return sb.toString();
    }
}