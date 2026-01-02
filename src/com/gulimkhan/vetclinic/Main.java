package com.gulimkhan;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Pet> pets = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Test data
        pets.add(new Cat("Barsik", 3, "Cat", "Aida", true));
        pets.add(new Dog("Sharik", 5, "Dog", "Asel", false));

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: addPet(); break;
                case 2: viewAllPets(); break;
                case 3: demonstratePolymorphism(); break;
                case 4: viewByType(); break;
                case 0: running = false; System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n===============================");
        System.out.println("       VET CLINIC SYSTEM       ");
        System.out.println("===============================");
        System.out.println("1. Add Pet (Cat/Dog)");
        System.out.println("2. View All Pets");
        System.out.println("3. Demonstrate Polymorphism");
        System.out.println("4. View by Type");
        System.out.println("0. Exit");
        System.out.println("===============================");
        System.out.print("Enter your choice: ");
    }

    private static void addPet() {
        System.out.print("Enter type (Cat/Dog): ");
        String type = scanner.nextLine();
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter owner name: ");
        String owner = scanner.nextLine();

        if (type.equalsIgnoreCase("Cat")) {
            System.out.print("Is indoor? (true/false): ");
            boolean indoor = scanner.nextBoolean();
            scanner.nextLine();
            pets.add(new Cat(name, age, "Cat", owner, indoor));
        } else if (type.equalsIgnoreCase("Dog")) {
            System.out.print("Is trained? (true/false): ");
            boolean trained = scanner.nextBoolean();
            scanner.nextLine();
            pets.add(new Dog(name, age, "Dog", owner, trained));
        } else {
            System.out.println("Unknown type! Pet not added.");
        }
        System.out.println("Pet added successfully!");
    }

    private static void viewAllPets() {
        System.out.println("\n--- ALL PETS ---");
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
            return;
        }
        for (Pet pet : pets) {
            System.out.println(pet);
        }
    }

    private static void demonstratePolymorphism() {
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        for (Pet pet : pets) {
            pet.makeSound(); // Different behavior for Cat/Dog
        }
    }

    private static void viewByType() {
        System.out.print("Enter type to view (Cat/Dog): ");
        String type = scanner.nextLine();
        for (Pet pet : pets) {
            if (type.equalsIgnoreCase("Cat") && pet instanceof Cat) System.out.println(pet);
            else if (type.equalsIgnoreCase("Dog") && pet instanceof Dog) System.out.println(pet);
        }
    }
}