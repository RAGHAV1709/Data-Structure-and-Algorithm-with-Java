package clockpractice;

import java.time.*;
import java.time.ZoneId;

public class ClockPractice {

    public static void main(String[] args) {
        // TODO code application logic here
        
        ZoneId zoneId = ZoneId.of("Asia/Kolkata");
        Clock clock = Clock.system(zoneId);
        Instant instant = clock.instant();
        ZonedDateTime time = instant.atZone(clock.getZone());
        System.out.println("Instant for class is "+time.toString());
    }
    
}
