package com.example;

import java.util.*;
import java.io.*;

public class Utils {
    
    // Bad: Unused import and variable
    private static final String UNUSED_CONSTANT = "never used";
    
    // Bad: Method that always returns the same value
    public static boolean alwaysTrue() {
        return true;
    }
    
    // Bad: Duplicated code blocks
    public static String formatUserName(String firstName, String lastName) {
        if (firstName == null) {
            firstName = "";
        }
        if (lastName == null) {
            lastName = "";
        }
        return firstName + " " + lastName;
    }
    
    public static String formatFullName(String first, String last) {
        if (first == null) {
            first = "";
        }
        if (last == null) {
            last = "";
        }
        return first + " " + last;
    }
    
    // Bad: Resource leak - file not closed properly
    public static String readFile(String filename) {
        try {
            FileReader file = new FileReader(filename);
            BufferedReader reader = new BufferedReader(file);
            return reader.readLine();
            // Bad: Resources not closed - potential memory leak
        } catch (IOException e) {
            return null;
        }
    }
    
    // Bad: Cognitive complexity too high
    public static String processData(String input) {
        String result = "";
        
        if (input != null) {
            if (input.length() > 0) {
                if (input.startsWith("A")) {
                    if (input.endsWith("Z")) {
                        if (input.contains("B")) {
                            if (input.length() > 5) {
                                result = "Complex processing A";
                            } else {
                                result = "Simple processing A";
                            }
                        } else {
                            result = "No B found";
                        }
                    } else {
                        result = "Doesn't end with Z";
                    }
                } else {
                    result = "Doesn't start with A";
                }
            } else {
                result = "Empty string";
            }
        } else {
            result = "Null input";
        }
        
        return result;
    }
    
    // Good: Simple, clean method
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    // Bad: Magic numbers
    public static double calculateDiscount(double price) {
        if (price > 1000) {
            return price * 0.15; // Bad: Magic number 0.15
        } else if (price > 500) {
            return price * 0.10; // Bad: Magic number 0.10
        }
        return price * 0.05; // Bad: Magic number 0.05
    }
}
