class Solution {

    public String shortestBeautifulSubstring(String s, int k) {

        String ans = "";

        for(int i = 0; i < s.length(); i++) {

            int t = 0;
            StringBuilder sb = new StringBuilder();

            for(int j = i; j < s.length(); j++) {

                sb.append(s.charAt(j));

                if(s.charAt(j) == '1')
                    t++;

                if(t == k) {

                    String str = sb.toString();

                    if(ans.length() == 0 ||
                       str.length() < ans.length() ||
                       (str.length() == ans.length() &&
                        str.compareTo(ans) < 0)) {

                        ans = str;
                    }
                }
            }
        }

        return ans;
    }
}