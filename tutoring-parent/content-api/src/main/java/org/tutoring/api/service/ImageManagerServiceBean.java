package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.ImageManager;
import org.tutoring.api.repo.ImageManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;

@Transactional(propagation = Propagation.SUPPORTS)
public class ImageManagerServiceBean implements ImageManagerService {

    @Autowired
    private ImageManagerRepository imageManagerRepository;

    @Override
    public Collection<ImageManager> viewAll() throws InvalidDataException {
        try {
            return imageManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public ImageManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return imageManagerRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ImageManager create(ImageManager aImageManager) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aImageManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return imageManagerRepository.save(aImageManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public ImageManager update(ImageManager aImageManager) throws InvalidDataException, NullDataException, DatabaseUpdateException {
        if (null == aImageManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aImageManager.getFileId()) != null) {
                return imageManagerRepository.save(aImageManager);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getFileId() != null){
                imageManagerRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
