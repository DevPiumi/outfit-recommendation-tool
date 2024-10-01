package com.exampleH.MAssignment.H.MAssignment.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outfit {
    private String itemName;
    private String category; // jacket, shirt, trousers
    private double price;
    private String style; // e.g., casual, formal
}




