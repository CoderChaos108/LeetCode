class ProductOfNumbers {
    List<Integer> prefix;
    int p,lastZero;
    public ProductOfNumbers() {
        prefix=new ArrayList<>();
        lastZero=-1;
        p=1;
    }
    
    public void add(int num) {
        if(num==0){
            lastZero=prefix.size();
            prefix.add(1);
            p=1;
            return;
        }
        p=p*num;
        prefix.add(p);
    }
    
    public int getProduct(int k) {
        int size=prefix.size();
        if(lastZero>=size-k)
        return 0;
        if(size-k-1<0)
        return prefix.get(size-1);
        return prefix.get(size-1)/prefix.get(size-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */