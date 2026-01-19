package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ClinicMenu implements Menu {
    private ArrayList<Pet> pets = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public ClinicMenu() {
        // Sample pets
        pets.add(new Dog("Sharik", 5, "Asel", "Golden Retriever", true));
        pets.add(new Cat("Barsik", 3, "Aida", "White", false));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- VETERINARY CLINIC ---");
        System.out.println("1. Add Dog");
        System.out.println("2. Add Cat");
        System.out.println("3. Show All Pets");
        System.out.println("4. Make All Pets Sound");
        System.out.println("5. Play with All Pets");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while(running) {
            displayMenu();
            System.out.print("Choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1: addDog(); break;
                    case 2: addCat(); break;
                    case 3: showAllPets(); break;
                    case 4: makeAllSound(); break;
                    case 5: playWithAll(); break;
                    case 0: running = false; break;
                    default: System.out.println("Invalid choice!");
                }
            } catch(Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }

    private void addDog() {
        try {
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Owner: "); String owner = scanner.nextLine();
            System.out.print("Breed: "); String breed = scanner.nextLine();
            System.out.print("Trained (true/false): "); boolean trained = Boolean.parseBoolean(scanner.nextLine());
            pets.add(new Dog(name, age, owner, breed, trained));
            System.out.println("Dog added!");
        } catch(Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    private void addCat() {
        try {
            System.out.print("Name: "); String name = scanner.nextLine();
            System.out.print("Age: "); int age = Integer.parseInt(scanner.nextLine());
            System.out.print("Owner: "); String owner = scanner.nextLine();
            System.out.print("Color: "); String color = scanner.nextLine();
            System.out.print("Indoor (true/false): "); boolean indoor = Boolean.parseBoolean(scanner.nextLine());
            pets.add(new Cat(name, age, owner, color, indoor));
            System.out.println("Cat added!");
        } catch(Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    private void showAllPets() {
        System.out.println("\n--- ALL PETS ---");
        for(Pet p : pets) System.out.println(p);
    }

    private void makeAllSound() {
        System.out.println("\n--- PETS SOUNDS ---");
        for(Pet p : pets) p.makeSound();
    }

    private void playWithAll() {
        System.out.println("\n--- PLAYING WITH PETS ---");
        for(Pet p : pets) {
            if(p instanceof Playable) ((Playable)p).play();
        }
    }
}