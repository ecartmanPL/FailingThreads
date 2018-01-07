package net.siekiera.failingthreads;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class MainThreadRunner implements CommandLineRunner {
    private int numberOfThreads = 10;

    @Override
    public void run(String... strings) {
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(new SimpleThreadWichSometimesFails());
        }
        executorService.shutdown();
    }
}
