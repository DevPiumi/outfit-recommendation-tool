package com.exampleH.MAssignment.H.MAssignment;

import com.exampleH.MAssignment.H.MAssignment.controller.FeedbackController;
import com.exampleH.MAssignment.H.MAssignment.model.Feedback;
import com.exampleH.MAssignment.H.MAssignment.service.FeedbackService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FeedbackControllerTest {

    @InjectMocks
    private FeedbackController feedbackController;

    @Mock
    private FeedbackService feedbackService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitFeedback() {
        Feedback feedback = new Feedback();
        feedback.setUserId("user123");
        feedback.setEventType("Wedding");
        feedback.setSelectedOutfits(List.of("Formal Shirt", "Trousers"));
        feedback.setFeedbackText("Great suggestions!");
        feedback.setRating(5);

        doNothing().when(feedbackService).submitFeedback(feedback);

        ResponseEntity<String> response = feedbackController.submitFeedback(feedback);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Feedback submitted successfully", response.getBody());

        // Verify that feedbackService.submitFeedback was called
        verify(feedbackService).submitFeedback(feedback);
    }

    @Test
    public void testGetAllFeedback() {
        // Prepare mock data for feedback
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

        // Mock the service call
        when(feedbackService.getAllFeedback()).thenReturn(Arrays.asList(feedback1, feedback2));

        // Call the endpoint
        ResponseEntity<List<Feedback>> response = feedbackController.getAllFeedback();

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
        assertEquals("user123", response.getBody().get(0).getUserId());
    }
}

