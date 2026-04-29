class Solution {
    public String rankTeams(String[] votes) {
        int[][] a=new int[26][26];
        List<Integer> list=new ArrayList<>();
        for(String s:votes){
            for(int i=0;i<s.length();i++){
                int idx=s.charAt(i)-'A';
                a[idx][i]++;
            }
        }
        for(int i=0;i<votes[0].length();i++){
            list.add(votes[0].charAt(i)-'A');
        }
        Collections.sort(list,(x,y)->{
            for(int i=0;i<26;i++){
                if(a[x][i]!=a[y][i])
                return -a[x][i]+a[y][i];
            }
            return x-y;
        });
        StringBuilder sb=new StringBuilder();
        for(int c:list)
        sb.append((char)('A'+c));
        return sb.toString();
    }
}