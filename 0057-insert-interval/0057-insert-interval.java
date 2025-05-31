class Solution {
    static ArrayList<int[]> intervals(ArrayList<int[]> list){
        boolean oped=false;
        int[] a=new int[2];
        for(int i=1;i<list.size();i++){
            int[] prev=list.get(i-1);
            int[] curr=list.get(i);
            ArrayList<Integer> p=new ArrayList<Integer>();
            ArrayList<Integer> q=new ArrayList<Integer>();
            for(int val:prev)
            p.add(val);
            for(int val:curr)
            q.add(val);
            if(q.get(0)<=p.get(1)){
                a[0]=p.get(0);
                a[1]=Math.max(p.get(1),q.get(1));
                list.set(i,a);
                list.remove(i-1);
                oped=true;
            }
        }
        if(oped)
        return intervals(list);
        else
        return list;
    }

    public int[][] insert(int[][] intervals,int[] newInterval){
        int[][] a=new int[intervals.length+1][2];
        boolean added=false;
        int x=0;
        for(int i=0;i<intervals.length;i++){
            if(!added&&intervals[i][0]>=newInterval[0]){
                a[x][0]=newInterval[0];
                a[x][1]=newInterval[1];
                x++;
                added=true;
            }
            a[x][0]=intervals[i][0];
            a[x][1]=intervals[i][1];
            x++;
        }
        if(!added){
            a[x][0]=newInterval[0];
            a[x][1]=newInterval[1];
        }

        ArrayList<int[]> temp=new ArrayList<int[]>();
        for(int i=0;i<a.length;i++)
        temp.add(a[i]);

        ArrayList<int[]> re=intervals(temp);

        int[][] fin=new int[re.size()][2];
        x=0;
        for(int[] i:re){
            fin[x][0]=i[0];
            fin[x][1]=i[1];
            x++;
        }
        return fin;
    }
}
