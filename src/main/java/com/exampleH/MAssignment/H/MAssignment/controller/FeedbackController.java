package com.exampleH.MAssignment.H.MAssignment.controller;

import com.exampleH.MAssignment.H.MAssignment.model.Feedback;
import com.exampleH.MAssignment.H.MAssignment.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // Endpoint for submitting feedback
    @PostMapping
    public ResponseEntity<String> submitFeedback(@RequestBody Feedback feedback) {
        feedbackService.submitFeedback(feedback);
        return new ResponseEntity<>("Feedback submitted successfully", HttpStatus.OK);
    }

    // Endpoint to retrieve all feedback
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedback() {
        List<Feedback> feedbackList = feedbackService.getAllFeedback();
        return new ResponseEntity<>(feedbackList, HttpStatus.OK);
    }
}

