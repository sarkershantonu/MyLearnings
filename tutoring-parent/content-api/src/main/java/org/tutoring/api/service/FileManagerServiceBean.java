package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.FileManager;
import org.tutoring.api.repo.FileManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class FileManagerServiceBean implements FileManagerService {

    @Autowired
    private FileManagerRepository fileManagerRepository;

    @Override
    public Collection<FileManager> viewAll() throws InvalidDataException {

        try {
            return fileManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public FileManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return fileManagerRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public FileManager create(FileManager aFileManager) throws InvalidDataException, NullDataException, DatabaseUpdateException {
        if (null == aFileManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return fileManagerRepository.save(aFileManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public FileManager update(FileManager aFileManager) throws InvalidDataException, NullDataException, DatabaseUpdateException {
        if (null == aFileManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aFileManager.getFileId()) != null) {
                return fileManagerRepository.save(aFileManager);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws InvalidDataException, NullDataException, DatabaseUpdateException {

        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getFileId() != null){
                fileManagerRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
