package com.gulimkhan;

public class Cat extends Pet {
    private boolean isIndoor;

    public Cat(String name, int age, String type, String ownerName, boolean isIndoor) {
        super(name, age, type, ownerName); // super must be first
        this.isIndoor = isIndoor;
    }

    public boolean isIndoor() {
        return isIndoor;
    }

    public void setIndoor(boolean indoor) {
        this.isIndoor = indoor;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow!");
    }

    @Override
    public String getRole() {
        return "Cat";
    }

    public void scratch() {
        System.out.println(name + " is scratching.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Indoor: " + isIndoor;
    }
}