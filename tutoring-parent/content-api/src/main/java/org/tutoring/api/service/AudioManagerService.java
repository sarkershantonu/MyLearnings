package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.AudioManager;

import java.util.Collection;

public interface AudioManagerService {
    Collection<AudioManager> viewAll();
    AudioManager findOne(Long id) throws NullDataException, InvalidInputException;
    AudioManager create(AudioManager aAudioManager) throws NullDataException;
    AudioManager update(AudioManager aAudioManager) throws NullDataException, InvalidDataException;
    long delete(Long id) throws NullDataException, InvalidInputException;
}
