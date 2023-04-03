package com.SSL.logdatabase;

import com.SSL.logdatabase.model.LogFile;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.*;
import java.util.function.Function;

public class LogFileTestRepository implements LogFileRepository{

    public Map<Long, LogFile> db = new HashMap();

    @Override
    public List<LogFile> findAllByFileName(String fileName) {
        List<LogFile>res = new ArrayList<>();
        for (LogFile logFile : db.values()) {
            if (logFile.getFileName().equals(fileName)) {
                res.add(logFile);
            }
        }
        return res;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends LogFile> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends LogFile> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<LogFile> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public LogFile getOne(Long aLong) {
        return null;
    }

    @Override
    public LogFile getById(Long aLong) {
        if(db.containsKey(aLong)){
            return db.get(aLong);
        }
        return null;
    }

    @Override
    public LogFile getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends LogFile> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends LogFile> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends LogFile> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends LogFile> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LogFile> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends LogFile> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends LogFile, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends LogFile> S save(S entity) {
        List<Long>ids = new ArrayList<>(db.keySet());
        if(ids.size() == 0) {
            entity.setId(1L);
        } else {
            entity.setId(Collections.max(ids) + 1);
        }
        db.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public <S extends LogFile> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LogFile> findById(Long aLong) {
        if (db.containsKey(aLong)) {
            return Optional.of(db.get(aLong));
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<LogFile> findAll() {
        return new ArrayList<>(db.values());
    }

    @Override
    public List<LogFile> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(LogFile entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends LogFile> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LogFile> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<LogFile> findAll(Pageable pageable) {
        return null;
    }
}
