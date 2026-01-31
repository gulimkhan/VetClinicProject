package menu;

import database.PetDAO;
import model.*;

import java.util.Scanner;

public class ClinicMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private PetDAO petDAO = new PetDAO();

    @Override
    public void displayMenu() {
        System.out.println("\n--- VETERINARY CLINIC ---");
        System.out.println("1. Add Dog");
        System.out.println("2. Add Cat");
        System.out.println("3. Show All Pets");
        System.out.println("4. Update Pet");
        System.out.println("5. Delete Pet");
        System.out.println("6. Search Pet by Name");
        System.out.println("0. Exit");
    }

    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addDog();
                case 2 -> addCat();
                case 3 -> showAll();
                case 4 -> updatePet();
                case 5 -> deletePet();
                case 6 -> searchPet();
                case 0 -> running = false;
            }
        }
    }

    private void addDog() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Owner: ");
        String owner = scanner.nextLine();
        System.out.print("Breed: ");
        String breed = scanner.nextLine();
        System.out.print("Trained: ");
        boolean trained = Boolean.parseBoolean(scanner.nextLine());

        petDAO.insertPet(new Dog(name, age, owner, breed, trained));
    }

    private void addCat() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Owner: ");
        String owner = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Indoor: ");
        boolean indoor = Boolean.parseBoolean(scanner.nextLine());

        petDAO.insertPet(new Cat(name, age, owner, color, indoor));
    }

    private void showAll() {
        for (Pet p : petDAO.getAllPets()) {
            System.out.println(p);
        }
    }

    private void updatePet() {
        System.out.print("Pet ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("New Owner: ");
        String owner = scanner.nextLine();

        if (petDAO.updatePet(id, name, age, owner))
            System.out.println("Updated successfully ");
        else
            System.out.println("Update failed ");
    }

    private void deletePet() {
        System.out.print("Pet ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Are you sure? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            petDAO.deletePet(id);
        }
    }

    private void searchPet() {
        System.out.print("Search name: ");
        String name = scanner.nextLine();
        for (Pet p : petDAO.searchByName(name)) {
            System.out.println(p);
        }
    }
}