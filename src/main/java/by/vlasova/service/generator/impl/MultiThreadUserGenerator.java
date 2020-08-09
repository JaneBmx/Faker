package by.vlasova.service.generator.impl;

import by.vlasova.entity.User;
import by.vlasova.service.generator.Generator;
import by.vlasova.service.randomize.Randomizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class MultiThreadUserGenerator implements Generator {
    private final Randomizer<User> randomizer;

    public MultiThreadUserGenerator(Randomizer<User> randomizer) {
        this.randomizer = randomizer;
    }

    @Override
    public void generate(int value) {
        List<CompletableFuture<User>> list = new ArrayList<>(value);
        for (int i = 0; i < value; i++) {
            list.add(CompletableFuture.supplyAsync(randomizer::randomize));
        }
        list.parallelStream().forEach(e -> System.out.println(e.join()));
    }
}