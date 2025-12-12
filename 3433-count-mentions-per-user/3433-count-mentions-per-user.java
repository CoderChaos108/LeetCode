class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions=new int[numberOfUsers];
        int[] online=new int[numberOfUsers];
        Collections.sort(events,(a,b)->{
            int comp=Integer.valueOf(a.get(1))-Integer.valueOf(b.get(1));
            if(comp!=0) 
            return comp;
            boolean am=a.get(0).charAt(0)=='M';
            boolean bm=b.get(0).charAt(0)=='M';
            if(am&&!bm)
            return 1;
            if(!am&&bm)
            return -1;
            return 0;
        });

        for(List<String> event:events){
            int time=Integer.valueOf(event.get(1));
            if(event.get(0).charAt(0)=='O'){
                int id=Integer.valueOf(event.get(2));
                online[id]=time+60;
            }
            else{
               char type=event.get(2).charAt(0);
                if(type=='A'){
                    for(int i=0;i<numberOfUsers;i++)
                    mentions[i]++;
                }
                else if(type=='H'){
                    for(int i=0;i<numberOfUsers;i++){
                        if(online[i]<=time){
                            mentions[i]++;
                        }
                    }
                }
                else{
                    String[] ids=event.get(2).split(" ");
                    for(String s:ids){
                        int id=Integer.valueOf(s.substring(2,s.length()));
                        mentions[id]++;
                    }
                }
            }
        }
        return mentions;
    }
}