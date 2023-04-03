package com.SSL.logdatabase.model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class LogFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String file_name;


    @Lob
    private byte[] file_data;

    public LogFile() {
    }

    public LogFile(String fileName, byte[] fileData) {
        this.file_name = fileName;
        this.file_data = fileData;
    }

    public Long getId() {
        return id;
    }

    public String getFileName() {
        return file_name;
    }

    public void setFileName(String fileName) {
        this.file_name = fileName;
    }

    public byte[] getFileData() {
        return file_data;
    }

    public void setFileData(byte[] fileData) {
        this.file_data = fileData;
    }



}
