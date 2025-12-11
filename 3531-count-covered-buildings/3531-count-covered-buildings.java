class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer,List<Integer>> rows=new HashMap<>();
        Map<Integer,List<Integer>> cols=new HashMap<>();
        Map<Integer,Integer> hm=new HashMap<>();
        int itr=0;
        for(int[] a:buildings){
            List<Integer> lr=rows.getOrDefault(a[0],new ArrayList<>());
            List<Integer> lc=cols.getOrDefault(a[1],new ArrayList<>());
            lr.add(itr);
            lc.add(itr);
            rows.put(a[0],lr);
            cols.put(a[1],lc);
            itr++;
        }
        for(int key:rows.keySet()){
            List<Integer> list=rows.get(key);
            if(list.size()<=1)
            continue;
            Collections.sort(list,(a,b)->buildings[a][1]-buildings[b][1]);
            for(int i=0;i<list.size();i++){
                hm.put(list.get(i),hm.getOrDefault(list.get(i),0)+2);
            }
            hm.put(list.get(0),hm.get(list.get(0))-1);
            hm.put(list.get(list.size()-1),hm.get(list.get(list.size()-1))-1);
        }
        for(int key:cols.keySet()){
            List<Integer> list=cols.get(key);
            if(list.size()<=1)
            continue;
            Collections.sort(list,(a,b)->buildings[a][0]-buildings[b][0]);
            for(int i=0;i<list.size();i++){
                hm.put(list.get(i),hm.getOrDefault(list.get(i),0)+2);
            }
            hm.put(list.get(0),hm.get(list.get(0))-1);
            hm.put(list.get(list.size()-1),hm.get(list.get(list.size()-1))-1);
        }
        int ans=0;
        for(int i=0;i<buildings.length;i++){
            if(hm.containsKey(i)&&hm.get(i)==4)
            ans++;
        }
        return ans;
    }
}