package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.CollectionManager;
import org.tutoring.api.repo.CollectionManagerRepository;

import java.util.Collection;

public class CollectionManagerServiceBean implements CollectionManagerService {

    @Autowired
    private CollectionManagerRepository CollectionManagerRepository;

    @Override
    public Collection<CollectionManager> viewAll() {
        return CollectionManagerRepository.findAll();
    }

    @Override
    public CollectionManager findOne(Long id) {
        return null;
    }

    @Override
    public CollectionManager create(CollectionManager aCollectionManager) {
        return null;
    }

    @Override
    public CollectionManager update(CollectionManager aCollectionManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}