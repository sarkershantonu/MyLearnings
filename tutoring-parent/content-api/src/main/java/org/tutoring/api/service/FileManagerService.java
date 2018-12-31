package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.FileManager;

import java.util.Collection;

public interface FileManagerService {

    Collection<FileManager> viewAll() throws InvalidDataException;
    FileManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    FileManager create(FileManager aFileManager) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    FileManager update(FileManager aFileManager) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    Long delete(Long id) throws InvalidDataException, NullDataException, DatabaseUpdateException;

}
