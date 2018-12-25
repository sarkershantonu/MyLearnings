package org.tutoring.api.service;

import com.sun.jnlp.ApiDialog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Content;
import org.tutoring.api.repo.ContentRepository;
import org.tutoring.api.repo.CourseRepository;

import java.util.Collection;
@Transactional(propagation = Propagation.SUPPORTS)
public class ContentServiceBean implements ContentService {

    @Autowired
    private ContentRepository ContentRepository;

    @Override
    public Collection<Content> viewAll() {
        return ContentRepository.findAll();
    }

    @Override
    public Content findOne(Long id) throws NullDataException {
        if(null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        return ContentRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Content create(Content aContent) throws NullDataException, InvalidDataException {
         if(null == aContent){
             throw new NullDataException(APIMessages.DATA_NULL);
         }
         if(!aContent.isValid()){
             throw new InvalidDataException(APIMessages.INVALID_DATA);
         }

        return ContentRepository.save(aContent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Content update(Content aContent) throws NullDataException, InvalidDataException {
        if (null == aContent){
            throw new  NullDataException(APIMessages.DATA_NULL);
        }

        if(!aContent.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        return ContentRepository.save(aContent);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException {
        if(null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        ContentRepository.deleteById(id);
        return id;
    }
}
