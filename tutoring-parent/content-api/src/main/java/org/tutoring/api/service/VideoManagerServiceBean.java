package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.VideoManager;
import org.tutoring.api.repo.VideoManagerRepository;

import java.util.Collection;

public class VideoManagerServiceBean implements VideoManagerService {

    @Autowired
    private VideoManagerRepository VideoManagerRepository;

    @Override
    public Collection<VideoManager> viewAll() {
        return VideoManagerRepository.findAll();
    }

    @Override
    public VideoManager findOne(Long id) {
        return null;
    }

    @Override
    public VideoManager create(VideoManager aVideoManager) {
        return null;
    }

    @Override
    public VideoManager update(VideoManager aVideoManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
