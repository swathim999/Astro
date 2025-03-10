package com.example.demo.config;

import com.example.demo.entity.D2ChartResponse;
import com.example.demo.entity.PlanetResponse;
import com.example.demo.model.request.DChartDTO;
import com.example.demo.model.request.PlanetsDTO;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    private final WebClient webClient;

    public WebClientConfig(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://json.apiastro.com").build();
    }

    // Existing method for returning a String response
    public Mono<String> planetsApiCall(PlanetsDTO planetsDTO) {
        return this.webClient.post()
                .uri("/planets")
                .header("Content-Type", "application/json")
                .header("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")
                .bodyValue(planetsDTO)
                .retrieve()
                .bodyToMono(String.class);
    }

    // New method for returning a PlanetResponse object
    public Mono<PlanetResponse> planetsApiCallWithGson(PlanetsDTO planetsDTO) {
        Gson gson = new Gson();

        return this.webClient.post()
                .uri("/planets")
                .header("Content-Type", "application/json")
                .header("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")
                .bodyValue(planetsDTO)
                .retrieve()
                .bodyToMono(String.class)
                .map(responseJson -> gson.fromJson(responseJson, PlanetResponse.class)); // Deserialize JSON to PlanetResponse
    }

    public Mono<String> dChartApiCall(@Valid DChartDTO dChartDTO, String uri) {
        return this.webClient.post()
                .uri(uri)
                .header("Content-Type", "application/json")
                .header("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")
                .bodyValue(dChartDTO)
                .retrieve()
                .bodyToMono(String.class);
    }

  public Mono<D2ChartResponse> d2ChartApiCallWithGson(DChartDTO dChartDTO) {
        Gson gson = new Gson();

        return this.webClient.post()
                .uri("/d2-chart-info")
                .header("Content-Type", "application/json")
                .header("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")
                .bodyValue(dChartDTO)
                .retrieve()
                .bodyToMono(String.class)
                .map(responseJson -> gson.fromJson(responseJson, D2ChartResponse.class));
    }
}