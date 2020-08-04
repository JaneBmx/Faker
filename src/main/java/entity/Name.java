package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@EqualsAndHashCode
public class Name implements Mistakable, Serializable {
    private String firstName;
    private String middleName;
    private String lastName;

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName;
    }

    @Override
    public void makeMistake() {

    }
}