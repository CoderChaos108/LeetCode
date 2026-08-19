class Solution {
    public int maxNumberOfFamilies(int n, int[][] a) {
        int ans=0;
        Arrays.sort(a,(arr,brr)->{
            if(arr[0]!=brr[0])
            return arr[0]-brr[0];
            return arr[1]-brr[1];
        });
        int last=0;
        
        int m=a.length;
        for(int i=0;i<m;i++){
            ans=ans+2*(a[i][0]-last-1);
            last=a[i][0];
            int j=i;
            boolean[] seen=new boolean[11];
            while(j<m&&a[j][0]==last){
                seen[a[j][1]]=true;
                j++;
            }
            i=j;
            boolean res=true;
            res=true;
            for(int k=2;k<=5;k++){
                if(seen[k]){
                    res=false;
                    break;
                }
            }
            if(res){
                for(int k=2;k<=5;k++)
                seen[k]=true;
                ans++;
            }
            res=true;
            for(int k=4;k<=7;k++){
                if(seen[k]){
                    res=false;
                    break;
                }
            }
            if(res){
                for(int k=4;k<=7;k++)
                seen[k]=true;
                ans++;
            }
            res=true;
            for(int k=6;k<=9;k++){
                if(seen[k]){
                    res=false;
                    break;
                }
            }
            if(res){
                for(int k=6;k<=9;k++)
                seen[k]=true;
                ans++;
            }
            i--;
        }
        ans=ans+(n-last)*2;
        return ans;
    }
}