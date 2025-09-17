class FoodRatings {
    public class Pair{
        String str;
        int val;
        public Pair(String str,int val){
            this.str=str;
            this.val=val;
        }
    }
    HashMap<String,PriorityQueue<Pair>> hm=new HashMap<>();
    HashMap<String,Integer> id=new HashMap<>();
    HashMap<String,String> menu=new HashMap<>();
    String[] f,c;
    int[] rat;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        f=foods;
        c=cuisines;
        rat=ratings;
        for(int i=0;i<foods.length;i++){
        id.put(foods[i],i);
        menu.put(foods[i],c[i]);
        }
        for(String s:cuisines){
            if(hm.containsKey(s))
            continue;
            PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
                int r1=a.val;
                int r2=b.val;
                if(r1!=r2)
                return r2-r1;
                else
                return a.str.compareTo(b.str);
            });
            hm.put(s,pq);
        }
        for(int i=0;i<f.length;i++){
            hm.get(c[i]).add(new Pair(f[i],rat[i]));
        }
    }
    
    public void changeRating(String food, int newRating) {
        rat[id.get(food)]=newRating;
        PriorityQueue<Pair> pq=hm.get(menu.get(food));
        pq.add(new Pair(food,rat[id.get(food)]));
    }
    
    public String highestRated(String cuisine) {
        PriorityQueue<Pair> pq=hm.get(cuisine);
        while(true){
            Pair p=pq.peek();
            if(p.val==rat[id.get(p.str)])
            return p.str;
            pq.poll();
        }
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */