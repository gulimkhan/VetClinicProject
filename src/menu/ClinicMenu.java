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
        System.out.println("4. Show Dogs Only");
        System.out.println("5. Show Cats Only");
        System.out.println("6. Update Pet");
        System.out.println("7. Delete Pet");
        System.out.println("8. Search by Name");
        System.out.println("9. Search by Age Range");
        System.out.println("10. Search by Min Age");
        System.out.println("11. Polymorphism Demo");
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
                case 4 -> showDogsOnly();
                case 5 -> showCatsOnly();
                case 6 -> updatePet();
                case 7 -> deletePet();
                case 8 -> searchByName();
                case 9 -> searchByAgeRange();
                case 10 -> searchByMinAge();
                case 11 -> polymorphismDemo();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice!");
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
        System.out.print("Trained (true/false): ");
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
        System.out.print("Indoor (true/false): ");
        boolean indoor = Boolean.parseBoolean(scanner.nextLine());

        petDAO.insertPet(new Cat(name, age, owner, color, indoor));
    }

    private void showAll() {
        petDAO.getAllPets().forEach(System.out::println);
    }

    private void showDogsOnly() {
        petDAO.getAllPets().stream()
                .filter(p -> p instanceof Dog)
                .forEach(System.out::println);
    }

    private void showCatsOnly() {
        petDAO.getAllPets().stream()
                .filter(p -> p instanceof Cat)
                .forEach(System.out::println);
    }

    private void updatePet() {
        System.out.print("Pet ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("New Name: ");
        String name = scanner.nextLine();
        System.out.print("New Age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("New Owner: ");
        String owner = scanner.nextLine();

        if (petDAO.updatePet(id, name, age, owner)) {
            System.out.println("Updated successfully ✅");
        } else {
            System.out.println("Update failed ❌");
        }
    }

    private void deletePet() {
        System.out.print("Pet ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Are you sure? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            if (petDAO.deletePet(id)) {
                System.out.println("Deleted successfully ✅");
            } else {
                System.out.println("Delete failed ❌");
            }
        }
    }

    private void searchByName() {
        System.out.print("Search Name: ");
        String name = scanner.nextLine();
        petDAO.searchByName(name).forEach(System.out::println);
    }

    private void searchByAgeRange() {
        System.out.print("Min Age: ");
        int min = Integer.parseInt(scanner.nextLine());
        System.out.print("Max Age: ");
        int max = Integer.parseInt(scanner.nextLine());
        petDAO.searchByAgeRange(min, max).forEach(System.out::println);
    }

    private void searchByMinAge() {
        System.out.print("Min Age: ");
        int min = Integer.parseInt(scanner.nextLine());
        petDAO.searchByMinAge(min).forEach(System.out::println);
    }

    private void polymorphismDemo() {
        petDAO.getAllPets().forEach(p -> {
            p.makeSound();
            if (p instanceof Playable playable) playable.play();
        });
    }
}
