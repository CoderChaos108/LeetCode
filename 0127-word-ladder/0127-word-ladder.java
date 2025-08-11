class Solution {
    boolean check(String s1,String s2){
        if(s1.length()!=s2.length()||s1.equals(s2))
        return false;
        int x=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                x++;
                if(x>1)
                return false;
            }
        }
        return true;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean exists=false;
        HashSet<String> seen=new HashSet<>();
        HashMap<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<wordList.size();i++){
            String s1=wordList.get(i);
            if(s1.equals(endWord))
            exists=true;
            String s2=beginWord;
            if(check(s1,s2)){
                if(!hm.containsKey(s1));
                    hm.put(s1,new ArrayList<>());
                    if(!hm.containsKey(s2));
                    hm.put(s2,new ArrayList<>());
                    hm.get(s1).add(s2);
                    hm.get(s2).add(s1);
            }
        }
        if(!exists)
        return 0;
        for(int i=0;i<wordList.size();i++){
            String s1=wordList.get(i);
            for(int j=i+1;j<wordList.size();j++){
                String s2=wordList.get(j);
                if(check(s1,s2)){
                    if(!hm.containsKey(s1))
                    hm.put(s1,new ArrayList<>());
                    if(!hm.containsKey(s2))
                    hm.put(s2,new ArrayList<>());
                    hm.get(s1).add(s2);
                    hm.get(s2).add(s1);
                }
            }
        }
        int c=0;
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        seen.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            c++;
            for(int i=0;i<size;i++){
                String s=q.poll();
                if(s.equals(endWord))
                return c;
                if(!hm.containsKey(s))
                continue;
                seen.add(s);
                for(String vicinity:hm.get(s)){
                    if(!seen.contains(vicinity))
                    q.add(vicinity);
                }
            }
        }
        return 0;
    }
}