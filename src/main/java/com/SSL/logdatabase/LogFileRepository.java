package com.SSL.logdatabase;

import com.SSL.logdatabase.model.LogFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LogFileRepository extends JpaRepository<LogFile, Long> {
    @Query("SELECT l FROM LogFile l WHERE l.file_name = ?1")
    List<LogFile> findAllByFileName(String fileName);
}
