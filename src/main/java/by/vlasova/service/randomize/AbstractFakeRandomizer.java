package by.vlasova.service.randomize;

import by.vlasova.service.typo.RandomTypoServiceExecutor;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public abstract class AbstractFakeRandomizer {
    protected final Faker faker;
    protected final Random rnd = new Random();
    protected final String locale;
    protected final double errorRate;

    protected AbstractFakeRandomizer(String locale, double errorRate) {
        this.locale = locale;
        this.errorRate = errorRate;
        faker = new Faker(new Locale(locale));
    }

    protected String implementTypo(String to, double errorRate) {
        if (rnd.nextDouble() <= errorRate % 1)
            to = RandomTypoServiceExecutor.generateTypo(to, locale);
        for (int i = 0; i < (int) errorRate; i++)
            to = RandomTypoServiceExecutor.generateTypo(to, locale);
        return to;
    }
}