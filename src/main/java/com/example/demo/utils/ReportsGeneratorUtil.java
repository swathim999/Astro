package com.example.demo.utils;

import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Component
public class ReportsGeneratorUtil {
    public JasperPrint generateReport(String jrxmlPath, List<?> dataList) throws JRException, FileNotFoundException {

        log.info("Generating report");
        JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(jrxmlPath));

        // Create JRBeanCollectionDataSource
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);

        // Fill the Jasper report using fields ($F{}) instead of parameters
         return JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);
    }
}
