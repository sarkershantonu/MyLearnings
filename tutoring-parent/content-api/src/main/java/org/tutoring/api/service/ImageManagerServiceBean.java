package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.ImageManager;
import org.tutoring.api.repo.ImageManagerRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
public class ImageManagerServiceBean implements ImageManagerService {

    @Autowired
    private ImageManagerRepository imageManagerRepository;

    @Override
    public Collection<ImageManager> viewAll() {
        return imageManagerRepository.findAll();
    }

    @Override
    public ImageManager findOne(Long id) throws NullDataException, InvalidDataException {
        if (id == null){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return imageManagerRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ImageManager create(ImageManager aImageManager) throws NullDataException, InvalidDataException {
        if (null == aImageManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aImageManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return imageManagerRepository.save(aImageManager);


    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ImageManager update(ImageManager aImageManager) throws InvalidDataException, NullDataException {

        if (null == aImageManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aImageManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return imageManagerRepository.save(aImageManager);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, InvalidDataException {
        if (null == id ){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        imageManagerRepository.deleteById(id);
        return id;
    }
}
