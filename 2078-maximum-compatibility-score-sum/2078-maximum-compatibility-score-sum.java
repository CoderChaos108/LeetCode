class Solution {
    int ans=0;
    int m,n;
    boolean[] seen;
    int[][] students,mentors;
    public int comp(int stu,int men){
        int c=0;
        for(int i=0;i<n;i++){
            if(students[stu][i]==mentors[men][i])
            c++;
        }
        return c;
    }
    public void find(int k,int c){
        if(k>=m){
            ans=Math.max(ans,c);
            return;
        }
        for(int i=0;i<m;i++){
            if(seen[i]){
                continue;
            }
            seen[i]=true;
            find(k+1,c+comp(k,i));
            seen[i]=false;
        }
    }
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        m=students.length;
        n=students[0].length;
        seen=new boolean[m];
        this.mentors=mentors;
        this.students=students;
        find(0,0);
        return ans;
    }
}