package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.VideoManager;

import java.util.Collection;

public interface VideoManagerService {

    Collection<VideoManager> viewAll() throws InvalidDataException;
    VideoManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    VideoManager create(VideoManager aVideoManager) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    VideoManager update(VideoManager aVideoManager) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, InvalidDataException, DatabaseUpdateException;

}
