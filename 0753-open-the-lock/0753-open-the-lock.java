class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<List<Integer>> q=new LinkedList<>();
        q.add(Arrays.asList(0,0,0,0));
        List<Integer> t=new ArrayList<>();
        for(char c:target.toCharArray())
        t.add(c-'0');

        HashSet<List<Integer>> set=new HashSet<>();
        for(String s:deadends){
            List<Integer> d=new ArrayList<>();
            for(char c:s.toCharArray())
            d.add(c-'0');
            set.add(d);
        }

        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                List<Integer> list=q.poll();

                if(set.contains(list))
                continue;
                if(list.equals(t))
                return count;

                set.add(list);

                int a=list.get(0);
                int b=list.get(1);
                int c=list.get(2);
                int d=list.get(3);

                q.add(Arrays.asList((a+1)%10,b,c,d));
                q.add(Arrays.asList((a+9)%10,b,c,d));

                q.add(Arrays.asList(a,(b+1)%10,c,d));
                q.add(Arrays.asList(a,(b+9)%10,c,d));

                q.add(Arrays.asList(a,b,(c+1)%10,d));
                q.add(Arrays.asList(a,b,(c+9)%10,d));

                q.add(Arrays.asList(a,b,c,(d+1)%10));
                q.add(Arrays.asList(a,b,c,(d+9)%10));
            }
            count++;
        }
        return -1;
    }
}
