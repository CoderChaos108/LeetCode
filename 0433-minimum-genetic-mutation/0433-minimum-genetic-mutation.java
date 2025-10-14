class Solution {
    public boolean check(String s1,String s2){
        int c=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
            c++;
            if(c>1)
            return false;
        }
        return true;
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashMap<String,List<String>> hm=new HashMap<>();
        hm.put(startGene,new ArrayList<>());
        for(String s:bank)
        hm.put(s,new ArrayList<>());
        for(int i=0;i<bank.length;i++){
            if(check(startGene,bank[i]))
            hm.get(startGene).add(bank[i]);
        }
        for(int i=0;i<bank.length;i++){
            String s1=bank[i];
            for(int j=i+1;j<bank.length;j++){
                String s2=bank[j];
                if(check(s1,s2)){
                hm.get(s1).add(s2);
                hm.get(s2).add(s1);
                }
            }
        }
        HashSet<String> seen=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.add(startGene);
        int c=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(!seen.add(s))
                continue;
                if(s.equals(endGene))
                return c;
                for(String mutation:hm.get(s))
                q.add(mutation);
            }
            c++;
        }
        return -1;
    }
}