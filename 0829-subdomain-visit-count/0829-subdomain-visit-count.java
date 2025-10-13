class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String domain:cpdomains){
            int itr=0;
            while(!Character.isLetter(domain.charAt(itr)))
            itr++;
            int val=Integer.parseInt(domain.substring(0,itr-1));
            String s1=domain.substring(itr,domain.length());
            String[] subDomains=s1.split("\\.");
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<subDomains.length;i++){
                sb.append(subDomains[i]);
                sb.append('.');
            }
            sb.setLength(sb.length()-1);
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+val);
            sb.setLength(0);
            for(int i=1;i<subDomains.length;i++){
                sb.append(subDomains[i]);
                sb.append('.');
            }
            sb.setLength(sb.length()-1);
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+val);
            sb.setLength(0);
            for(int i=2;i<subDomains.length;i++){
                sb.append(subDomains[i]);
                sb.append('.');
            }
            if(sb.length()!=0){
            sb.setLength(sb.length()-1);
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+val);
            sb.setLength(0);
            }
        }
        List<String> ans=new ArrayList<>();
        for(String s:hm.keySet()){
            StringBuilder sb=new StringBuilder();
            sb.append(String.valueOf(hm.get(s)));
            sb.append(" ");
            sb.append(s);
            ans.add(sb.toString());
        }
        return ans;
    }
}