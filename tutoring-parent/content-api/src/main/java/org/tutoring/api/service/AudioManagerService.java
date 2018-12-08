package org.tutoring.api.service;

import org.tutoring.api.model.AudioManager;

import java.util.Collection;

public interface AudioManagerService {
    Collection<AudioManager> viewAll();
    AudioManager findOne(Long id);
    AudioManager create(AudioManager aAudioManager);
    AudioManager update(AudioManager aAudioManager);
    Long delete(Long id);
}
