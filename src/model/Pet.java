package model;

public abstract class Pet {
    protected String name;
    protected int age;
    protected String species;
    protected String ownerName;

    public Pet(String name, int age, String species, String ownerName) {
        setName(name);
        setAge(age);
        this.species = species;
        this.ownerName = ownerName;
    }

    // Abstract method: all children must implement
    public abstract void makeSound();
    public abstract String getRole();

    public String getName() { return name; }
    public void setName(String name) {
        if(name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public int getAge() { return age; }
    public void setAge(int age) {
        if(age < 0)
            throw new IllegalArgumentException("Age cannot be negative");
        this.age = age;
    }

    @Override
    public String toString() {
        return species + " " + name + ", Age: " + age + ", Owner: " + ownerName;
    }
}