package com.example;

import java.util.*;
import java.sql.*;

// Bad: Missing class documentation
public class UserService {
    
    // Bad: Public field instead of private with getter/setter
    public String adminPassword = "admin123";
    
    private Connection connection;
    private List<String> users = new ArrayList<>();
    
    // Bad: Empty catch block
    public void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "password");
        } catch (SQLException e) {
            // Bad: Empty catch block - SonarQube will flag this
        }
    }
    
    // Bad: Method too complex (high cyclomatic complexity)
    public String processUser(String username, String email, int age, String role) {
        if (username == null) {
            return "Invalid username";
        }
        if (username.length() < 3) {
            return "Username too short";
        }
        if (username.length() > 20) {
            return "Username too long";
        }
        if (email == null) {
            return "Invalid email";
        }
        if (!email.contains("@")) {
            return "Invalid email format";
        }
        if (age < 0) {
            return "Invalid age";
        }
        if (age > 120) {
            return "Age too high";
        }
        if (role == null) {
            return "Invalid role";
        }
        if (!role.equals("admin") && !role.equals("user") && !role.equals("guest")) {
            return "Invalid role type";
        }
        
        users.add(username);
        return "User processed successfully";
    }
    
    // Bad: SQL injection vulnerability
    public User getUserById(String userId) {
        try {
            Statement stmt = connection.createStatement();
            // Bad: Direct string concatenation in SQL - SQL injection risk
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + userId);
            
            if (rs.next()) {
                return new User(rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Bad: Printing stack trace
        }
        return null;
    }
    
    // Bad: Unused method parameter
    public void deleteUser(String username, boolean force) {
        users.remove(username);
        // 'force' parameter is never used
    }
    
    // Bad: Method with too many parameters
    public void createUser(String firstName, String lastName, String email, 
                          String phone, String address, String city, 
                          String state, String zipCode, String country) {
        // Implementation
    }
    
    // Good: Proper method with validation
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    // Bad: Hardcoded credentials
    private void authenticateAdmin() {
        String hardcodedPassword = "secretPassword123";
        // Bad practice - hardcoded credentials
    }
}
