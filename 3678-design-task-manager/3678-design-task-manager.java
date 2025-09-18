class TaskManager {
    HashMap<Long,Long> tm=new HashMap<>();
    HashSet<List<Long>> removeSet=new HashSet<>();
    HashMap<Long,Long> pm=new HashMap<>();
    PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->{
        if (a[2]!=b[2])
            return Long.compare(b[2],a[2]);
        else
            return Long.compare(b[1],a[1]);
    });
    
    public TaskManager(List<List<Integer>> tasks) {
        for(List<Integer> list:tasks){
            long userId=list.get(0);
            long taskId=list.get(1);
            long priority=list.get(2);
            pq.add(new long[]{userId,taskId,priority});
            tm.put(taskId,userId);
            pm.put(taskId,priority);
        }
    }
    
    public void add(long userId, long taskId, long priority) {
        pq.add(new long[]{userId,taskId,priority});
        tm.put(taskId,userId);     
        pm.put(taskId,priority);
    }
    
    public void edit(long taskId, long newPriority) {
        pq.add(new long[]{tm.get(taskId),taskId,newPriority});
        pm.put(taskId,newPriority);
    }
    
    public void rmv(long taskId) {
        removeSet.add(Arrays.asList(tm.get(taskId),taskId));
        tm.remove(taskId);
        pm.remove(taskId);
    }
    
    public long execTop() {
        while(!pq.isEmpty()){
            long[] a=pq.poll();
            if(removeSet.contains(Arrays.asList(a[0],a[1]))){
                continue;
            }
            if(!pm.containsKey(a[1]) || !pm.get(a[1]).equals(a[2]))
                continue;
            tm.remove(a[1]);
            pm.remove(a[1]);
            return a[0];
        }
        return -1;
    }
}
