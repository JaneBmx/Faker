package service;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private Faker faker;
    private int countOfFakes;

    public Generator(Faker faker, int countOfFakes) {
        this.faker = faker;
        this.countOfFakes = countOfFakes;
    }

    public List<String> generate(){
        //mb use multithreading?
        return new ArrayList<>();
    }
}
