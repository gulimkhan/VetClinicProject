package model;

public class Cat extends Pet implements Playable {
    private String color;
    private boolean indoor;

    public Cat(String name, int age, String ownerName, String color, boolean indoor) {
        super(name, age, "Cat", ownerName);
        this.color = color;
        this.indoor = indoor;
    }

    @Override
    public void makeSound() { System.out.println(name + " meows: Meow Meow!"); }

    @Override
    public String getRole() { return "Cat"; }

    // Playable methods
    @Override
    public void play() { System.out.println(name + " is playing with a toy!"); }

    @Override
    public String favoriteToy() { return "Yarn"; }

    // Getters/Setters
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean isIndoor() { return indoor; }
    public void setIndoor(boolean indoor) { this.indoor = indoor; }
}