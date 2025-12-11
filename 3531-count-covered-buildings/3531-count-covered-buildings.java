class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,Integer> minR=new HashMap<>();
        HashMap<Integer,Integer> maxR=new HashMap<>();
        HashMap<Integer,Integer> minC=new HashMap<>();
        HashMap<Integer,Integer> maxC=new HashMap<>();
        for(int[] a:buildings){
            if(!minR.containsKey(a[0]))
                minR.put(a[0],a[1]);
            if(!maxR.containsKey(a[0]))
                maxR.put(a[0],a[1]);
            if(!minC.containsKey(a[1]))
                minC.put(a[1],a[0]);
            if(!maxC.containsKey(a[1]))
                maxC.put(a[1],a[0]);
            minR.put(a[0],Math.min(minR.get(a[0]),a[1]));
            maxR.put(a[0],Math.max(maxR.get(a[0]),a[1]));
            minC.put(a[1],Math.min(minC.get(a[1]),a[0]));
            maxC.put(a[1],Math.max(maxC.get(a[1]),a[0]));
        }
        int ans=0;
        for(int[] a:buildings){
            int r=a[0];
            int c=a[1];
            if(c>minR.get(r)&&c<maxR.get(r)&&r>minC.get(c)&&r<maxC.get(c))
            ans++;
        }
        return ans;
    }
}