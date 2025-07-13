class ThroneInheritance {
    HashSet<String> set;
    HashMap<String,List<String>> hm;
    String king;
    List<String> ans;
    public ThroneInheritance(String kingName) {
        hm=new HashMap<>();
        set=new HashSet<>();
        king=kingName;
    }
    
    public void birth(String parentName, String childName) {
        if(hm.containsKey(parentName))
        hm.get(parentName).add(childName);
        else{
            List<String> list=new ArrayList<>();
            list.add(childName);
            hm.put(parentName,list);
        }
    }
    
    public void death(String name) {
        set.add(name);
    }
    public void build(String name){
        List<String> children=new ArrayList<>();
        if(hm.containsKey(name))
        children=hm.get(name);
        if(!set.contains(name))
        ans.add(name);
        for(String s:children)
        build(s);
    }
    public List<String> getInheritanceOrder() {
        ans=new ArrayList<>();
        build(king);
        return ans;
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */