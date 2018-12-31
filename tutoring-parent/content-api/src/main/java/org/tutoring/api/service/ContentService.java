package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Content;

import java.util.Collection;

public interface ContentService {
    Collection<Content> viewAll() throws InvalidDataException;
    Content findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException;
    Content create(Content aContent) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Content update(Content aContent) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, DatabaseUpdateException;
}
