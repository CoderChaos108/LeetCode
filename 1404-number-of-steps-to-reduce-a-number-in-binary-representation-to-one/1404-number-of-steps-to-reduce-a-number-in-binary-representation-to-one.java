class Solution {
    public int numSteps(String s) {
        LinkedList<Integer> list=new LinkedList<>();
        int n=s.length()-1;
        for(int i=0;i<=n;i++){
            list.add(s.charAt(i)-'0');
        }
        int steps=0;
        while(list.size()>1){
            int i=list.size()-1;
            if(list.get(i)==1){
                steps++;
                for(int j=i-1;j>=0;j--){
                    if(list.get(j)==0){
                        list.set(j,1);
                        break;
                    }
                    if(j==0){
                        list.addFirst(1);
                        list.set(1,0);
                        break;
                    }
                    list.set(j,0);
                }
            }
            steps++;
                list.removeLast();
        }
        return steps;
    }
}