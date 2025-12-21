package com.gulimkhan.vetclinic;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Veterinary Clinic Management System ===\n");

        // Create Pet objects
        Pet pet1 = new Pet(101, "Bella", "Dog", 3, "Alice");
        Pet pet2 = new Pet(102, "Milo", "Cat", 1, "Bob");
        Pet pet3 = new Pet(103, "Charlie", "Parrot", 8, "Adam");

        // Create Owner objects
        Owner owner1 = new Owner(201, "Alice", "+77011234567", 2);
        Owner owner2 = new Owner(202, "Bob", "+77012345678", 1);

        // Create Veterinarian objects
        Veterinarian vet1 = new Veterinarian(301, "Dr. Smith", "Surgery", 6);
        Veterinarian vet2 = new Veterinarian(302, "Dr. Johnson", "Dentistry", 2);

        // Test additional methods
        owner1.addPet();
        System.out.println("Owner1 is frequent client? " + owner1.isFrequentClient());
        System.out.println("Pet2 life stage: " + pet2.getLifeStage());
        System.out.println("Vet1 can treat? " + vet1.canTreat());

        // Display all objects
        System.out.println("\n--- PETS ---");
        System.out.println(pet1);
        System.out.println(pet2);
        System.out.println(pet3);

        System.out.println("\n--- OWNERS ---");
        System.out.println(owner1);
        System.out.println(owner2);

        System.out.println("\n--- VETERINARIANS ---");
        System.out.println(vet1);
        System.out.println(vet2);

        System.out.println("\n=== Program Complete ===");
    }
}
