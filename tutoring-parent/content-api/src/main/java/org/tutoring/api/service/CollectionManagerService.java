package org.tutoring.api.service;

import org.tutoring.api.model.CollectionManager;

import java.util.Collection;

public interface CollectionManagerService {
    Collection<CollectionManager> viewAll();
    CollectionManager findOne(Long id);
    CollectionManager create(CollectionManager aCollectionManager);
    CollectionManager update(CollectionManager aCollectionManager);
    Long delete(Long id);
}
