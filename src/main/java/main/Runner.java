package main;

import com.github.javafaker.Faker;
import entity.Note;
import service.Generator;
import service.Mistaker;
import util.validator.ArgumentsValidator;

import java.util.List;
import java.util.Locale;

/**
 * Args:
 * 1. Locale name:{ru_RU, en_EN, by_BY}
 * 2. Count of records:{1, 2, 3, ...}
 * 3. Percent of mistakes:{0<....}
 */
public class Runner {
    public static void main(String[] args) {
        if (new ArgumentsValidator().isValid(args)) {
            Locale locale = new Locale(args[0]);
            Faker faker = new Faker(locale);

            List<Note> stringList = new Generator(faker, Integer.parseInt(args[1])).generate();
            new Mistaker().makeMistakes(stringList,
                    args.length == 3 ? Double.parseDouble(args[2]) : 0
            );

            for (Note s : stringList) System.out.println(s);
        }
        System.out.println("Invalid arguments");
    }
}