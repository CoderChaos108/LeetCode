class TopVotedCandidate {
    HashMap<Integer,Integer> hm;
    int[] times;
    public TopVotedCandidate(int[] persons,int[] times){
        hm=new HashMap<>();
        this.times=times;
        HashMap<Integer,Integer> a=new HashMap<>();
        int b=-1; 
        int max=0;

        for(int i=0;i<times.length;i++){
            int vote=persons[i];
            int t=times[i];

            a.put(vote,a.getOrDefault(vote,0)+1);

            if(a.get(vote)>=max){
                b=vote;
                max=a.get(vote);
            }

            hm.put(t,b);
        }
    }

    public int q(int t){
        int time=times[0];
        for(int i=1;i<times.length;i++){
            if(times[i]>t)
                return hm.get(times[i-1]);
            time=times[i];
        }
        return hm.get(time);
    }
}
