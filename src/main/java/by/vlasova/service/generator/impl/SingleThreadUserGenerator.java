package by.vlasova.service.generator.impl;

import by.vlasova.entity.User;
import by.vlasova.service.generator.Generator;
import by.vlasova.service.randomize.Randomizer;
import by.vlasova.service.randomize.impl.UserRandomizer;

public class SingleThreadUserGenerator implements Generator {
    private final Randomizer<User> randomizer;

    public SingleThreadUserGenerator(String locale, double errRate) {
        this.randomizer = new UserRandomizer(locale, errRate);
    }

    @Override
    public void generate(int value) {
        for (int i = 0; i < value; i++)
            System.out.println(randomizer.randomize());
    }
}