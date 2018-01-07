package net.siekiera.failingthreads;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SimpleThreadWichSometimesFails implements Runnable {
    private static final Logger logger = LoggerFactory.getLogger(SimpleThreadWichSometimesFails.class);
    private String threadName;
    private boolean isHealthy;

    public SimpleThreadWichSometimesFails() {
        Random rnd = new Random();
        isHealthy = (rnd.nextInt(10) != 0);
    }

    public void run() {
        threadName = Thread.currentThread().getName();
        logger.info("Started: " + threadName);
        if (!isHealthy) {
            throw new RuntimeException();
        }
        logger.info("Finished: " + threadName);
    }
}
