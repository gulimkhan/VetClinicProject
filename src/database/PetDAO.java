package database;

import model.Pet;
import model.Dog;
import model.Cat;

import java.sql.*;
import java.util.ArrayList;

public class PetDAO {

    // ================= INSERT =================
    public void insertPet(Pet pet) {
        String sql = "INSERT INTO pet (name, age, species, owner_name) VALUES (?, ?, ?, ?)";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getAge());
            ps.setString(3, pet.getSpecies());
            ps.setString(4, pet.getOwnerName());

            ps.executeUpdate();
            ps.close();
            System.out.println("Pet inserted successfully ✅");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }

    // ================= SELECT =================
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pets.add(extractPet(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return pets;
    }

    // ================= UPDATE =================
    public boolean updatePet(int id, String name, int age, String owner) {
        String sql = "UPDATE pet SET name=?, age=?, owner_name=? WHERE pet_id=?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, owner);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    // ================= DELETE =================
    public boolean deletePet(int id) {
        String sql = "DELETE FROM pet WHERE pet_id=?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            ps.close();

            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }

    // ================= SEARCH =================
    public ArrayList<Pet> searchByName(String name) {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE name ILIKE ?";
        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pets.add(extractPet(rs));
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return pets;
    }

    // ================= HELPER =================
    private Pet extractPet(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String species = rs.getString("species");
        String owner = rs.
                getString("owner_name");

        if (species.equalsIgnoreCase("Dog")) {
            return new Dog(name, age, owner, "Unknown", false);
        } else {
            return new Cat(name, age, owner, "Unknown", true);
        }
    }
}
