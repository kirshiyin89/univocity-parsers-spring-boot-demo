package com.univocity.demo.dto;

import com.univocity.parsers.annotations.Parsed;
import lombok.Data;

@Data
public class CsvData {

    @Parsed(field = "SERVICE_ID")
    private String id;

    @Parsed(field = "SERVICE_NAME")
    private String serviceName;

    @Parsed(field = "SERVICE_CASE")
    private String serviceCase;

    @Parsed(field = "SERVICE_CLIENT")
    private String serviceClient;
}
