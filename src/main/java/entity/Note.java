package entity;

//Иванов Сидор Пертрович;
// 630007, Россия, г. Новосибирск, ул. Победы коммунизма, д.4к1, кв. 23;
// 8 (800) 700-43-43

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public @Data class Note {
    private String name;
    private Address address;
    private String phone;

    public Note(String name, int index, String country, String homeAddress, String phone) {
        this.name = name;
        this.address = new Address(index, country, homeAddress);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return name + "; " + address+"; "+ phone;
    }

    @Getter @Setter
    private static @Data class Address {
        private int index;
        private String country;
        private String homeAddress;

        public Address(int index, String country, String homeAddress) {
            this.index = index;
            this.country = country;
            this.homeAddress = homeAddress;
        }

        @Override
        public String toString() {
            return index + ", " + country + ", " + homeAddress;
        }
    }
}