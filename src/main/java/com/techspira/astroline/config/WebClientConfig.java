package com.techspira.astroline.config;

import com.techspira.astroline.model.PlanetsDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    private final WebClient webClient;

    public WebClientConfig(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://json.apiastro.com").build();;
    }

    public Mono<String> planetsApiCall(PlanetsDTO planetsDTO) {
        return this.webClient.post().uri("/planets")
                .header("Content-Type", "application/json")
                .header("x-api-key", "z2b2zWg69T6CRSZ0q7LkP8702MM75DTI5l8bPFaH")
                .bodyValue(planetsDTO)
                .retrieve().bodyToMono(String.class);
    }

}
