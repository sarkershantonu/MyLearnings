package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.FileManager;

import java.util.Collection;

public interface FileManagerService {

    Collection<FileManager> viewAll();
    FileManager findOne(Long id) throws NullDataException, InvalidDataException;
    FileManager create(FileManager aFileManager) throws InvalidDataException, NullDataException;
    FileManager update(FileManager aFileManager) throws InvalidDataException, NullDataException;
    Long delete(Long id) throws InvalidDataException, NullDataException;

}
