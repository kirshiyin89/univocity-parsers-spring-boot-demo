package com.univocity.demo.service;

import com.univocity.demo.dto.CsvData;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CsvDataService {

    private final HashMap<String, CsvData> dataMap = new HashMap<>();

    @PostConstruct
    private void populateDataMap() {
        BeanListProcessor<CsvData> rowProcessor = parseDataFromFile();
        for (CsvData data : rowProcessor.getBeans()) {
            dataMap.put(data.getId(), data);
        }
    }

    private BeanListProcessor<CsvData> parseDataFromFile() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("data.csv");
        CsvParserSettings settings = new CsvParserSettings();
        BeanListProcessor<CsvData> rowProcessor = new BeanListProcessor<>(CsvData.class);
        settings.setHeaderExtractionEnabled(true);
        settings.setProcessor(rowProcessor);
        settings.selectFields("SERVICE_ID", "SERVICE_NAME", "SERVICE_CASE");
        CsvParser parser = new CsvParser(settings);
        parser.parseAllRecords(is);
        return rowProcessor;
    }

    public CsvData getDataById(String id) {
        return dataMap.get(id);
    }

    public List<CsvData> getAllData() {
        return new ArrayList<>(dataMap.values());
    }

}

