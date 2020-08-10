package by.vlasova.service.generation.impl;

import by.vlasova.entity.User;
import by.vlasova.service.generation.Generator;
import by.vlasova.service.randomize.Randomizer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MultiThreadUserGenerator implements Generator {
    private final int BUNCH_SIZE = 100_000;
    private final Callable<User> task;
    private final ExecutorService executorService = Executors.newFixedThreadPool
            (Runtime.getRuntime().availableProcessors());

    public MultiThreadUserGenerator(Randomizer<User> randomizer) {
        task = randomizer::randomize;
    }

    @Override
    public void generate(int value) {
        while (value > 0) {
            if (value >= BUNCH_SIZE) doGen(BUNCH_SIZE);
            else doGen(value % BUNCH_SIZE);
            value -= BUNCH_SIZE;
        }
        executorService.shutdown();
    }

    private void doGen(int value) {
        Callable<User>[] tasks = new Callable[value];
        Arrays.fill(tasks, task);
        List<Future<User>> list;
        try {
            list = executorService.invokeAll(Arrays.asList(tasks));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.parallelStream().forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }
}