/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    long l;
    long r;
    long m;
    public int guessNumber(int n) {
        l=0;
        r=n;
        while(l<=r){
            m=(l+r)/2;
            if(guess((int)m)==0)
            return (int)m;
            else if(guess((int)m)==1){
                l=m+1;
            }
            else if(guess((int)m)==-1)
            r=m-1;
        }
        return 0;
    }
}