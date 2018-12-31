package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.DocumentManager;

import java.util.Collection;

public interface DocumentManagerService {

    Collection<DocumentManager> viewAll() throws InvalidDataException;
    DocumentManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    DocumentManager create(DocumentManager aDocumentManager) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    DocumentManager update(DocumentManager aDocumentManager) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Long delete(Long id) throws InvalidDataException, NullDataException, DatabaseUpdateException;

}
