package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;

public class PetDAO {

    // INSERT
    public void insertPet(Pet pet) {
        String sql = "INSERT INTO pet (name, age, species, owner_name) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, pet.getName());
            ps.setInt(2, pet.getAge());
            ps.setString(3, pet.getSpecies());
            ps.setString(4, pet.getOwnerName());

            ps.executeUpdate();
            System.out.println("Pet inserted successfully ✅");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // SELECT ALL
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                pets.add(extractPet(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // UPDATE
    public boolean updatePet(int id, String name, int age, String owner) {
        String sql = "UPDATE pet SET name=?, age=?, owner_name=? WHERE pet_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, owner);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE
    public boolean deletePet(int id) {
        String sql = "DELETE FROM pet WHERE pet_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // SEARCH by Name
    public ArrayList<Pet> searchByName(String name) {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE name ILIKE ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pets.add(extractPet(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // SEARCH by Age Range
    public ArrayList<Pet> searchByAgeRange(int min, int max) {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE age BETWEEN ? AND ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pets.add(extractPet(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // SEARCH by Min Age
    public ArrayList<Pet> searchByMinAge(int min) {
        ArrayList<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet WHERE age >= ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    pets.add(extractPet(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pets;
    }

    // HELPER
    private Pet extractPet(ResultSet rs) throws SQLException {
        String name = rs.getString("name");
        int age = rs.getInt("age");
        String species = rs.getString("species");
        String owner = rs.getString("owner_name");

        if (species.equalsIgnoreCase("Dog")) {
            return new Dog(name, age, owner, "Unknown", false);
        } else {
            return new Cat(name, age, owner, "Unknown", true);
        }
    }
}
