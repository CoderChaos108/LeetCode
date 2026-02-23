class Solution {
    HashSet<List<Character>> set=new HashSet<>();
    public boolean hasAllCodes(String s, int k) {
            List<Character> list=new LinkedList<>();
            for(int i=0;i<k&&i<s.length();i++)
            list.add(s.charAt(i));
            set.add(list);
            int r=k;
            while(r<s.length()){
                list.add(s.charAt(r));
                list.removeFirst();
                r++;
                set.add(list);
            }
            return set.size()==(int)(Math.pow(2,k));
    }
}