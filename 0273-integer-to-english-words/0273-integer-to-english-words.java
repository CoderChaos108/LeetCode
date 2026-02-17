import java.util.*;

class Solution {
    HashMap<Integer,String> hm=new HashMap<>();

    public String print(String s,int post){
        StringBuilder ans=new StringBuilder();

        if(s.length()==1){
            ans.append(hm.get(Integer.valueOf(s))).append(" ");
        }
        else{
            if(s.length()==3){
                if(s.charAt(0)!='0')
                ans.append(hm.get(s.charAt(0)-'0')).append(" Hundred ");
                if(s.charAt(1)!='0'){
                if(s.charAt(1)=='1')
                ans.append(hm.get(Integer.valueOf(s.substring(1,3)))).append(" ");
                else
                ans.append(hm.get((s.charAt(1)-'0')*10)).append(" ");
                }
            }
            else{
                if(s.charAt(0)!='0'){
                    if(s.charAt(0)=='1')
                ans.append(hm.get(Integer.valueOf(s.substring(0,2)))).append(" ");
                else
                ans.append(hm.get((s.charAt(0)-'0')*10)).append(" ");
                }
            }
            if(s.charAt(s.length()-1)!='0'&&s.charAt(s.length()-2)!='1')
            ans.append(hm.get(s.charAt(s.length()-1)-'0')).append(" ");
        }

        if(post>1&&Integer.valueOf(s)!=0)
        ans.append(hm.get(post)).append(" ");

        return ans.toString();
    }

    public String numberToWords(int num){

        hm.put(0,"Zero");hm.put(1,"One");hm.put(2,"Two");hm.put(3,"Three");
        hm.put(4,"Four");hm.put(5,"Five");hm.put(6,"Six");hm.put(7,"Seven");
        hm.put(8,"Eight");hm.put(9,"Nine");hm.put(10,"Ten");hm.put(11,"Eleven");
        hm.put(12,"Twelve");hm.put(13,"Thirteen");hm.put(14,"Fourteen");
        hm.put(15,"Fifteen");hm.put(16,"Sixteen");hm.put(17,"Seventeen");
        hm.put(18,"Eighteen");hm.put(19,"Nineteen");hm.put(20,"Twenty");
        hm.put(30,"Thirty");hm.put(40,"Forty");hm.put(50,"Fifty");
        hm.put(60,"Sixty");hm.put(70,"Seventy");hm.put(80,"Eighty");
        hm.put(90,"Ninety");hm.put(100,"Hundred");
        hm.put(1000,"Thousand");hm.put(1000000,"Million");
        hm.put(1000000000,"Billion");

        if(num==0)
        return hm.get(0);

        String s=String.valueOf(num);
        StringBuilder ans=new StringBuilder();

        int post=1;

        for(int i=s.length()-1;i>=0;i=i-3){
            StringBuilder str=new StringBuilder();
            for(int j=i;j>=i-2&&j>=0;j--)
            str.insert(0,s.charAt(j));

            ans.insert(0,print(str.toString(),post));

            post=post*1000;
        }

        return ans.toString().trim();
    }
}
