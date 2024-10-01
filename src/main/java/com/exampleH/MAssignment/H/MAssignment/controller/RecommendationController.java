package com.exampleH.MAssignment.H.MAssignment.controller;

import com.exampleH.MAssignment.H.MAssignment.model.Outfit;
import com.exampleH.MAssignment.H.MAssignment.model.UserPreferences;
import com.exampleH.MAssignment.H.MAssignment.service.RecommendationEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationEngine recommendationEngine;

    @PostMapping
    public ResponseEntity<List<Outfit>> getRecommendations(@RequestBody UserPreferences preferences) {
        List<Outfit> recommendations = recommendationEngine.getRecommendations(preferences);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}