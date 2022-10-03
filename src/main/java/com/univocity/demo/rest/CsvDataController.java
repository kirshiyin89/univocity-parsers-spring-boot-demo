package com.univocity.demo.rest;

import com.univocity.demo.dto.CsvData;
import com.univocity.demo.service.CsvDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CsvDataController {

    private final CsvDataService csvDataService;

    @GetMapping("/getServiceCaseById")
    public ResponseEntity<String> getServiceCaseById(String id) {
        String response = csvDataService.getDataById(id).getServiceCase();
        log.debug("Response: {}", response);
        return ResponseEntity.accepted().body(response);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<CsvData>> getAllData() {
        List<CsvData> response = csvDataService.getAllData();
        log.debug("Response: {}", response);
        return ResponseEntity.accepted().body(response);
    }
}
