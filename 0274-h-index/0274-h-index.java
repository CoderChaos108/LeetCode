class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if(citations.length==1){
            if(citations[0]==0)
            return 0;
            else
            return 1;
        }
        if(citations.length==2){
            if(citations[0]==0&&citations[1]!=0)
            return 1;
            else if(citations[0]==0&&citations[1]==0)
            return 0;
            else if(citations[0]==1&&citations[1]==1)
            return 1;
            else if(citations[0]==1&&citations[1]==2)
            return 1;
            else 
            return 2;
        }
        int r=citations.length-1;
        int l=0;
        int m=(r+l)/2;
        while(l>-1){
            if(r-l<2){
                if(citations.length-l<=citations[l])
                return citations.length-l;
                else if(citations.length-r<=citations[r])
                return citations.length-r;
                else
                return 0;
            }
            m=(r+l)/2;
            if(citations.length-m<=citations[m]){
                if(m!=0&&citations.length-m+1<=citations[m-1])
                r=m;
                else
                return citations.length-m;
            }
            else{
                l=m;
            }
        }
        return 0;
    }
}