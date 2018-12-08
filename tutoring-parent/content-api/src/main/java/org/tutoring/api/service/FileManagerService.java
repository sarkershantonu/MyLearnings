package org.tutoring.api.service;

import org.tutoring.api.model.FileManager;

import java.util.Collection;

public interface FileManagerService {

    Collection<FileManager> viewAll();
    FileManager findOne(Long id);
    FileManager create(FileManager aFileManager);
    FileManager update(FileManager aFileManager);
    Long delete(Long id);

}
