class Solution {
    HashSet<List<Integer>> seen=new HashSet<>();
    public List<Integer> check(List<Integer> list1,List<Integer> list2){
        int size=Math.min(list1.size(),list2.size());
        for(int i=0;i<size;i++){
            int val1=list1.get(i);
            int val2=list2.get(i);
            if(val1>val2)
            return list2;
            else if(val2>val1)
            return list1;
        }
        if(size==list1.size())
        return list1;
        else
        return list2;
    }
    int a,b;
    List<Integer> ans=new ArrayList<>();
    public void find(List<Integer> list){
        if(!seen.add(list))
        return;
        ans=new ArrayList<>(check(ans,list));
        for(int i=1;i<list.size();i=i+2){
            list.set(i,(list.get(i)+a)%10);
        }
        find(list);
        for(int i=1;i<list.size();i=i+2){
            list.set(i,(list.get(i)-a+10)%10);
        }
        int[] temp=new int[list.size()];
        List<Integer> rotated=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int idx=0;
            if(i-b>=0){
                idx=i-b;
            }
            else
            idx=list.size()+(i-b);
            rotated.add(list.get(idx));
        }
        find(rotated);
    }
    public String findLexSmallestString(String s, int a, int b) {
       List<Integer> list=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            list.add(s.charAt(i)-'0');
        }
        ans=new ArrayList<>(list);
        this.a=a;
        this.b=b;
        b=b%s.length();
        find(list);
        StringBuilder sb=new StringBuilder();
        for(int i:ans){
            sb.append((char)(i+'0'));
        }
        return sb.toString();
    }
}