class Solution {
    static ArrayList<int[]> intervals(ArrayList<int[]> list){
        boolean oped=true;
        while(oped){
            oped=false;
            for(int i=1;i<list.size();i++){
                int[] p=list.get(i-1);
                int[] q=list.get(i);
                if(q[0]<=p[1]){
                    int[] a=new int[2];
                    a[0]=p[0];
                    a[1]=Math.max(p[1],q[1]);
                    list.set(i,a);
                    list.remove(i-1);
                    oped=true;
                    break;
                }
            }
        }
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
            x++;
        }

        ArrayList<int[]> temp=new ArrayList<int[]>();
        for(int i=0;i<x;i++)
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
