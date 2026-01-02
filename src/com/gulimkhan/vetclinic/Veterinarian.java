package com.gulimkhan;

public class Veterinarian {
    private String name;
    private String specialty;

    public Veterinarian(String name, String specialty) {
        setName(name);
        setSpecialty(specialty);
    }

    // Getters
    public String getName() { return name; }
    public String getSpecialty() { return specialty; }

    // Setters with validation
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Vet name cannot be empty! Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setSpecialty(String specialty) {
        if(specialty != null && !specialty.trim().isEmpty()) {
            this.specialty = specialty;
        } else {
            System.out.println("Warning: Specialty cannot be empty! Setting to 'General'.");
            this.specialty = "General";
        }
    }

    @Override
    public String toString() {
        return name + " (Specialty: " + specialty + ")";
    }
}