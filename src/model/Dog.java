package model;

public class Dog extends Pet implements Playable {
    private String breed;
    private boolean trained;

    public Dog(String name, int age, String ownerName, String breed, boolean trained) {
        super(name, age, "Dog", ownerName);
        this.breed = breed;
        this.trained = trained;
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof Woof!");
    }

    @Override
    public String getRole() { return "Dog"; }

    @Override
    public void play() {
        System.out.println(name + " plays fetch!");
    }

    @Override
    public String favoriteToy() { return "Ball"; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public boolean isTrained() { return trained; }
    public void setTrained(boolean trained) { this.trained = trained; }
}