class Solution {
    HashMap<Integer,List<Integer>> hm;
    HashMap<Integer,Boolean> map;
    public boolean check(int n,HashSet set){
        if(map.containsKey(n))
        return map.get(n);
        if(set.contains(n))
        return false;
        if(!hm.containsKey(n))
        return true;
        set.add(n);
        boolean checker=true;
        for(int i:hm.get(n)){
            checker=checker&&check(i,set);
            if(!checker)
            return false;
        }
        map.put(n,checker);
        return checker;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hm=new HashMap<>();
        map=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            if(hm.containsKey(a))
            hm.get(a).add(b);
            else{
                List<Integer> list=new ArrayList<>();
                list.add(b);
                hm.put(a,list);
            }
        }
        boolean flag=true;
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            flag=flag&&check(a,new HashSet<>());
            if(flag==false)
            return flag;
        }
        return flag;
    }
}