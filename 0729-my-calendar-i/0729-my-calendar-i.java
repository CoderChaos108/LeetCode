class MyCalendar {
    ArrayList<int[]> list;
    public MyCalendar() {
     list=new ArrayList<>();   
    }
    public boolean book(int startTime, int endTime) {
        if(list.size()==0){
            int a[]={startTime,endTime-1};
            list.add(a);
            return true;
        }
        for(int[] a:list){
            if(startTime<=a[1]&&a[0]<endTime)
            return false;      
        }
       
        int[] a={startTime,endTime-1};
        list.add(a);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */