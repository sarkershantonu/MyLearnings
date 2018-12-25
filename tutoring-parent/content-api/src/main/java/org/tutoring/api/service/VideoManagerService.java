package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.VideoManager;

import java.util.Collection;

public interface VideoManagerService {

    Collection<VideoManager> viewAll();
    VideoManager findOne(Long id) throws NullDataException, InvalidDataException;
    VideoManager create(VideoManager aVideoManager) throws InvalidDataException, NullDataException;
    VideoManager update(VideoManager aVideoManager) throws NullDataException, InvalidDataException;
    Long delete(Long id) throws NullDataException, InvalidDataException;

}
