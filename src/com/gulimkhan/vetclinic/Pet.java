package com.gulimkhan;

public class Pet {
    protected String name;
    protected int age;
    protected String type;
    protected String ownerName;

    public Pet(String name, int age, String type, String ownerName) {
        setName(name);
        setAge(age);
        setType(type);
        setOwnerName(ownerName);
    }

    // Validation in setters
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) this.name = name;
        else this.name = "Unknown";
    }

    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else this.age = 0;
    }

    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) this.type = type;
        else this.type = "Unknown";
    }

    public void setOwnerName(String ownerName) {
        if (ownerName != null && !ownerName.trim().isEmpty()) this.ownerName = ownerName;
        else this.ownerName = "Unknown";
    }

    public String getRole() {
        return "Pet";
    }

    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public boolean isAdult() {
        return age >= 1;
    }

    @Override
    public String toString() {
        return "[" + getRole() + "] " + name +
                " | Type: " + type +
                " | Age: " + age +
                " | Owner: " + ownerName;
    }
}