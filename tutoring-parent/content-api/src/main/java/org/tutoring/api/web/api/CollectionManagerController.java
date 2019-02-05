package org.tutoring.api.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.ErrorMessage;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.model.CollectionManager;
import org.tutoring.api.service.CollectionManagerService;
import org.tutoring.api.web.BaseController;

import java.util.Collection;

public class CollectionManagerController extends BaseController{
    @Autowired
    CollectionManagerService service;

    @RequestMapping(value = "/api/collectionManager", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<CollectionManager>> viewAll() throws InvalidDataException {
        return new ResponseEntity<Collection<CollectionManager>>(service.viewAll(), HttpStatus.OK);

    }

    @RequestMapping(value = "/api/collectionManager/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    CollectionManager findOne(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException {

        if(id != null) {
            if(id <= 0){
                throw new InvalidInputException(APIMessages.ID_NOT_PRESENT);
            }
            else {
                return service.findOne(id);
            }
        }
        else{
             throw new InvalidInputException(APIMessages.DATA_NULL);
        }
    }



    @RequestMapping(value = "/api/collectionManager",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CollectionManager create(@RequestBody CollectionManager collectionManager ) throws  NullDataException, DatabaseUpdateException  {

        if(collectionManager.isValid()) {
            return service.create(collectionManager);
        }
        else {
            throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
        }
    }


    CollectionManager update(@RequestBody CollectionManager collectionManager, @PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {

        if (id == null) {
            throw new InvalidInputException(APIMessages.ID_NULL);
        }

        else {
            if (service.findOne(id) != null) {
               return service.update(collectionManager);
            } else {
                throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
            }
        }
    }

    @RequestMapping(
            value = "api/audioManager/{id}",
            method = RequestMethod.DELETE
    )

    public Long delete(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {
        if(id==null ){
            throw new InvalidInputException(APIMessages.ID_NULL);
        }
        else {
            if (service.findOne(id) == null) {
                throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
            }

            service.delete(id);

            return id;
        }

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    ErrorMessage exceptionHandlerInvalidInput(InvalidInputException e)
    {
        return new ErrorMessage("400 ",e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    ErrorMessage exceptionHandlerInvalidData(InvalidDataException e)
    {
        return new ErrorMessage("400 ",e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    ErrorMessage exceptionHandlerNullData(NullDataException e)
    {
        return new ErrorMessage("404 ",e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    ErrorMessage exceptionHandlerDatabaseUpdateFailure(DatabaseUpdateException e)
    {
        return new ErrorMessage("500",e.getMessage());
    }



}
