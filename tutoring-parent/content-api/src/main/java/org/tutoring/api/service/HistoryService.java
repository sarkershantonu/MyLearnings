package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.History;

import java.util.Collection;

public interface HistoryService {

    Collection<History> viewAll() throws InvalidDataException;
    History findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    History create(History aHistory) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    History update(History aHistory) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    Long delete(Long id) throws InvalidDataException, NullDataException, DatabaseUpdateException;

}
