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
            if(a[0]>=startTime&&a[0]<=endTime-1)
            return false;
            if(a[1]>=startTime&&a[1]<=endTime-1)
            return false;
            if(startTime>=a[0]&&startTime<=a[1])
            return false;
            if(endTime-1>=a[0]&&endTime-1<=a[1])
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