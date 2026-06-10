class Solution {
    public void add(HashSet<Integer> set,int i,int tight,int started){
        set.add(i+10);
        set.add(tight+20);
        set.add(started+30);
    }
    public void remove(HashSet<Integer> set,int i,int tight,int started){
        set.remove(i+10);
        set.remove(tight+20);
        set.remove(started+30);
        
    }
    HashMap<HashSet<Integer>,Integer> hm=new HashMap<>();
    public int find(HashSet<Integer> set,int i,int tight,int started,String s){
        if(i==s.length())
        return started;
        add(set,i,tight,started);
        if(hm.containsKey(set)){
        int ans=hm.get(set);
        remove(set,i,tight,started);
        return ans;
        }
        remove(set,i,tight,started);
         int res=0;
        if(started==0){
            res=res+find(set,i+1,0,0,s);
        }
        int lim=9;
        if(tight==1)
        lim=s.charAt(i)-'0';
       int start=started^1;
        for(int d=start;d<=lim;d++){
            if(set.contains(d))
            continue;
            set.add(d);
            int newTight=0;
            if(tight==1&&d==lim)
            newTight=1;
            res=res+find(set,i+1,newTight,1,s);
            set.remove(d);
        }
        add(set,i,tight,started);
        hm.put(new HashSet<>(set),res);
        remove(set,i,tight,started);
        return res;
    }
    public int countSpecialNumbers(int n) {
        return find(new HashSet<>(),0,1,0,String.valueOf(n));
    }
}