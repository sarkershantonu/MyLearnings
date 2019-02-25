package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.AudioManager;
import org.tutoring.api.repo.AudioManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;
@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class AudioManagerServiceBean implements AudioManagerService {

    @Autowired
    private AudioManagerRepository audioManagerRepository;

    @Override
    public Collection<AudioManager> viewAll() throws InvalidDataException {
        try {
            return audioManagerRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public AudioManager findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException {

        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return audioManagerRepository.getOne(id);
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public AudioManager create(AudioManager aAudioManager) throws NullDataException, DatabaseUpdateException {

        if (null == aAudioManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return audioManagerRepository.save(aAudioManager);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public AudioManager update(AudioManager aAudioManager) throws NullDataException, InvalidDataException, DatabaseUpdateException {
        if (null == aAudioManager) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aAudioManager.getId()) != null) {
                return audioManagerRepository.save(aAudioManager);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public long delete(Long id) throws NullDataException, InvalidInputException, DatabaseUpdateException {
        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if (findOne(id).getId() != null) {
                audioManagerRepository.deleteById(id);
                return id;
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}