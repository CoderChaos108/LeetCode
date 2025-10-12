class Solution {
    boolean[][] seen=new boolean[8][8];
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            for(int[] q:queens){
                seen[q[0]][q[1]]=true;
            }
            int ki=king[0];
            int kj=king[1];
            for(int i=1;i<8;i++){
                if(ki+i==8)
                break;
                if(seen[ki+i][kj]){
                    ans.add(Arrays.asList(ki+i,kj));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if(kj+i==8)
                break;
                if(seen[ki][kj+i]){
                    ans.add(Arrays.asList(ki,kj+i));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if((ki+i==8)||(kj+i==8))
                break;
                if(seen[ki+i][kj+i]){
                    ans.add(Arrays.asList(ki+i,kj+i));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if((ki+i==8)||(kj-i==-1))
                break;
                if(seen[ki+i][kj-i]){
                    ans.add(Arrays.asList(ki+i,kj-i));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if((kj-i==-1))
                break;
                if(seen[ki][kj-i]){
                    ans.add(Arrays.asList(ki,kj-i));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if((ki-i==-1)||(kj-1==-1))
                break;
                if(seen[ki-i][kj-i]){
                    ans.add(Arrays.asList(ki-i,kj-i));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if((ki-i==-1))
                break;
                if(seen[ki-i][kj]){
                    ans.add(Arrays.asList(ki-i,kj));
                    break;
                }
            }
            for(int i=1;i<8;i++){
                if((ki-i==-1)||(kj+i==8))
                break;
                if(seen[ki-i][kj+i]){
                    ans.add(Arrays.asList(ki-i,kj+i));
                    break;
                }
            }
            return ans;
    }
}