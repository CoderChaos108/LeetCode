class Solution {
    public double angleClock(int hour, int minutes) {
        double hourAngle=0;
        double minAngle=0;
        if(hour==12)
        hour=0;
        minAngle=6*minutes;
        hourAngle=30*((double)minutes/60)+hour*30;
        double angle=Math.abs(minAngle-hourAngle);
        if(angle>180)
        angle=360-angle;
        return angle;
    }
}