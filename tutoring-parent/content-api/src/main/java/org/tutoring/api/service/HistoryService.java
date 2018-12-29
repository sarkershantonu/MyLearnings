package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.History;

import java.util.Collection;

public interface HistoryService {

    Collection<History> viewAll();
    History findOne(Long id) throws NullDataException, InvalidDataException;
    History create(History aHistory) throws InvalidDataException, NullDataException;
    History update(History aHistory) throws InvalidDataException, NullDataException;
    Long delete(Long id) throws InvalidDataException, NullDataException;

}
