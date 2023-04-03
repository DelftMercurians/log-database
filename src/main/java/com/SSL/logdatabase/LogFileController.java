package com.SSL.logdatabase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/logfiles")
public class LogFileController {
    @Autowired
    private LogFileService logFileService;

    @GetMapping("/")
    public ResponseEntity<byte[]> getLogFileData(@RequestBody String filename) {
        byte[] fileData = logFileService.getLogFileDataByName(filename);
        if (fileData == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .body(fileData);
    }
}