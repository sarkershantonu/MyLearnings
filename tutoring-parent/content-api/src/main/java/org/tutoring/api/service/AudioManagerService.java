package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.AudioManager;

import java.util.Collection;

public interface AudioManagerService {
    Collection<AudioManager> viewAll() throws InvalidDataException;
    AudioManager findOne(Long id) throws NullDataException, InvalidInputException, InvalidDataException;
    AudioManager create(AudioManager aAudioManager) throws NullDataException, DatabaseUpdateException;
    AudioManager update(AudioManager aAudioManager) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    long delete(Long id) throws NullDataException, InvalidInputException, DatabaseUpdateException;
}
