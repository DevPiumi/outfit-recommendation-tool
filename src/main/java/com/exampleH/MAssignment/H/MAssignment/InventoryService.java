package com.exampleH.MAssignment.H.MAssignment;

import com.exampleH.MAssignment.H.MAssignment.model.Outfit;
import com.exampleH.MAssignment.H.MAssignment.model.UserPreferences;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    // In-memory inventory list
    private List<Outfit> inventory = new ArrayList<>();

    public InventoryService() {
        // Initialize with a more comprehensive list of outfits
        inventory.add(new Outfit("Winter Jacket", "Jacket", 200, "casual"));
        inventory.add(new Outfit("Formal Shirt", "Shirt", 100, "formal"));
        inventory.add(new Outfit("Trousers", "Trousers", 150, "formal"));
        inventory.add(new Outfit("Boots", "Footwear", 180, "casual"));
        inventory.add(new Outfit("Summer Dress", "Dress", 120, "casual"));
        inventory.add(new Outfit("Leather Jacket", "Jacket", 250, "casual"));
        inventory.add(new Outfit("Business Suit", "Suit", 350, "formal"));
        inventory.add(new Outfit("Sneakers", "Footwear", 90, "casual"));
        inventory.add(new Outfit("Evening Gown", "Dress", 400, "formal"));
        inventory.add(new Outfit("Casual T-Shirt", "Shirt", 40, "casual"));
        inventory.add(new Outfit("Denim Jeans", "Trousers", 80, "casual"));
        inventory.add(new Outfit("Polo Shirt", "Shirt", 60, "casual"));
        inventory.add(new Outfit("Chinos", "Trousers", 120, "casual"));
        inventory.add(new Outfit("Sandals", "Footwear", 50, "casual"));
        inventory.add(new Outfit("Overcoat", "Jacket", 300, "formal"));
        inventory.add(new Outfit("Blazer", "Jacket", 200, "formal"));
        inventory.add(new Outfit("Skirt", "Dress", 70, "casual"));
        inventory.add(new Outfit("Cardigan", "Sweater", 80, "casual"));
        inventory.add(new Outfit("Hoodie", "Sweater", 60, "casual"));
        inventory.add(new Outfit("Dress Shoes", "Footwear", 120, "formal"));
    }


    // Method to filter inventory based on user preferences
    public List<Outfit> filterInventory(UserPreferences preferences) {
        return inventory.stream()
                .filter(outfit -> outfit.getPrice() <= preferences.getBudget())
                .filter(outfit -> outfit.getStyle().equalsIgnoreCase(preferences.getStylePreference()))
                .collect(Collectors.toList());
    }
}

