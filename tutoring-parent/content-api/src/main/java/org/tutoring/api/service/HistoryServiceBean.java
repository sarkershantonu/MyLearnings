package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.History;
import org.tutoring.api.repo.HistoryRepository;

import java.util.Collection;

@Transactional(propagation = Propagation.SUPPORTS)
public class HistoryServiceBean implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public Collection<History> viewAll() {
        return historyRepository.findAll();
    }

    @Override
    public History findOne(Long id) throws NullDataException, InvalidDataException {

        if (id == null) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <= 0) {
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return historyRepository.getOne(id);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public History create(History aHistory) throws InvalidDataException, NullDataException {

        if (null == aHistory) {
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aHistory.isValid()) {
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return historyRepository.save(aHistory);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public History update(History aHistory) throws InvalidDataException, NullDataException {

        if (null == aHistory) {
            throw new NullDataException(APIMessages.DATA_NULL);
        }
        if (!aHistory.isValid()) {
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        return historyRepository.save(aHistory);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws InvalidDataException, NullDataException {

        if (id == null) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id <= 0) {
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }

        historyRepository.deleteById(id);
        return id;
    }
}
