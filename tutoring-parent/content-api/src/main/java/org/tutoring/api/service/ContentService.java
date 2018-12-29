package org.tutoring.api.service;

import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Content;

import java.util.Collection;

public interface ContentService {
    Collection<Content> viewAll();
    Content findOne(Long id) throws NullDataException;
    Content create(Content aContent) throws NullDataException, InvalidDataException;
    Content update(Content aContent) throws NullDataException, InvalidDataException;
    Long delete(Long id) throws NullDataException;
}
