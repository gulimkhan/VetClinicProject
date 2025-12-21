package com.gulimkhan.vetclinic;

public class Owner {
    private int ownerId;
    private String name;
    private String phone;
    private int numberOfPets;

    public Owner(int ownerId, String name, String phone, int numberOfPets) {
        this.ownerId = ownerId;
        this.name = name;
        this.phone = phone;
        this.numberOfPets = numberOfPets;
    }

    public int getOwnerId() { return ownerId; }
    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public int getNumberOfPets() { return numberOfPets; }
    public void setNumberOfPets(int numberOfPets) { this.numberOfPets = numberOfPets; }

    // Additional methods
    public void addPet() { this.numberOfPets++; }
    public boolean isFrequentClient() { return numberOfPets > 3; }

    @Override
    public String toString() {
        return "Owner{id=" + ownerId + ", name='" + name + "', phone='" + phone +
                "', pets=" + numberOfPets + "}";
    }
}
