package org.tutoring.api.service;

import org.tutoring.api.model.ImageManager;

import java.util.Collection;

public interface ImageManagerService {

    Collection<ImageManager> viewAll();
    ImageManager findOne(Long id);
    ImageManager create(ImageManager aImageManager);
    ImageManager update(ImageManager aImageManager);
    Long delete(Long id);

}
