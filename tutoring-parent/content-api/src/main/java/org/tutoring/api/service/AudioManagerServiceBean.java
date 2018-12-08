package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.AudioManager;
import org.tutoring.api.repo.AudioManagerRepository;

import java.util.Collection;

public class AudioManagerServiceBean implements AudioManagerService {

    @Autowired
    private AudioManagerRepository AudioManagerRepository;

    @Override
    public Collection<AudioManager> viewAll() {
        return AudioManagerRepository.findAll();
    }

    @Override
    public AudioManager findOne(Long id) {
        return null;
    }

    @Override
    public AudioManager create(AudioManager aAudioManager) {
        return null;
    }

    @Override
    public AudioManager update(AudioManager aAudioManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}