package com.gulimkhan;

public class Dog extends Pet {
    private boolean isTrained;

    public Dog(String name, int age, String type, String ownerName, boolean isTrained) {
        super(name, age, type, ownerName);
        this.isTrained = isTrained;
    }

    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        this.isTrained = trained;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof!");
    }

    @Override
    public String getRole() {
        return "Dog";
    }

    public void fetch() {
        System.out.println(name + " is fetching the ball.");
    }

    @Override
    public String toString() {
        return super.toString() + " | Trained: " + isTrained;
    }
}