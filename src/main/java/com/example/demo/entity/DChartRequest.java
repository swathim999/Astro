package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DChartRequest {

    @NotBlank(message = "name is mandatory")
    private String name;

    @NotBlank(message = "dob is required")
    private String dob; // Ensure format "YYYY-MM-DD"

    @NotBlank(message = "pob is required")
    private String pob; // Place of birth

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPob() {
        return pob;
    }

    public void setPob(String pob) {
        this.pob = pob;
    }
}
