package com.example.demo.entity;

import com.google.gson.annotations.SerializedName;

public class D2ChartApiResponse {
    //@SerializedName is an annotation from Google's Gson library,used to map JSON property names to Java field names when serializing and deserializing objects.

    @SerializedName("statusCode")
    private int statusCode;


    @SerializedName("input")
    private PlanetResponse input; // The actual data you need

    // Getters and Setters
    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setInput(PlanetResponse input) {
        this.input = input;
    }

    public PlanetResponse getInput() {  // This will return the "input" field
        return input;
    }
}
