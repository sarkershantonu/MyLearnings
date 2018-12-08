package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.History;
import org.tutoring.api.repo.HistoryRepository;

import java.util.Collection;

public class HistoryServiceBean implements HistoryService {

    @Autowired
    private HistoryRepository HistoryRepository;

    @Override
    public Collection<History> viewAll() {
        return HistoryRepository.findAll();
    }

    @Override
    public History findOne(Long id) {
        return null;
    }

    @Override
    public History create(History aHistory) {
        return null;
    }

    @Override
    public History update(History aHistory) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
