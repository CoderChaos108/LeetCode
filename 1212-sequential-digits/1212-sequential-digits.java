class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<9;i++)
        q.add(i);
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int val=q.poll();
                int last=val%10;
                if(last==9)
                continue;
                int newVal=val*10+last+1;
                if(newVal>high)
                continue;
                if(newVal>=low)
                ans.add(newVal);
                q.add(newVal);
            }
        }
        return ans;
    }
}