class Solution {
    public String getHint(String secret, String guess) {
        int sec[]=new int[10];
        int gue[]=new int[10];
        int bull=0;
        int cow=0;
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)){
                bull++;
                continue;
            }
          sec[secret.charAt(i)-'0']++;  
          gue[guess.charAt(i)-'0']++;
        }
        for(int i=0;i<10;i++){
            while(sec[i]>0&&gue[i]>0){
            cow++;
            sec[i]--;
            gue[i]--;
            }
        }
        return (bull+"A"+cow+"B");
    }
}