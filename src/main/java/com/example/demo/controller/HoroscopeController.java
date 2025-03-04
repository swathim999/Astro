package com.example.demo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerDetails;

import jakarta.servlet.http.HttpServletRequest;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@RestController
public class HoroscopeController {
	
	/*
	 * @GetMapping public String helthCheck() { return "service up"; }
	 */

    @GetMapping("/horoscope/generate")
    public ResponseEntity<String> generateHoroscope(HttpServletRequest req,
            @RequestParam String name,
            @RequestParam String dob,
            @RequestParam String pob) throws FileNotFoundException, JRException {

        // Create CustomerDetails object and set data
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setUserName(name);
        customerDetails.setDob(dob);
        customerDetails.setBop(pob);
        String lati = req.getHeader("Latitude");
        String Longt = req.getHeader("Longitude");
        System.out.println("lattut" + lati);
        

        // Load data into JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(Arrays.asList(customerDetails));

        // Load and compile the JRXML file
        String jrxmlPath = "src/main/resources/reports/CustomerReport.jrxml";
        JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(jrxmlPath));

        // Parameters map (if you want to pass dynamic parameters, add them here)
        Map<String, Object> parameters = new HashMap<>();

        // Fill the report
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Define output file path
        String outputFilePath = "src/main/resources/reports/CustomerReport.pdf";

        // Export the filled report to a PDF file
        JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath);

        // Return success message with file path
        return ResponseEntity.ok("PDF generated successfully at: " + outputFilePath);
    }
}
