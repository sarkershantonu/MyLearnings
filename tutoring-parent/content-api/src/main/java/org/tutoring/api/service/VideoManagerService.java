package org.tutoring.api.service;

import org.tutoring.api.model.VideoManager;

import java.util.Collection;

public interface VideoManagerService {

    Collection<VideoManager> viewAll();
    VideoManager findOne(Long id);
    VideoManager create(VideoManager aVideoManager);
    VideoManager update(VideoManager aVideoManager);
    Long delete(Long id);

}
