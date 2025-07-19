class Solution {
    public List<String> removeSubfolders(String[] folder) {
        HashSet<String> set=new HashSet<>();
        List<String> list=new ArrayList<>();
        for(String str:folder)
        set.add(str);
        for(String str:folder){
            StringBuilder sb=new StringBuilder();
            boolean sub=false;
            String[] sarr=str.substring(1,str.length()).split("/");
            for(String s:sarr){
                sb.append("/"+s);
                if(set.contains(sb.toString())&&!str.equals(sb.toString())){
                sub=true;
                break;
                }
            }
            if(!sub){
            list.add(sb.toString());
            }
        }
        return list;
    }
}