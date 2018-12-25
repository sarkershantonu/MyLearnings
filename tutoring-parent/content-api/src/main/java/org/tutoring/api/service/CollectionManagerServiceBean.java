package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.CollectionManager;
import org.tutoring.api.repo.CollectionManagerRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
public class CollectionManagerServiceBean implements CollectionManagerService {

    @Autowired
    private CollectionManagerRepository CollectionManagerRepository;

    @Override
    public Collection<CollectionManager> viewAll() {
        return CollectionManagerRepository.findAll();
    }

    @Override
    public CollectionManager findOne(Long id) throws NullDataException {

        if(null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        return CollectionManagerRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CollectionManager create(CollectionManager aCollectionManager) throws InvalidDataException, NullDataException {
        if (null == aCollectionManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aCollectionManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        return  CollectionManagerRepository.save(aCollectionManager);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public CollectionManager update(CollectionManager aCollectionManager) throws NullDataException, InvalidDataException {
        if (null == aCollectionManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aCollectionManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return CollectionManagerRepository.save(aCollectionManager);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException {
        if(null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        CollectionManagerRepository.deleteById(id);
        return id;

    }
}