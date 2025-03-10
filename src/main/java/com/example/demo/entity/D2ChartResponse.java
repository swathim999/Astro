package com.example.demo.entity;

import com.example.demo.model.request.D2ChartSettings;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class D2ChartResponse {
    String statusCode;
    Map<String, ChartData> output;
}
