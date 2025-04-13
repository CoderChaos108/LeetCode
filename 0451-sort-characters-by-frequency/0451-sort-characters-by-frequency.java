class Solution {
    public String frequencySort(String s) {
        String[] a=new String[62];
        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
            if(Character.isUpperCase(s.charAt(i))){
                if(a[s.charAt(i)-'A']!=null)
                a[s.charAt(i)-'A']=a[s.charAt(i)-'A']+s.charAt(i);
                else
                a[s.charAt(i)-'A']=""+s.charAt(i);
            }
            else{
                if(a[s.charAt(i)-'a'+26]!=null)
                a[s.charAt(i)-'a'+26]=a[s.charAt(i)-'a'+26]+s.charAt(i);
                else
                a[s.charAt(i)-'a'+26]=""+s.charAt(i);
            }
            }
            else{
                if(a[s.charAt(i)-'0'+52]!=null){
                    a[s.charAt(i)-'0'+52]=a[s.charAt(i)-'0'+52]+s.charAt(i);
                }
                else
                a[s.charAt(i)-'0'+52]=""+s.charAt(i);
            }
        }
        Arrays.sort(a, (s1, s2) -> {
            if (s1 == null && s2 == null) return 0; 
            if (s1 == null) return -1;
            if (s2 == null) return 1;
            return Integer.compare(s1.length(), s2.length()); 
        });
        StringBuilder sb=new StringBuilder();
        for(int i=a.length-1;i>=0;i--){
            if(a[i]!=null)
            sb.append(a[i]);
        }
        return sb.toString();
    }
}