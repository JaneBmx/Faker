package service;

import com.github.javafaker.Faker;
import entity.Note;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    private Faker faker;
    private int countOfFakes;

    public Generator(Faker faker, int countOfFakes) {
        this.faker = faker;
        this.countOfFakes = countOfFakes;
    }

    public List<Note> generate(){
        List<Note> list = new ArrayList<>();



        //mb use multithreading?
        return new ArrayList<>();
    }
}
