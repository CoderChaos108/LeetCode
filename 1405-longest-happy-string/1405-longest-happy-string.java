class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb=new StringBuilder();

        while(true){
            int n=sb.length();

            boolean aa=n<2||sb.charAt(n-1)!='a'||sb.charAt(n-2)!='a';
            boolean bb=n<2||sb.charAt(n-1)!='b'||sb.charAt(n-2)!='b';
            boolean cc=n<2||sb.charAt(n-1)!='c'||sb.charAt(n-2)!='c';

            if(aa&&a>=b&&a>=c&&a>0){
                sb.append('a');
                a--;
            }
            else if(bb&&b>=a&&b>=c&&b>0){
                sb.append('b');
                b--;
            }
            else if(cc&&c>=a&&c>=b&&c>0){
                sb.append('c');
                c--;
            }
            else if(aa&&a>0){
                sb.append('a');
                a--;
            }
            else if(bb&&b>0){
                sb.append('b');
                b--;
            }
            else if(cc&&c>0){
                sb.append('c');
                c--;
            }
            else{
                break;
            }
        }

        return sb.toString();
    }
}