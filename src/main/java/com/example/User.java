package com.example;

/**
 * Good: Proper class documentation
 * Represents a user in the system
 */
public class User {
    private String name;
    private String email;
    
    // Good: Proper constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    // Good: Proper getters and setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    // Good: Proper equals and hashCode implementation
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        User user = (User) obj;
        return name != null ? name.equals(user.name) : user.name == null &&
               email != null ? email.equals(user.email) : user.email == null;
    }
    
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
