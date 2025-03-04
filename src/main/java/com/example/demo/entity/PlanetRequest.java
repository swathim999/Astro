package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
@ToString
public class PlanetRequest implements Serializable {

	@NotBlank(message = "name is mandatory")
	private String name;

	@NotBlank(message = "dob is required")
	private String dob; // Ensure format "YYYY-MM-DD"

	@NotBlank(message = "pob is required")
	private String pob; // Place of birth

}