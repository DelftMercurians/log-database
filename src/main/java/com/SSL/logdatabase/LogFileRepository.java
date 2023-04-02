package com.SSL.logdatabase;

import com.SSL.logdatabase.model.LogFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogFileRepository extends JpaRepository<LogFile, Long> {
}
