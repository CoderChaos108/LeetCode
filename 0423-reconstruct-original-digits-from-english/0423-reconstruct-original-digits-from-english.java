class Solution {
    public String originalDigits(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(!hm.containsKey(s.charAt(i))){
                hm.put(s.charAt(i),1);
            }
            else
            hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
        }
        int[] a=new int[10];
       a[0]=hm.getOrDefault('z',0);
       a[2]=hm.getOrDefault('w',0);
       a[4]=hm.getOrDefault('u',0);
       a[6]=hm.getOrDefault('x',0);
       a[8]=hm.getOrDefault('g',0);
       a[1]=hm.getOrDefault('o',a[0]+a[2]+a[4])-a[0]-a[2]-a[4];
       a[3]=hm.getOrDefault('t',a[2]+a[8])-a[2]-a[8];
       a[5]=hm.getOrDefault('f',a[4])-a[4];
       a[7]=hm.getOrDefault('s',a[6])-a[6];
       a[9]=hm.getOrDefault('i',a[5]+a[6]+a[8])-a[5]-a[6]-a[8];
       StringBuilder sb=new StringBuilder();
       for(int i=0;i<10;i++){
        for(int j=0;j<a[i];j++)
        sb.append(String.valueOf(i));
       }
       return sb.toString();
    }
}