class MyCalendar {
    ArrayList<int[]> list;
    public MyCalendar() {
     list=new ArrayList<>();   
    }
    public boolean book(int startTime, int endTime) {
        endTime=endTime-1;
        if(list.size()==0){
            int a[]={startTime,endTime};
            list.add(a);
            return true;
        }
        for(int[] a:list){
            if(a[0]>=startTime&&a[0]<=endTime)
            return false;
            if(a[1]>=startTime&&a[1]<=endTime)
            return false;
            if(startTime>=a[0]&&startTime<=a[1])
            return false;
            if(endTime>=a[0]&&endTime<=a[1])
            return false;          
        }
       
        int[] a={startTime,endTime};
        list.add(a);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */