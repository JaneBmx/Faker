package by.vlasova;

import by.vlasova.service.generation.Generator;
import by.vlasova.service.generation.impl.MultiThreadUserGenerator;
import by.vlasova.service.randomize.impl.UserRandomizer;
import by.vlasova.util.validation.ArgumentValidator;

/**
 * Args:
 * 1. Locale name:{ru_RU, en_EN, by_BY}
 * 2. Count of records:{1, 2, 3, ...}
 * 3. Percent of mistakes:{0<....}
 */
public class Runner {
    public static void main(String[] args) {
        if (!ArgumentValidator.argsValidator(args)) return;
        String locale = args[0];
        int value = Integer.parseInt(args[1]);
        double errRate = args.length == 3 ? Double.parseDouble(args[2]) : 0;
        Generator multiThreadUserGenerator = new MultiThreadUserGenerator(new UserRandomizer(locale, errRate));
        multiThreadUserGenerator.generate(value);
    }
}