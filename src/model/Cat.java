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
    public void makeSound() {
        System.out.println(name + " says: Meow Meow!");
    }

    @Override
    public String getRole() { return "Cat"; }

    @Override
    public void play() {
        System.out.println(name + " plays with yarn!");
    }

    @Override
    public String favoriteToy() { return "Yarn"; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public boolean isIndoor() { return indoor; }
    public void setIndoor(boolean indoor) { this.indoor = indoor; }
}