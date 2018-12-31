package org.tutoring.api.service;

import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.ImageManager;

import java.util.Collection;

public interface ImageManagerService {

    Collection<ImageManager> viewAll() throws InvalidDataException;
    ImageManager findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException;
    ImageManager create(ImageManager aImageManager) throws NullDataException, InvalidDataException, DatabaseUpdateException;
    ImageManager update(ImageManager aImageManager) throws InvalidDataException, NullDataException, DatabaseUpdateException;
    Long delete(Long id) throws NullDataException, InvalidDataException, DatabaseUpdateException;

}
