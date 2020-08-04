package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class Address implements Mistakable, Serializable {
    private int index;
    private String country;
    private String city;
    private String street;
    private int home;
    private int apartment;

    @Override
    public String toString() {
        return index + ", " +
                country + ", " +
                city + " " +
                street + ", " +
                home + ", " +
                apartment;
    }

    @Override
    public void makeMistake() {

    }
}
