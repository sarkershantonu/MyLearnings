package org.tutoring.api.service;

import org.tutoring.api.model.History;

import java.util.Collection;

public interface HistoryService {

    Collection<History> viewAll();
    History findOne(Long id);
    History create(History aHistory);
    History update(History aHistory);
    Long delete(Long id);

}
