class UndergroundSystem{
    HashMap<Integer,List<String>>hm;
    HashMap<String,Integer>ans;
    HashMap<String,Integer>c;
    public UndergroundSystem(){
        hm=new HashMap<>();
        ans=new HashMap<>();
        c=new HashMap<>();
    }
    public void checkIn(int id,String stationName,int t){
        hm.put(id,Arrays.asList(stationName,String.valueOf(t)));
    }
    public void checkOut(int id,String stationName,int t){
        String a=hm.get(id).get(0);
        int t1=Integer.parseInt(hm.get(id).get(1));
        int time=t-t1;
        String key=a+","+stationName;
        ans.put(key,ans.getOrDefault(key,0)+time);
        c.put(key,c.getOrDefault(key,0)+1);
    }
    public double getAverageTime(String startStation,String endStation){
        String key=startStation+","+endStation;
        return(double)ans.get(key)/c.get(key);
    }
}
