class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        List<Integer> list=new ArrayList<>();
        int n=code.length;
        Set<String> set=Set.of("electronics", "grocery", "pharmacy", "restaurant");
        for(int i=0;i<n;i++){
            String c=code[i];
            if(!set.contains(businessLine[i]))
            continue;
            if(c.length()==0)
            continue;
            boolean cont=false;
            for(int j=0;j<c.length();j++){
                char ch=c.charAt(j);
                if(!Character.isDigit(ch)&&!Character.isLetter(ch)&&ch!='_'){
                    cont=true;
                    break;
                }
            }
            if(cont)
            continue;
            if(isActive[i])
            list.add(i);
        }
        Map<Character,Integer> hm=new HashMap<>();
        hm.put('e',4);
        hm.put('g',3);
        hm.put('p',2);
        hm.put('r',1);
        Collections.sort(list,(a,b)->{
            char c1=businessLine[a].charAt(0);
            char c2=businessLine[b].charAt(0);
            if(c1!=c2)
            return hm.get(c2)-hm.get(c1);
            return -a.compareTo(b);
        });
        List<String> ans=new ArrayList<>();
        for(int i:list){
            ans.add(code[i]);
        }
        return ans;
    }
}