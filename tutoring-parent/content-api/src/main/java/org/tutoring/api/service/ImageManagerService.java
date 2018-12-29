package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.ImageManager;

import java.util.Collection;

public interface ImageManagerService {

    Collection<ImageManager> viewAll();
    ImageManager findOne(Long id) throws NullDataException, InvalidDataException;
    ImageManager create(ImageManager aImageManager) throws NullDataException, InvalidDataException;
    ImageManager update(ImageManager aImageManager) throws InvalidDataException, NullDataException;
    Long delete(Long id) throws NullDataException, InvalidDataException;

}
