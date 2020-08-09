package by.vlasova.service.randomize.impl;

import by.vlasova.entity.User;
import by.vlasova.service.randomize.AbstractFakeRandomizer;
import by.vlasova.service.randomize.Randomizer;
import by.vlasova.util.AlphabetHolder;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class UserRandomizer extends AbstractFakeRandomizer implements Randomizer<User> {
    public UserRandomizer(String locale, double errRate) {
        super(locale, errRate);
        fakeService = new FakeValuesService(new Locale(locale), new RandomService());
        hasMiddleName = AlphabetHolder.hasMiddleName.get(locale.toLowerCase());
    }

    private final FakeValuesService fakeService;
    private final String[] gender = {"male", "female"};//no homo
    private final boolean hasMiddleName;

    @Override
    public User randomize() {
        String name;
        if (hasMiddleName) {
            int genderIndex = rnd.nextInt(gender.length);
            String middleName = fakeService.resolve(String.format("name.%s_middle_name", gender[genderIndex]), this, faker);
            String firstName = fakeService.resolve(String.format("name.%s_first_name", gender[genderIndex]), this, faker);
            String lastName = fakeService.resolve(String.format("name.%s_last_name", gender[genderIndex]), this, faker);
            name = String.join(" ", lastName, firstName, middleName);
        } else name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String address = faker.address().fullAddress().replaceAll("[#]+",faker.address().zipCode()+",");
        if (errorRate == 0) return new User(name, phone, address);
        double totalLength = name.length() + phone.length() + address.length();
        return new User(implementTypo(name, (errorRate * name.length()) / totalLength),
                implementTypo(phone, (errorRate * phone.length()) / totalLength),
                implementTypo(address, (errorRate * address.length()) / totalLength));
    }
}