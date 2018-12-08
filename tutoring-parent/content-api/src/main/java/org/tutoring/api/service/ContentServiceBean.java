package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tutoring.api.model.Content;
import org.tutoring.api.repo.ContentRepository;

import java.util.Collection;

public class ContentServiceBean implements ContentService {

    @Autowired
    private ContentRepository ContentRepository;

    @Override
    public Collection<Content> viewAll() {
        return ContentRepository.findAll();
    }

    @Override
    public Content findOne(Long id) {
        return null;
    }

    @Override
    public Content create(Content aContent) {
        return null;
    }

    @Override
    public Content update(Content aContent) {
        return null;
    }

    @Override
    public Long delete(Long id) {
        return null;
    }
}
