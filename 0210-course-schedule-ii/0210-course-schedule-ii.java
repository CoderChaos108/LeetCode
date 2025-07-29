class Solution {
    Stack<Integer> st=new Stack<>();
    List<List<Integer>> list=new ArrayList<>();
    boolean[] seen,current;
    public boolean build(int i){
        if(current[i])
        return false;
        if(seen[i])
        return true;
        seen[i]=true;
        current[i]=true;
        for(int n:list.get(i)){
        if(build(n)==false)
        return false;
        }
        st.push(i);
        current[i]=false;
        return true;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        seen=new boolean[numCourses];
        current=new boolean[numCourses];
        for(int i=0;i<numCourses;i++)
        list.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++){
            int a=prerequisites[i][0];
            int b=prerequisites[i][1];
            list.get(b).add(a);
        }
        for(int i=0;i<numCourses;i++){
            if(!seen[i]){
                if(build(i)==false)
                return new int[0];
            }
        }
        int[] a=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            a[i]=st.pop();     
        }
        return a;
    }
}