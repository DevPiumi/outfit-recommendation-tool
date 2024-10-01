package com.exampleH.MAssignment.H.MAssignment.model;

import lombok.Data;

@Data
public class UserPreferences {
    private String eventType; // e.g., Wedding, Christmas
    private double budget;
    private String stylePreference; // e.g., casual, formal
}

