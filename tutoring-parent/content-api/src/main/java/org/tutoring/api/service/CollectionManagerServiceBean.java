package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.CollectionManager;
import org.tutoring.api.repo.CollectionManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;

@Transactional(propagation = Propagation.SUPPORTS)
public class CollectionManagerServiceBean implements CollectionManagerService {

    @Autowired
    private CollectionManagerRepository collectionManagerRepository;

    @Override
    public Collection<CollectionManager> viewAll() throws InvalidDataException {

        try {
            return collectionManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public CollectionManager findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException {

        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return collectionManagerRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CollectionManager create(CollectionManager aCollectionManager) throws InvalidDataException, NullDataException, DatabaseUpdateException {
        if (null == aCollectionManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return collectionManagerRepository.save(aCollectionManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CollectionManager update(CollectionManager aCollectionManager) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aCollectionManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aCollectionManager.getFileId()) != null) {
                return collectionManagerRepository.save(aCollectionManager);
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
            if(findOne(id).getFileId() != null){
                collectionManagerRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}