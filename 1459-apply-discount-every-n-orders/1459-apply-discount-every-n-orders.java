class Cashier {
    int[] a;
    double disFactor;
    int n;
    int count=0;
    int[] id,pri;
    public Cashier(int n, int discount, int[] products, int[] prices) {
        a=new int[201];
        id=products;
        pri=prices;
        this.n=n;
        for(int i=0;i<products.length;i++)
        a[id[i]]=i;
        disFactor=(double)(100-discount);
        disFactor=disFactor/100;
    }
    
    public double getBill(int[] product, int[] amount) {
        count++;
        double bill=0;
        for(int i=0;i<product.length;i++){
            int id=product[i];
            double p=pri[a[id]];
            bill=bill+amount[i]*p;
        }
        if(count%n==0){
        return disFactor*bill;
        }
        return bill;
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */