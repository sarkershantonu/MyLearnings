package org.tutoring.api.service;

import org.tutoring.api.model.Content;

import java.util.Collection;

public interface ContentService {
    Collection<Content> viewAll();
    Content findOne(Long id);
    Content create(Content aContent);
    Content update(Content aContent);
    Long delete(Long id);
}
