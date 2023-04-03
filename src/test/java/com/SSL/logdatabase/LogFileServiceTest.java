package com.SSL.logdatabase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class LogFileServiceTest {

    private String fileName;
    private byte[] fileData;

    private LogFileService logFileService;

    @BeforeEach
    void setUp() throws IOException {
        this.fileName = "testovo.log";
        //assign byte array to fileData
        this.fileData = this.fileName.getBytes(StandardCharsets.UTF_8);
        this.logFileService = new LogFileService(new LogFileTestRepository());
    }

    @Test
    void getLogFileData() {

        byte[] res = logFileService.getLogFileData(0L);
        assertNull(res);

        Long id = logFileService.saveLogFileData(fileName, fileData);
        res = logFileService.getLogFileData(id);
        assertNotNull(res);

    }

    @Test
    void getLogFileDataByName() {
        byte[] res = logFileService.getLogFileDataByName(fileName);
        assertNull(res);

        Long id = logFileService.saveLogFileData(fileName, fileData);
        res = logFileService.getLogFileDataByName(fileName);
        assertNotNull(res);

    }
}