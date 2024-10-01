package com.exampleH.MAssignment.H.MAssignment;

import com.exampleH.MAssignment.H.MAssignment.model.Outfit;
import com.exampleH.MAssignment.H.MAssignment.model.UserPreferences;
import com.exampleH.MAssignment.H.MAssignment.service.RecommendationEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationEngineTest {

    @Mock
    private InventoryService inventoryService;  // Mock InventoryService

    @InjectMocks
    private RecommendationEngine recommendationEngine;  // Inject mocks into RecommendationEngine

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    public void testGetRecommendations() {
        // Prepare test data
        UserPreferences preferences = new UserPreferences();
        preferences.setEventType("Wedding");
        preferences.setBudget(300);
        preferences.setStylePreference("formal");

        List<Outfit> mockOutfits = Arrays.asList(
                new Outfit("Formal Shirt", "Shirt", 100, "formal"),
                new Outfit("Trousers", "Trousers", 150, "formal")
        );

        // Mock the behavior of InventoryService
        when(inventoryService.filterInventory(preferences)).thenReturn(mockOutfits);

        // Call the method under test
        List<Outfit> recommendations = recommendationEngine.getRecommendations(preferences);

        // Verify the results
        assertEquals(2, recommendations.size());
    }

    @Test
    public void testGetNoRecommendations() {
        // Prepare test data
        UserPreferences preferences = new UserPreferences();
        preferences.setEventType("Casual");
        preferences.setBudget(50);
        preferences.setStylePreference("casual");

        // Mock the behavior of InventoryService (no outfits meet the criteria)
        when(inventoryService.filterInventory(preferences)).thenReturn(Arrays.asList());

        // Call the method under test
        List<Outfit> recommendations = recommendationEngine.getRecommendations(preferences);

        // Verify the results
        assertEquals(0, recommendations.size());
    }
}
