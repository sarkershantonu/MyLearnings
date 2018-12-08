package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.FileManager;
import org.tutoring.api.repo.FileManagerRepository;

import java.util.Collection;

public class FileManagerServiceBean implements FileManagerService {

    @Autowired
    private FileManagerRepository FileManagerRepository;

    @Override
    public Collection<FileManager> viewAll() {
        return FileManagerRepository.findAll();
    }

    @Override
    public FileManager findOne(Long id) {
        return null;
    }

    @Override
    public FileManager create(FileManager aFileManager) {
        return null;
    }

    @Override
    public FileManager update(FileManager aFileManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
