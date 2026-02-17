class Solution {
    HashMap<Integer,String> hm=new HashMap<>();
    public String print(String s,int post){
        String ans="";
            if(s.length()==1){
            ans=ans+hm.get(Integer.valueOf(s))+" ";
        }
        else{
            if(s.length()==3){
                if(s.charAt(0)!='0')
                ans=ans+hm.get(s.charAt(0)-'0')+" Hundred ";
                if(s.charAt(1)!='0'){
                if(s.charAt(1)=='1')
                ans=ans+hm.get(Integer.valueOf(s.substring(1,3)))+" ";
                else
                ans=ans+ hm.get((s.charAt(1)-'0')*10)+" ";
                }
            }
            else{
                if(s.charAt(0)!='0'){
                    if(s.charAt(0)=='1')
                ans=ans+hm.get(Integer.valueOf(s.substring(0,2)))+" ";
                else
                ans=ans+ hm.get((s.charAt(0)-'0')*10)+" ";
                }
            }
            if(s.charAt(s.length()-1)!='0'&&s.charAt(s.length()-2)!='1')
            ans=ans+hm.get(s.charAt(s.length()-1)-'0')+" ";
        }
        if(post!=-1&&Integer.valueOf(s)!=0)
        ans=ans+hm.get(post)+" ";
        return ans;
    }
    public String numberToWords(int num) {
        hm.put(0, "Zero");
        hm.put(1, "One");
        hm.put(2, "Two");
        hm.put(3, "Three");
        hm.put(4, "Four");
        hm.put(5, "Five");
        hm.put(6, "Six");
        hm.put(7, "Seven");
        hm.put(8, "Eight");
        hm.put(9, "Nine");
        hm.put(10, "Ten");
        hm.put(11, "Eleven");
        hm.put(12, "Twelve");
        hm.put(13, "Thirteen");
        hm.put(14, "Fourteen");
        hm.put(15, "Fifteen");
        hm.put(16, "Sixteen");
        hm.put(17, "Seventeen");
        hm.put(18, "Eighteen");
        hm.put(19, "Nineteen");
        hm.put(20, "Twenty");
        hm.put(30, "Thirty");
        hm.put(40, "Forty");
        hm.put(50, "Fifty");
        hm.put(60, "Sixty");
        hm.put(70, "Seventy");
        hm.put(80, "Eighty");
        hm.put(90, "Ninety");
        hm.put(100, "Hundred");
        hm.put(1000, "Thousand");
        hm.put(1000000, "Million");
        hm.put(1000000000, "Billion");
        if(num/10==0){
            return hm.get(num);
        }
        String s=String.valueOf(num);
        String ans="";
        int post=-1;
        for(int i=s.length()-1;i>=0;i=i-3){
            String str="";
            for(int j=i;j>=i-2&&j>=0;j--){
            str=s.charAt(j)+str;
            }
            ans=print(str,post)+ans;
            post=Math.abs(post*1000);
        }
        if(!Character.isLetter(ans.charAt(ans.length()-1)))
        ans=ans.substring(0,ans.length()-1);
        return ans;
    }
}