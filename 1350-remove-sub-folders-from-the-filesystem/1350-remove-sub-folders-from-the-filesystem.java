class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> list=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        Arrays.sort(folder);
        for(String str:folder){
            StringBuilder sb=new StringBuilder();
            boolean sub=false;
            String[] sarr=str.substring(1,str.length()).split("/");
            for(String s:sarr){
                sb.append("/"+s);
                if(set.contains(sb.toString())){
                sub=true;
                break;
                }
            }
            if(!sub){
            list.add(sb.toString());
            set.add(sb.toString());
            }
        }
        return list;
    }
}