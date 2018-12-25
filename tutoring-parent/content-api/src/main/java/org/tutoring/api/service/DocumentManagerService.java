package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.DocumentManager;

import java.util.Collection;

public interface DocumentManagerService {

    Collection<DocumentManager> viewAll();
    DocumentManager findOne(Long id) throws NullDataException, InvalidDataException;
    DocumentManager create(DocumentManager aDocumentManager) throws InvalidDataException, NullDataException;
    DocumentManager update(DocumentManager aDocumentManager) throws NullDataException, InvalidDataException;
    Long delete(Long id) throws InvalidDataException, NullDataException;

}
