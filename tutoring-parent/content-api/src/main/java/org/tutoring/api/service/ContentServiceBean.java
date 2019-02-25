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
import org.tutoring.api.model.Content;
import org.tutoring.api.repo.ContentRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ContentServiceBean implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Collection<Content> viewAll() throws InvalidDataException {

        try {
            return contentRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public Content findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return contentRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Content create(Content aContent) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aContent) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return contentRepository.save(aContent);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Content update(Content aContent) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aContent) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aContent.getContentId()) != null) {
                return contentRepository.save(aContent);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, DatabaseUpdateException {
        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getContentId() != null){
                contentRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
