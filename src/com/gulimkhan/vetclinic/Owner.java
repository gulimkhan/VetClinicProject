package com.gulimkhan;

public class Owner {
    private String name;
    private String phone;

    public Owner(String name, String phone) {
        setName(name);
        setPhone(phone);
    }

    // Getters
    public String getName() { return name; }
    public String getPhone() { return phone; }

    // Setters with validation
    public void setName(String name) {
        if(name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Owner name cannot be empty! Setting to 'Unknown'.");
            this.name = "Unknown";
        }
    }

    public void setPhone(String phone) {
        if(phone != null && phone.contains("+") && phone.length() >= 10) {
            this.phone = phone;
        } else {
            System.out.println("Warning: Invalid phone number! Setting to '+0000000000'.");
            this.phone = "+0000000000";
        }
    }

    @Override
    public String toString() {
        return name + " (Phone: " + phone + ")";
    }
}