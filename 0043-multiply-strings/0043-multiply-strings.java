class Solution {
    static String add(String s1,String s2){
    int i=s1.length()-1,j=s2.length()-1,carry=0;
    StringBuilder result=new StringBuilder();
    while(i>=0||j>=0||carry>0){
        int digit1=0;
        int digit2=0;
        if(i>=0)
        digit1=s1.charAt(i--)-'0';
        if(j>=0)
        digit2=s2.charAt(j--)-'0';
        int sum=digit1+digit2+carry;
        result.append(sum%10);
        carry=sum/10;
    }
    return result.reverse().toString();
}

    static String mul(String s,char m,int z){
        int p=0;
        int c=0;
        StringBuilder t=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            p=(s.charAt(i)-'0')*(m-'0');
            p=p+c;
            t.insert(0,String.valueOf(p%10));
            c=p/10;
            p=0;
        }
        if(c!=0){
            t.insert(0,String.valueOf(c));
        }
        for(int i=0;i<z;i++){
            t.append("0");
        }
        return t.toString();
    }
    public String multiply(String nums1, String nums2) {
        if(nums1.equals("0")||nums2.equals("0"))
        return "0";
        if(nums1.equals("1"))
        return nums2;
        if(nums2.equals("1"))
        return nums1;
        StringBuilder sb=new StringBuilder();
            if(nums1.length()<nums2.length()){
                sb.append(nums2);
                nums2=nums1;
                nums1=sb.toString();
                sb.setLength(0);
            }
            for(int i=nums2.length()-1;i>=0;i--){
                if(i==nums2.length()-1)
                sb.append(mul(nums1,nums2.charAt(i),0));
                else{
                    sb.replace(0,sb.length(),add(sb.toString(),mul(nums1,nums2.charAt(i),nums2.length()-1-i)));
                }
            }
            return sb.toString();
        }        
    }