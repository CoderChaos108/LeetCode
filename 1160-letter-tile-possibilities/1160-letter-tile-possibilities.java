class Solution {
    boolean[] seen;
    int c;
    String s;
    public void find(){
        c++;
        for(int i=0;i<s.length();i++){
            if(seen[i])
            continue;
            if(i!=0&&!seen[i-1]&&s.charAt(i)==s.charAt(i-1))
            continue;
            seen[i]=true;
            find();
            seen[i]=false;
        }
    }
    public int numTilePossibilities(String tiles) {
        char[] arr=new char[tiles.length()];
        for(int i=0;i<tiles.length();i++)
        arr[i]=tiles.charAt(i);
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        sb.append(arr[i]);
        s=sb.toString();
        seen=new boolean[tiles.length()];
        find();
        return c-1;
    }
}