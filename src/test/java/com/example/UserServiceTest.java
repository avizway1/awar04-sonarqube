package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserServiceTest {
    
    // Good: Proper test method
    @Test
    public void testIsValidEmail() {
        UserService service = new UserService();
        
        assertTrue(service.isValidEmail("test@example.com"));
        assertFalse(service.isValidEmail("invalid-email"));
        assertFalse(service.isValidEmail(null));
    }
    
    // Bad: Test method without assertions
    @Test
    public void testProcessUser() {
        UserService service = new UserService();
        String result = service.processUser("john", "john@example.com", 25, "user");
        // Bad: No assertions - test doesn't verify anything
    }
    
    // Bad: Empty test method
    @Test
    public void testDeleteUser() {
        // Bad: Empty test method
    }
    
    // Good: Proper test with multiple assertions
    @Test
    public void testProcessUserValidation() {
        UserService service = new UserService();
        
        assertEquals("Invalid username", service.processUser(null, "test@example.com", 25, "user"));
        assertEquals("Username too short", service.processUser("ab", "test@example.com", 25, "user"));
        assertEquals("Invalid email", service.processUser("john", null, 25, "user"));
        assertEquals("Invalid age", service.processUser("john", "john@example.com", -1, "user"));
    }
}
