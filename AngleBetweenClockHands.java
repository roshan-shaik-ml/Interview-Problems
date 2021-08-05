public class AngleBetweenClockHands {
    
    public static void main(String[] args) {
        
        int hour = 12;
        int minutes = 30;
        int angle = getAngle(hour, minutes);
        System.out.println(angle);
    }

    public static int getAngle(int hour, int minutes) {

        int angle;
        if(hour == 12)
            hour = 0;
        if(minutes == 60)
            minutes = 0;
        // minute hand moves at 6 deg per min
        double minute_hand = minutes * 6; 
        // first term relative position from 12 'o' clock (30 deg per hour)
        // second term movement of hour hand (0.5 deg per min) minutes past hour
        double hour_hand = (hour * 30) + (minutes * 0.5); 
        angle = (int) (minute_hand - hour_hand);
        
        if(angle < 0)
            angle = 360 + angle;
        return angle;

    }
}   
