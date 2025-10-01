class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty=0;
        int drunk=0;
        while(numBottles!=0){
            drunk=drunk+numBottles;
            empty=empty+numBottles;
            int exc=empty/numExchange;
            empty=empty-numExchange*exc;
            numBottles=exc;
        }
        return drunk;
    }
}