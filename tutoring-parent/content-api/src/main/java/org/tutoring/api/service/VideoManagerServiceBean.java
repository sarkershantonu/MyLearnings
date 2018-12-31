package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.VideoManager;
import org.tutoring.api.repo.VideoManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;


public class VideoManagerServiceBean implements VideoManagerService {

    @Autowired
    private VideoManagerRepository videoManagerRepository;

    @Override
    public Collection<VideoManager> viewAll() throws InvalidDataException {

        try {
            return videoManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public VideoManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return videoManagerRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public VideoManager create(VideoManager aVideoManager) throws InvalidDataException, NullDataException, DatabaseUpdateException {
        if (null == aVideoManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return videoManagerRepository.save(aVideoManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public VideoManager update(VideoManager aVideoManager) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aVideoManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aVideoManager.getFileId()) != null) {
                return videoManagerRepository.save(aVideoManager);
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
                videoManagerRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
