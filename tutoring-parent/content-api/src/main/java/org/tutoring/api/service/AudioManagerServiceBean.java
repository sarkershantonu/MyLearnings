package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.AudioManager;
import org.tutoring.api.repo.AudioManagerRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;

@Transactional(propagation = Propagation.SUPPORTS)
public class AudioManagerServiceBean implements AudioManagerService {

    @Autowired
    private AudioManagerRepository audioManagerRepository;

    @Override
    public Collection<AudioManager> viewAll() {
        return audioManagerRepository.findAll();
    }

    @Override
    public AudioManager findOne(Long id) throws NullDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }
        return audioManagerRepository.getOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public AudioManager create(AudioManager aAudioManager) throws NullDataException {

        if (null == aAudioManager) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }
        if (!aAudioManager.isValid()) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        return audioManagerRepository.save(aAudioManager);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public AudioManager update(AudioManager aAudioManager) throws NullDataException, InvalidDataException {
        if (null == aAudioManager) {
            throw new NullDataException(DATA_NULL);
        }
        if (!aAudioManager.isValid()) {
            throw new InvalidDataException(INVALID_DATA);
        }

        return audioManagerRepository.save(aAudioManager);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public long delete(Long id) throws NullDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        audioManagerRepository.deleteById(id);
        return id;
    }
}