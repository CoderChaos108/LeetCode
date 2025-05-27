/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        boolean add=false;;
        int x=7;
        while( x==7){
            x=rand7();
        }
        if(x%2==0)
            add=true;
            x=0;
        while(x==-1||x==0)
        x=rand7()-2;
        if(add)
        x=x+5;
        return x;
    }
}