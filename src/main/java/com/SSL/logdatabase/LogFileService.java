package com.SSL.logdatabase;

import com.SSL.logdatabase.model.LogFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogFileService {
    @Autowired
    private LogFileRepository logFileRepository;

    public byte[] getLogFileData(Long id) {
        Optional<LogFile> logFile = logFileRepository.findById(id);
        if (logFile.isPresent()) {
            return logFile.get().getFileData();
        }
        return null;
    }

    public byte[] getLogFileDataByName(String fileName) {
        List<LogFile> logFile = logFileRepository.findAll();
        List<LogFile> res = logFile.stream().filter(l -> l.getFileName().equals(fileName)).toList();
        if (res.size() > 0) {
            return res.get(0).getFileData();
        }
        return null;
    }
    public Long saveLogFileData(String fileName, byte[] fileData) {
        LogFile logFile = new LogFile(fileName, fileData);
        logFileRepository.save(logFile);
        return logFile.getId();
    }
}
