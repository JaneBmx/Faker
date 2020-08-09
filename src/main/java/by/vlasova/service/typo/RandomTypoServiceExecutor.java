package by.vlasova.service.typo;

import by.vlasova.service.typo.impl.DeleteChar;
import by.vlasova.service.typo.impl.InsertChar;
import by.vlasova.service.typo.impl.Swap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomTypoServiceExecutor {
    private static final List<TypoGenerator> typoGeneratorList;
    private static final Random rnd = new Random();

    static {
        typoGeneratorList = new ArrayList<>();
        typoGeneratorList.add(new DeleteChar(rnd));
        typoGeneratorList.add(new Swap(rnd));
        typoGeneratorList.add(new InsertChar(rnd));
    }

    public static String generateTypo(String to, String locale) {
        return typoGeneratorList.get(rnd.nextInt(typoGeneratorList.size())).generateTypo(to, locale);
    }

    private RandomTypoServiceExecutor() {
    }
}