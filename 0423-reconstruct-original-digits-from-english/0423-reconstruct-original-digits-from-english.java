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
        int[] d=new int[10];
        while(hm.containsKey('z')&&hm.get('z')!=0){
            d[0]++;
            hm.put('z',hm.get('z')-1);
            hm.put('e',hm.get('e')-1);
            hm.put('r',hm.get('r')-1);
            hm.put('o',hm.get('o')-1);
        }
        while(hm.containsKey('w')&&hm.get('w')!=0){
            d[2]++;
            hm.put('t',hm.get('t')-1);
            hm.put('w',hm.get('w')-1);
            hm.put('o',hm.get('o')-1);
        }
        while(hm.containsKey('u')&&hm.get('u')!=0){
            d[4]++;
            hm.put('f',hm.get('f')-1);
            hm.put('o',hm.get('o')-1);
            hm.put('u',hm.get('u')-1);
            hm.put('r',hm.get('r')-1);
        }
        while(hm.containsKey('x')&&hm.get('x')!=0){
            d[6]++;
            hm.put('s',hm.get('s')-1);
            hm.put('i',hm.get('i')-1);
            hm.put('x',hm.get('x')-1);
        }
        while(hm.containsKey('g')&&hm.get('g')!=0){
            d[8]++;
            hm.put('e',hm.get('e')-1);
            hm.put('i',hm.get('i')-1);
            hm.put('g',hm.get('g')-1);
            hm.put('h',hm.get('h')-1);
            hm.put('t',hm.get('t')-1);
        }
        while(hm.containsKey('o')&&hm.get('o')!=0){
            d[1]++;
            hm.put('o',hm.get('o')-1);
            hm.put('n',hm.get('n')-1);
            hm.put('e',hm.get('e')-1);
        }       
        while(hm.containsKey('t')&&hm.get('t')!=0){
            d[3]++;
            hm.put('t',hm.get('t')-1);
            hm.put('h',hm.get('h')-1);
            hm.put('r',hm.get('r')-1);
            hm.put('e',hm.get('e')-1);
            hm.put('e',hm.get('e')-1);
        }       
        while(hm.containsKey('f')&&hm.get('f')!=0){
            d[5]++;
            hm.put('f',hm.get('f')-1);
            hm.put('i',hm.get('i')-1);
            hm.put('v',hm.get('v')-1);
            hm.put('e',hm.get('e')-1);
        }
        while(hm.containsKey('s')&&hm.get('s')!=0){
            d[7]++;
            hm.put('s',hm.get('s')-1);
            hm.put('e',hm.get('e')-1);
            hm.put('v',hm.get('v')-1);
            hm.put('e',hm.get('e')-1);
            hm.put('n',hm.get('n')-1);
        }       
        while(hm.containsKey('n')&&hm.get('n')!=0){
            d[9]++;
        hm.put('n',hm.get('n')-2);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10;i++){
            for(int j=0;j<d[i];j++)
            sb.append(String.valueOf(i));
        }
        return sb.toString();

        
    }
}