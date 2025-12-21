package com.gulimkhan.vetclinic;

public class Pet {
    private int petId;
    private String name;
    private String species;
    private int age;
    private String ownerName;

    public Pet(int petId, String name, String species, int age, String ownerName) {
        this.petId = petId;
        this.name = name;
        this.species = species;
        this.age = age;
        this.ownerName = ownerName;
    }

    // Getters and Setters
    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getOwnerName() { return ownerName; }
    public void setOwnerName(String ownerName) { this.ownerName = ownerName; }

    // Additional methods
    public String getLifeStage() {
        if (age < 2) return "Young";
        else if (age <= 7) return "Adult";
        else return "Senior";
    }

    @Override
    public String toString() {
        return "Pet{id=" + petId + ", name='" + name + "', species='" + species +
                "', age=" + age + ", owner='" + ownerName + "', lifeStage='" + getLifeStage() + "'}";
    }
}
