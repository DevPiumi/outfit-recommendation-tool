package com.exampleH.MAssignment.H.MAssignment.service;

import com.exampleH.MAssignment.H.MAssignment.InventoryService;
import com.exampleH.MAssignment.H.MAssignment.model.Outfit;
import com.exampleH.MAssignment.H.MAssignment.model.UserPreferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationEngine {

    @Autowired
    private InventoryService inventoryService;

    // Method to get outfit recommendations based on user preferences
    public List<Outfit> getRecommendations(UserPreferences preferences) {
        List<Outfit> filteredInventory = inventoryService.filterInventory(preferences);
        return filteredInventory;
    }
}

