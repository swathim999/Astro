package com.techspira.astroline.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor // Generates a constructor with all fields as parameters
@NoArgsConstructor  // Generates a no-argument constructor
@ToString           // Generates a toString method
public class PlanetsRequest {
    // Define your fields here
    private String name;
    private int position;
}
