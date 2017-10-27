package com.nikita;

public class Person implements Comparable {

    private String name;
    private String phone;

    Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    Person() {
        this(null, null);
    }

    String getName() {
        return name;
    }

    String getPhone() {
        return phone;
    }

    public int compareTo(Object another) {
        return name.compareTo(((Person) another).name);
    }

    @Override
    public String toString() {
        return ("\nФамилия: " + name + "\nТелефоны: " + phone + "\n");
    }
}
