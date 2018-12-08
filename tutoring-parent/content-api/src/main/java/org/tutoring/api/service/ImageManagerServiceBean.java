package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.ImageManager;
import org.tutoring.api.repo.ImageManagerRepository;

import java.util.Collection;

public class ImageManagerServiceBean implements ImageManagerService {

    @Autowired
    private ImageManagerRepository ImageManagerRepository;

    @Override
    public Collection<ImageManager> viewAll() {
        return ImageManagerRepository.findAll();
    }

    @Override
    public ImageManager findOne(Long id) {
        return null;
    }

    @Override
    public ImageManager create(ImageManager aImageManager) {
        return null;
    }

    @Override
    public ImageManager update(ImageManager aImageManager) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
