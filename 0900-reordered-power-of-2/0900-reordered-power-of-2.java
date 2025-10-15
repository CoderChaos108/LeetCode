class Solution {
    boolean[] seen;
    String s;
    HashSet<Integer> powers;
    boolean ans=false;
    public void find(int val,int k){
        if(k==s.length()){
            if(powers.contains(val))
            ans=true;
            return;
        }
        if(ans)
        return;
        for(int i=0;i<s.length();i++){
            if(seen[i])
            continue;
            int dig=s.charAt(i)-'0';
            if(val==0&&dig==0)
            continue;
            seen[i]=true;
            int newVal=val*10+dig;
            find(newVal,k+1);
            seen[i]=false;
        }
    }
    public boolean reorderedPowerOf2(int n) {
        int itr=1;
        powers =new HashSet<>();
        for(int i=0;i<31;i++){
            powers.add(itr);
            itr=itr*2;
        }
        s=String.valueOf(n);
        seen=new boolean[s.length()];
        find(0,0);
        return ans;
    }
}