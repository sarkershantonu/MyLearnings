package org.tutoring.api.service;

import org.tutoring.api.model.ImageManager;

import java.util.Collection;

public interface ImageManagerService {

    Collection<ImageManager> viewAll();
    ImageManager findOne(Long id);
    ImageManager create(ImageManager aHistory);
    ImageManager update(ImageManager aHistory);
    Long delete(Long id);

}
