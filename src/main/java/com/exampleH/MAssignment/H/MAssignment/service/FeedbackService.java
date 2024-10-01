package com.exampleH.MAssignment.H.MAssignment.service;

import com.exampleH.MAssignment.H.MAssignment.model.Feedback;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {

    // In-memory storage for feedback
    private List<Feedback> feedbackList = new ArrayList<>();

    // Method to submit feedback
    public void submitFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    // Method to retrieve all feedback
    public List<Feedback> getAllFeedback() {
        return feedbackList;
    }
}

