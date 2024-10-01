package com.exampleH.MAssignment.H.MAssignment.model;

import lombok.Data;
import java.util.List;

@Data
public class Feedback {
    private String userId;
    private String eventType;
    private List<String> selectedOutfits;
    private String feedbackText;
    private int rating; // A rating from 1 to 5
}
