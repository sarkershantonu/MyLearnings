package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.CollectionManager;

import java.util.Collection;

public interface CollectionManagerService {
    Collection<CollectionManager> viewAll();
    CollectionManager findOne(Long id) throws NullDataException;
    CollectionManager create(CollectionManager aCollectionManager) throws InvalidDataException, NullDataException;
    CollectionManager update(CollectionManager aCollectionManager) throws NullDataException, InvalidDataException;
    Long delete(Long id) throws NullDataException;


}
