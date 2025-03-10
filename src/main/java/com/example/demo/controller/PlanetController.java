package com.example.demo.controller;

import com.example.demo.constants.ApplicationConstants;
import com.example.demo.constants.UrlConstants;
import com.example.demo.entity.PlanetApiResponse;
import com.example.demo.mapper.RequestsMapper;
import com.example.demo.model.request.PlanetsConfig;
import com.example.demo.model.request.PlanetsDTO;
import com.example.demo.config.WebClientConfig;
import com.example.demo.utils.ReportsGeneratorUtil;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.PlanetRequest;
import com.example.demo.entity.PlanetResponse;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;

import java.io.*;
import java.util.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@Slf4j
public class PlanetController {


    @Autowired
    private WebClientConfig webClientConfig;

    @Autowired
    ReportsGeneratorUtil reportsGeneratorUtil;

    RequestsMapper requestsMapper = Mappers.getMapper(RequestsMapper.class);

    @RequestMapping(value = UrlConstants.PLANET_URL, method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<byte[]> generatePlanetReport(HttpServerRequest request,
                                                       @Valid @RequestBody PlanetRequest planetRequest) throws JRException, IOException {

        log.info("Planet Request: {}", planetRequest);
        // Create PlanetsConfig
        PlanetsConfig pc = PlanetsConfig.builder()
                .observation_point(ApplicationConstants.TOP)
                .ayanamsha(ApplicationConstants.ANS)
                .build();

        PlanetsDTO planetsDTO = requestsMapper.getPlanetDTOData(planetRequest);
        planetsDTO.setConfig(pc);
        planetsDTO.setHours(5);
        planetsDTO.setMinutes(12);
        planetsDTO.setSeconds(24);
        planetsDTO.setLatitude(13.110000F);
        planetsDTO.setLongitude(79.380000F);
        planetsDTO.setTimezone(5.5F);

        // Call the API using WebClient
        Mono<String> responseMono = webClientConfig.planetsApiCall(planetsDTO);

        // Get JSON response
        String rawResponse = responseMono.block();

        // Parse JSON response into PlanetApiResponse using Gson
        Gson gson = new Gson();
        PlanetApiResponse apiResponse = gson.fromJson(rawResponse, PlanetApiResponse.class);

        PlanetResponse planetResponse = apiResponse != null ? apiResponse.getInput() : null;

        // Check if planetResponse is null
        if (planetResponse == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("failed".getBytes());
        }

        // Print JSON format in console
        System.out.println("JSON Response:\n" + gson.toJson(planetResponse));

        log.info("Planet Response Data:");
        // Load and compile the JRXML file
        String jrxmlPath = "src/main/resources/reports/planetss.jrxml";
        //JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(jrxmlPath));

        // Create a list with a single object for JRBeanCollectionDataSource
        List<PlanetResponse> planetDataList = new ArrayList<>();
        planetDataList.add(planetResponse);

        // Create JRBeanCollectionDataSource
        //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(planetDataList);

        // Fill the Jasper report using fields ($F{}) instead of parameters
        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);
        JasperPrint jasperPrint = reportsGeneratorUtil.generateReport(jrxmlPath, planetDataList);
        // Define output file path
        String outputFilePath = "src/main/resources/reports/Planets.pdf";

        // Export the filled report to a PDF file
        byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Planets.pdf");
        // Return the planet response as JSON
        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(bytes);
    }
}
