import database.PetDAO;
import model.Dog;

public class TestInsert {
    public static void main(String[] args) {

        Dog dog = new Dog(
                "Buddy",
                4,
                "Dog",
                "Aruzhan",
                true
        );

        PetDAO dao = new PetDAO();
        dao.insertPet(dog);
    }
}