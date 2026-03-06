class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans=0;
        int n=points.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==i)
                continue;
                for(int k=0;k<n;k++){
                    if(k==i||k==j)
                    continue;
                    int[] x=points[i];
                    int[] y=points[j];
                    int[] z=points[k];
                    int dis1=Math.abs(x[0]-y[0])+Math.abs(x[1]-y[1]);
                    int dis2=Math.abs(x[0]-z[0])+Math.abs(x[1]-z[1]);
                    if(dis1==dis2)
                    ans++;
                }
            }
        }
        return ans;
    }
}