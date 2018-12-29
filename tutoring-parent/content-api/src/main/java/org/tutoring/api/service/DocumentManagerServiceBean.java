package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.DocumentManager;
import org.tutoring.api.repo.DocumentManagerRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
public class DocumentManagerServiceBean implements DocumentManagerService {

    @Autowired
    private DocumentManagerRepository documentManagerRepository;

    @Override
    public Collection<DocumentManager> viewAll() {
        return documentManagerRepository.findAll();
    }

    @Override
    public DocumentManager findOne(Long id) throws NullDataException, InvalidDataException {

        if (null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return documentManagerRepository.getOne(id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DocumentManager create(DocumentManager aDocumentManager) throws InvalidDataException, NullDataException {
        if (null == aDocumentManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aDocumentManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return documentManagerRepository.save(aDocumentManager);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public DocumentManager update(DocumentManager aDocumentManager) throws NullDataException, InvalidDataException {

        if (null == aDocumentManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aDocumentManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return documentManagerRepository.save(aDocumentManager);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws InvalidDataException, NullDataException {
        if (id == null){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        documentManagerRepository.deleteById(id);
        return id;
    }
}
