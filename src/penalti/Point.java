package penalti;

import java.util.Random;

public class Point {
    
    public enum point{
        UPLEFT,
        DOWNLEFT,
        UPRIGHT,
        DOWNRIGHT,
        UPMIDDLE,
        DOWNMIDDLE;
        
        private static Random random = new Random();
        
        public boolean miss(){
            return random.nextBoolean();
        }
    }
   
}
