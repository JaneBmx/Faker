package entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class Phone implements Mistakable, Serializable {
    private int countryCode;
    private int providerCode;
    private int number;

    @Override
    public String toString() {
        return "+" + countryCode + " (" + providerCode + ") " + number;
    }

    @Override
    public void makeMistake() {

    }
}
// Иван Iван
//Владислав Уладзiсла(у+й)