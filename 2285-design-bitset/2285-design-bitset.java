class Bitset {
    boolean one;
    int size;
    HashSet<Integer> set;
    public Bitset(int size) {
        one=true;
        set=new HashSet<>();
        this.size=size;
    }
    
    public void fix(int idx) {
        if(one){
            set.add(idx);
        }
        else
        set.remove(idx);
    }
    
    public void unfix(int idx) {
        if(!one){
            set.add(idx);
        }
        else
        set.remove(idx);   
    }
    
    public void flip() {
        one=!one;
    }
    
    public boolean all() {
        if(one){
            if(set.size()==size)
            return true;
            else
            return false;
        }
        else{
            if(set.size()==0)
            return true;
            else
            return false;
        }
    }
    
    public boolean one() {
        if(one){
            if(set.size()>=1)
            return true;
            else
            return false;
        }
        else{
            if(set.size()==size)
            return false;
            else
            return true;
        }
    }
    
    public int count() {
        if(one)
        return set.size();
        else
        return size-set.size();
    }
    
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<size;i++){
            if(one){
                if(set.contains(i))
                sb.append('1');
                else
                sb.append('0');
            }
            else{
                if(set.contains(i))
                sb.append('0');
                else
                sb.append('1');
            }
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */