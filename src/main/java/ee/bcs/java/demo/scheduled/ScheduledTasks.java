package ee.bcs.java.demo.scheduled;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

// @Component
public class ScheduledTasks {
    // @Scheduled(fixedRate = 1000) // time in milliseconds
    public void test() {
        System.out.println("test");
    }
}
