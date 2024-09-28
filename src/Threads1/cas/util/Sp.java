package Threads1.cas.util;

import static Threads1.cas.util.logger.log;

public abstract class Sp {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, "+e.getMessage());
        }
    }
}
