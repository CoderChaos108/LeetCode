

class Solution {
    public boolean compare(int[] a,String s){
        for(int i=0;i<a.length;i++){
            char c=s.charAt(i);
            if((a[i]==1&&c=='0')||(a[i]==0&&c=='1'))
                return false;
        }
        return true;
    }

    public void set(int[] a,String s){
        for(int i=0;i<s.length();i++)
            a[i]=s.charAt(i)-'0';
    }

    public String findDifferentBinaryString(String[] nums){
        int n=nums.length;
        int[] a=new int[n];
        Arrays.sort(nums);
        StringBuilder sb=new StringBuilder();

        for(String s:nums){
            if(!compare(a,s)){
                sb.setLength(0);
                for(int i=0;i<s.length();i++)
                    sb.append(s.charAt(i));
                break;
            } else {
                set(a,s);
            }
        }

        if(sb.length()==0){
            sb.setLength(0);
            for(int i=0;i<n;i++)
                sb.append(a[i]==0?'1':'0');
        }

        return sb.toString();
    }
}
