package com.SSL.logdatabase;
import com.SSL.logdatabase.model.LogFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class DataLoader implements CommandLineRunner{

    @Autowired
    private LogFileService logFileService;

    @Override
    public void run(String... args) throws Exception {
        if (args.length == 0) {
            System.out.println("Please provide a path to the folder containing the log files");
            return;
        }
        String path = args[0];
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            System.out.println("processing file: " + file.getName());
            if (file.isFile()&& file.getName().endsWith(".log")) {
                byte[] fileData = Files.readAllBytes(Path.of(file.getPath()));
                logFileService.saveLogFileData(file.getName(), fileData);
            }
        }
    }


}
