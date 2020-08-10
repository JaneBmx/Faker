package by.vlasova.service.randomize;

import by.vlasova.service.typo.RandomTypoServiceExecutor;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public abstract class AbstractFakeRandomizer {
    protected final Faker faker;
    protected final Random rnd = new Random();
    protected final String locale;
    protected final double errRate;

    protected AbstractFakeRandomizer(String locale, double errRate) {
        this.locale = locale;
        this.errRate = errRate;
        faker = new Faker(new Locale(locale));
    }

    protected String implementTypo(String to, double errRate) {
        if (rnd.nextDouble() <= errRate % 1) to = RandomTypoServiceExecutor.generateTypo(to, locale);
        for (int i = 0; i < (int) errRate; i++) to = RandomTypoServiceExecutor.generateTypo(to, locale);
        return to;
    }
}