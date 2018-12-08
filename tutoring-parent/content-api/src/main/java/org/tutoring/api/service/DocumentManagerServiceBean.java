package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.DocumentManager;
import org.tutoring.api.repo.DocumentManagerRepository;

import java.util.Collection;

public class DocumentManagerServiceBean implements DocumentManagerService {

    @Autowired
    private DocumentManagerRepository DocumentManagerRepository;

    @Override
    public Collection<DocumentManager> viewAll() {
        return DocumentManagerRepository.findAll();
    }

    @Override
    public DocumentManager findOne(Long id) {
        return null;
    }

    @Override
    public DocumentManager create(DocumentManager aDocumentManager) {
        return null;
    }

    @Override
    public DocumentManager update(DocumentManager aDocumentManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
