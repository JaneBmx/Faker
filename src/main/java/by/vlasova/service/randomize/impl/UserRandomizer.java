package by.vlasova.service.randomize.impl;

import by.vlasova.entity.User;
import by.vlasova.service.randomize.AbstractFakeRandomizer;
import by.vlasova.service.randomize.Randomizer;
import by.vlasova.util.AlphabetHolder;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class UserRandomizer extends AbstractFakeRandomizer implements Randomizer<User> {
    private final FakeValuesService fakeService;
    private final String[] genders = {"male", "female"};//no homo
    private final boolean hasMiddleName;

    public UserRandomizer(String locale, double errRate) {
        super(locale, errRate);
        fakeService = new FakeValuesService(new Locale(locale), new RandomService());
        hasMiddleName = AlphabetHolder.hasMiddleName.get(locale.toLowerCase());
    }

    @Override
    public User randomize() {
        String name;
        if (hasMiddleName) {
            String gender = genders[rnd.nextInt(genders.length)];
            String middleName = fakeService.resolve(String.format("name.%s_middle_name", gender), this, faker);
            String firstName = fakeService.resolve(String.format("name.%s_first_name", gender), this, faker);
            String lastName = fakeService.resolve(String.format("name.%s_last_name", gender), this, faker);
            name = String.join(" ", lastName, firstName, middleName);
        } else name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String address = faker.address().fullAddress().replaceAll("[#]+",faker.address().zipCode()+",");
        if (errRate == 0) return new User(name, phone, address);
        double totalLength = name.length() + phone.length() + address.length();
        return new User(implementTypo(name, (errRate * name.length()) / totalLength),
                implementTypo(phone, (errRate * phone.length()) / totalLength),
                implementTypo(address, (errRate * address.length()) / totalLength));
    }
}