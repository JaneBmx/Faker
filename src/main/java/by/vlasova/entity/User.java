package by.vlasova.entity;

public class User {
    private final String name;
    private final String phone;
    private final String address;

    public User(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.join(";", name, address, phone);
    }
}