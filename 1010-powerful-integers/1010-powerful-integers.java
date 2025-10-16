class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        HashSet<Integer> set=new HashSet<>();
        int n1=1;
        while(n1+1<=bound){
            int n2=1;
            while(n2+n1<=bound){
                set.add(n1+n2);
                n2=n2*y;
                if(y==1)
                break;
            }
            n1=n1*x;
            if(x==1)
            break;
        }
        return new ArrayList<>(set);
    }
}