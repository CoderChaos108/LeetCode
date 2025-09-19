class Spreadsheet {
    int[][] a;
    public Spreadsheet(int rows) {
        a=new int[rows][26];
    }
    
    public void setCell(String cell,int value) {
        char col=cell.charAt(0);
        int row=Integer.parseInt(cell.substring(1))-1;
        a[row][col-'A']=value;
    }
    
    public void resetCell(String cell) {
        char col=cell.charAt(0);
        int row=Integer.parseInt(cell.substring(1))-1;
        a[row][col-'A']=0;
    }
    
    public int getValue(String formula) {
        formula=formula.substring(1);
        String[] parts=formula.split("\\+");
        int sum=0;
        for(String part:parts){
            part=part.trim();
            if(Character.isLetter(part.charAt(0))){
                char col=part.charAt(0);
                int row=Integer.parseInt(part.substring(1))-1;
                sum=sum+a[row][col-'A'];
            }else{
                sum=sum+Integer.parseInt(part);
            }
        }
        return sum;
    }
}
