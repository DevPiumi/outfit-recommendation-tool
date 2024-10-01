package com.exampleH.MAssignment.H.MAssignment;

import com.exampleH.MAssignment.H.MAssignment.model.Feedback;
import com.exampleH.MAssignment.H.MAssignment.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedbackServiceTest {

    private FeedbackService feedbackService;

    @BeforeEach
    public void setUp() {
        feedbackService = new FeedbackService();
    }

    @Test
    public void testSubmitFeedback() {
        // Create a feedback object
        Feedback feedback = new Feedback();
        feedback.setUserId("user123");
        feedback.setEventType("Wedding");
        feedback.setSelectedOutfits(List.of("Formal Shirt", "Trousers"));
        feedback.setFeedbackText("Great suggestions!");
        feedback.setRating(5);

        // Submit feedback
        feedbackService.submitFeedback(feedback);

        // Verify feedback is stored
        List<Feedback> allFeedback = feedbackService.getAllFeedback();
        assertEquals(1, allFeedback.size());
        assertEquals("user123", allFeedback.get(0).getUserId());
    }

    @Test
    public void testGetAllFeedback() {
        // Submit some feedback
        Feedback feedback1 = new Feedback();
        feedback1.setUserId("user123");
        feedback1.setEventType("Wedding");
        feedback1.setSelectedOutfits(List.of("Formal Shirt", "Trousers"));
        feedback1.setFeedbackText("Great suggestions!");
        feedback1.setRating(5);

        Feedback feedback2 = new Feedback();
        feedback2.setUserId("user456");
        feedback2.setEventType("Christmas");
        feedback2.setSelectedOutfits(List.of("Christmas Sweater", "Jeans"));
        feedback2.setFeedbackText("Loved the options!");
        feedback2.setRating(4);

        feedbackService.submitFeedback(feedback1);
        feedbackService.submitFeedback(feedback2);

        // Verify all feedback is returned
        List<Feedback> allFeedback = feedbackService.getAllFeedback();
        assertEquals(2, allFeedback.size());
    }
}

