class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty=numBottles;
        int drunk=numBottles;
        while(true){
            empty=empty-numExchange;
            if(empty<0)
            return drunk;
            drunk++;
            empty++;
            numExchange++;
        }
    }
}