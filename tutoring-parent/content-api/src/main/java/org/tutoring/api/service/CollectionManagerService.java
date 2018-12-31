package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.CollectionManager;

import java.util.Collection;

public interface CollectionManagerService {
    Collection<CollectionManager> viewAll() throws InvalidDataException;
    CollectionManager findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException;
    CollectionManager create(CollectionManager aCollectionManager) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    CollectionManager update(CollectionManager aCollectionManager) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, DatabaseUpdateException;


}
