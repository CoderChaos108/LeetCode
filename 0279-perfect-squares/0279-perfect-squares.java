class Solution {
    public int numSquares(int n) {
        List<Integer> list=new ArrayList<>();
        int num=1;
        while(num*num<=n){
            list.add(num*num);
            num++;
        }
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> seen=new HashSet<>();
        int steps=0;
        for(int nums:list)
        q.add(nums);
        while(true){
            steps++;
            int size=q.size();
            for(int i=0;i<size;i++){
                int s=q.poll();
                if(!seen.add(s))
                continue;
                if(s==n)
                return steps;
                for(int nums:list){
                    if(s+nums>n)
                    break;
                    q.add(s+nums);
                }
            }
        }
    }
}