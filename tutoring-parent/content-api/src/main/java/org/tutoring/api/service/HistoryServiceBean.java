package org.tutoring.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.History;
import org.tutoring.api.repo.HistoryRepository;

import java.util.Collection;

import static org.tutoring.api.errors.APIMessages.*;

@Transactional(propagation = Propagation.SUPPORTS)
public class HistoryServiceBean implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public Collection<History> viewAll() throws InvalidDataException {
        try {
            return historyRepository.findAll();
        } catch (Exception e) {
            throw new InvalidDataException(NO_RESULT);
        }
    }

    @Override
    public History findOne(Long id) throws NullDataException, InvalidDataException, InvalidInputException {
        if (null == id) {
            throw new NullDataException(APIMessages.ID_NULL);
        }
        if (id < 1) {
            throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
        }

        try {
            return historyRepository.getOne(id);
        }catch (Exception e){
            throw new InvalidDataException(NO_RESULT + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public History create(History aHistory) throws InvalidDataException, NullDataException, DatabaseUpdateException {

        if (null == aHistory) {
            throw new NullDataException(APIMessages.INVALID_DATA);
        }

        try {
            return historyRepository.save(aHistory);
        } catch (
                Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public History update(History aHistory) throws InvalidDataException, NullDataException, DatabaseUpdateException {

        if (null == aHistory) {
            throw new NullDataException(DATA_NULL);
        }
        try {
            if (findOne(aHistory.getId()) != null) {
                return historyRepository.save(aHistory);
            } else {
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Long delete(Long id) throws InvalidDataException, NullDataException, DatabaseUpdateException {

        if (null == id) {
            throw new NullDataException(ID_NULL);
        }

        try {
            if(findOne(id).getId() != null){
                historyRepository.deleteById(id);
                return id;
            }else{
                throw new InvalidDataException(ID_NOT_PRESENT);
            }
        } catch (Exception e) {
            throw new DatabaseUpdateException(DATABASE_UPDATE_FAIL + e.getMessage());
        }
    }
}
