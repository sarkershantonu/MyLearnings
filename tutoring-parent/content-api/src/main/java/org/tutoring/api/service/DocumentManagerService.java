package org.tutoring.api.service;

import org.tutoring.api.model.DocumentManager;

import java.util.Collection;

public interface DocumentManagerService {

    Collection<DocumentManager> viewAll();
    DocumentManager findOne(Long id);
    DocumentManager create(DocumentManager aDocumentManager);
    DocumentManager update(DocumentManager aDocumentManager);
    Long delete(Long id);

}
