package com.techspira.astroline.rest;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.techspira.astroline.config.WebClientConfig;
import com.techspira.astroline.model.PlanetsConfig;
import com.techspira.astroline.model.PlanetsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/test")
public class ServiceTest {

    @Autowired
    WebClientConfig webClientConfig;

    @GetMapping
    public String testService() {



        PlanetsConfig pc = new PlanetsConfig();

        pc.setObservation_point("topocentric");
        pc.setAyanamsha("lahiri");

        PlanetsDTO planetsDTO = new PlanetsDTO();
        planetsDTO.setYear(1976);
        planetsDTO.setMonth(6);
        planetsDTO.setDate(10);
        planetsDTO.setHours(11);
        planetsDTO.setMinutes(10);
        planetsDTO.setSeconds(0);
        planetsDTO.setLatitude(18.933F);
        planetsDTO.setLongitude(72.8166F);
        planetsDTO.setTimezone(5.5F);
        planetsDTO.setConfig(pc);

        Mono<String> stringMono = webClientConfig.planetsApiCall(planetsDTO);

        stringMono.subscribe(data -> {
            System.out.println("data: " + data);
        });
        System.out.println(stringMono.toString());

        return stringMono.toString();
    }
}
