package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.VideoManager;
import org.tutoring.api.repo.VideoManagerRepository;

import java.util.Collection;


public class VideoManagerServiceBean implements VideoManagerService {

    @Autowired
    private VideoManagerRepository videoManagerRepository;

    @Override
    public Collection<VideoManager> viewAll() {
        return videoManagerRepository.findAll();
    }

    @Override
    public VideoManager findOne(Long id) throws NullDataException, InvalidDataException {

        if (null == id){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return videoManagerRepository.getOne(id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public VideoManager create(VideoManager aVideoManager) throws InvalidDataException, NullDataException {

        if (null == aVideoManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aVideoManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return videoManagerRepository.save(aVideoManager);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public VideoManager update(VideoManager aVideoManager) throws NullDataException, InvalidDataException {

        if (null == aVideoManager){
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aVideoManager.isValid()){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return videoManagerRepository.save(aVideoManager);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws NullDataException, InvalidDataException {

        if (id == null){
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <=0 ){
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        videoManagerRepository.deleteById(id);
        return id;
    }
}
