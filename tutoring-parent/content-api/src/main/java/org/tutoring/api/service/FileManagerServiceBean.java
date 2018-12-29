package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.FileManager;
import org.tutoring.api.repo.FileManagerRepository;

import java.util.Collection;

public class FileManagerServiceBean implements FileManagerService {

    @Autowired
    private FileManagerRepository fileManagerRepository;

    @Override
    public Collection<FileManager> viewAll() {
        return fileManagerRepository.findAll();
    }

    @Override
    public FileManager findOne(Long id) throws NullDataException, InvalidDataException {

        if (id == null){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return fileManagerRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public FileManager create(FileManager aFileManager) throws InvalidDataException, NullDataException {

        if (null == aFileManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aFileManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return fileManagerRepository.save(aFileManager);
    }
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public FileManager update(FileManager aFileManager) throws InvalidDataException, NullDataException {
        if (null == aFileManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aFileManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return fileManagerRepository.save(aFileManager);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws InvalidDataException, NullDataException {

        if (id == null){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        fileManagerRepository.deleteById(id);
        return id;    }
}
