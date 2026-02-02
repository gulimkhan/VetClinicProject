import database.PetDAO;

public class TestSelect {
    public static void main(String[] args) {

        PetDAO dao = new PetDAO();


        dao.getAllPets();

        System.out.println("TestSelect completed!");
    }
}