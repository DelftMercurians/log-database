package com.SSL.logdatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LogFileServiceTest {

    private String path;
    private String fileName;
    private byte[] fileData;

    @Autowired
    private LogFileService logFileService;

    @BeforeEach
    void setUp() throws IOException {
        String path = "./src/test/java/com/SSL/logdatabase/test.log";
        String fileName = "test.log";
        byte[] fileData = Files.readAllBytes(Path.of(path));
        this.path = path;
        this.fileName = fileName;
        this.fileData = fileData;
    }

    @Test
    void getLogFileData() {
        System.out.println(fileName);
        byte[] res = logFileService.getLogFileData(1L);
        assertNull(res);

        Long id = logFileService.saveLogFileData(fileName, fileData);
        res = logFileService.getLogFileData(id);
        assertNotNull(res);

    }
}