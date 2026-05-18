class Solution {
    
    int n;
    HashMap<Integer,List<Integer>> hm;
    public int minJumps(int[] arr) {
        n=arr.length;
         hm=new HashMap<>();
        int idx=0;
        for(int i:arr){
            if(!hm.containsKey(i))
            hm.put(i,new ArrayList<>());
            hm.get(i).add(idx++);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] seen=new boolean[n];
        int steps=0;
        q.add(0);
        while(!q.isEmpty()){
            int size=q.size();
            for(int id=0;id<size;id++){
                int i=q.poll();
                if(i==n-1)
                return steps;
                int val=arr[i];
                int[] moves={i-1,i+1};
                if(seen[i])
                continue;
                seen[i]=true;
                for(int ni:moves){
                    if(ni<0||ni>=n)
                    continue;
                    q.add(ni);
                }
                if(hm.containsKey(val)){
                    List<Integer> list=hm.get(val);
                for(int ni:list){
                    if(ni<0||ni>=n)
                    continue;
                    q.add(ni);
                }
                }
                hm.remove(val);
                
            }
            steps++;
        }
        return -1;
    }
}