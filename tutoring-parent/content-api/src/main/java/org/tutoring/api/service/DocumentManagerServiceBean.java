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
import org.tutoring.api.model.DocumentManager;
import org.tutoring.api.repo.DocumentManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class DocumentManagerServiceBean implements DocumentManagerService {

    @Autowired
    private DocumentManagerRepository documentManagerRepository;

    @Override
    public Collection<DocumentManager> viewAll() throws InvalidDataException {
        try {
            return documentManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public DocumentManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return documentManagerRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DocumentManager create(DocumentManager aDocumentManager) throws InvalidDataException, NullDataException, DatabaseUpdateException {
        if (null == aDocumentManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return documentManagerRepository.save(aDocumentManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DocumentManager update(DocumentManager aDocumentManager) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aDocumentManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aDocumentManager.getFileId()) != null) {
                return documentManagerRepository.save(aDocumentManager);
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
                documentManagerRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
