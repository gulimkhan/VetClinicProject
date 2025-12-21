package com.gulimkhan.vetclinic;

public class Veterinarian {
    private int vetId;
    private String name;
    private String specialization;
    private int experience; // years

    public Veterinarian(int vetId, String name, String specialization, int experience) {
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public int getVetId() { return vetId; }
    public void setVetId(int vetId) { this.vetId = vetId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }

    // Additional methods
    public boolean canTreat() { return experience >= 3; }
    public boolean isExperienced() { return experience > 5; }

    @Override
    public String toString() {
        return "Veterinarian{id=" + vetId + ", name='" + name + "', specialization='" +
                specialization + "', experience=" + experience + " years}";
    }
}

