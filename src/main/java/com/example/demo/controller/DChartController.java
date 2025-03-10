package com.example.demo.controller;

import com.example.demo.config.WebClientConfig;
import com.example.demo.constants.ApplicationConstants;
import com.example.demo.entity.ChartData;
import com.example.demo.entity.D2ChartResponse;
import com.example.demo.entity.DChartRequest;
import com.example.demo.entity.ReportRequest;
import com.example.demo.mapper.RequestsMapper;
import com.example.demo.model.request.DChartDTO;
import com.example.demo.model.request.PlanetsConfig;

import com.example.demo.utils.ReportsGeneratorUtil;
import com.google.gson.Gson;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:5173")
public class DChartController {

    @Autowired
    private WebClientConfig webClientConfig;

    @Autowired
    ReportsGeneratorUtil reportsGeneratorUtil;

    RequestsMapper requestsMapper = Mappers.getMapper(RequestsMapper.class);

    @PostMapping("/api/d2-chart/json")
    public ResponseEntity<byte[]> getDChartJson(@Valid @RequestBody DChartRequest dChartRequest) throws JRException, FileNotFoundException {
        log.info("Request JSON"); // Print Request JSON

        PlanetsConfig pc = PlanetsConfig.builder()
                .observation_point(ApplicationConstants.TOP)
                .ayanamsha(ApplicationConstants.ANS)
                .build();

        //create one pojo and update the name of the pojo
        DChartDTO dChartDTO = requestsMapper.getDChartRequest(dChartRequest);

        dChartDTO.setConfig(pc);
        dChartDTO.setHours(5);
        dChartDTO.setMinutes(12);
        dChartDTO.setSeconds(24);
        dChartDTO.setLatitude(13.110000F);
        dChartDTO.setLongitude(79.380000F);
        dChartDTO.setTimezone(5.5F);
        // Call external API
        Mono<String> HoraMono = webClientConfig.dChartApiCall(dChartDTO, "/d2-chart-info");

        // Blocking call with safe handling
        String HoraResponse = HoraMono.block();  // Get raw JSON response

        //D2ChartResponse d2ChartResponse = new Gson().fromJson(HoraResponse, D2ChartResponse.class);
        // Parsing JSON response
        Gson gson = new Gson();
        D2ChartResponse d2ChartResponse = gson.fromJson(HoraResponse, D2ChartResponse.class);
        log.info("Response JSON: {}", gson.toJson(d2ChartResponse)); // Print Response JSON

        // Generating Report Data
        ReportRequest reportRequest = new ReportRequest();
        Map<String, ChartData> output = d2ChartResponse.getOutput();

        log.info("Response JSON: {}",d2ChartResponse ); // Print Response JSON in console

        output.values().forEach(chartData -> {
            if (chartData.getCurrent_sign().equals("1")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("2")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("3")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("4")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("5")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("6")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("7")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("8")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("9")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("10")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("11")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
            if (chartData.getCurrent_sign().equals("12")) {
                reportRequest.setHoraone(reportRequest.getHoraone() + " " + chartData.getName().substring(0,3));
            }
        });


        log.info("Generating PDF Report...");

        // Preparing Data for Report
        List<ReportRequest> reportDataList = new ArrayList<>();
        reportDataList.add(reportRequest);

        // Generating PDF
        String jrxmlPath = "src/main/resources/reports/chart5.jrxml";
        JasperPrint jasperPrint = reportsGeneratorUtil.generateReport(jrxmlPath, reportDataList);
        byte[] pdfBytes = JasperExportManager.exportReportToPdf(jasperPrint);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Hora.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
