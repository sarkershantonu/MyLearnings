package org.tutoring.api.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.tutoring.api.errors.APIMessages;
import org.tutoring.api.errors.ErrorMessage;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.FileManager;
import org.tutoring.api.service.FileManagerService;
import org.tutoring.api.web.BaseController;

import java.util.Collection;

//todo rumki
@Controller
public class FileManagerController extends BaseController {

    @Autowired
    FileManagerService service;

    @RequestMapping(value = "/api/fileManager",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public Collection<FileManager> getAll() throws InvalidDataException {

        if(service.viewAll() == null) {
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        else {
            return service.viewAll();
        }
    }

    @RequestMapping(
            value = "/api/fileManager/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FileManager get(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException {

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

    @RequestMapping(
            value = "/api/fileManager",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public FileManager create(@RequestBody FileManager fileManager) throws InvalidDataException, DatabaseUpdateException, NullDataException {

        if(fileManager.getFileManagerId() <=0 || fileManager.getFileId() == null ) {
            throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
        }
        else{
            return service.create(fileManager);
        }
    }

    @RequestMapping(
            value = "/api/fileManager/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public FileManager update(@RequestBody FileManager fileManager, @PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {

        if (id == null) {
            throw new InvalidInputException(APIMessages.ID_NULL);
        }

        else {
            if (service.findOne(id) != null) {
                return service.update(fileManager);
            } else {
                throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
            }
        }
    }

    @RequestMapping(
            value = "/api/fileManager/{id}",
            method = RequestMethod.DELETE
    )

    public long  delete(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {
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
