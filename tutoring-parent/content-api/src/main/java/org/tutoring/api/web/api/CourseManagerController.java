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
import org.tutoring.api.model.CourseManager;
import org.tutoring.api.service.CourseManagerService;
import org.tutoring.api.web.BaseController;

import java.util.Collection;

//todo rumki
@Controller
public class CourseManagerController extends BaseController {

    @Autowired
    CourseManagerService service;

    @RequestMapping(value = "/api/courseManager",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public Collection<CourseManager> getAll() throws InvalidDataException {

        if(service.viewAll() == null) {
            throw new InvalidDataException(APIMessages.INVALID_DATA);
        }
        else {
            return service.viewAll();
        }
    }

    @RequestMapping(
            value = "/api/courseManager/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CourseManager get(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException {

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
            value = "/api/courseManager",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public CourseManager create(@RequestBody CourseManager courseManager) throws InvalidDataException, DatabaseUpdateException, NullDataException {

        if(courseManager.getId() <=0 || courseManager.getCourseId() == null || courseManager.getUserId() == null || courseManager.getRoleId() == null) {
            throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
        }
        else{
            return service.create(courseManager);
        }
    }

    @RequestMapping(
            value = "/api/courseManager/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public CourseManager update(@RequestBody CourseManager courseManager, @PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {

        if (id == null) {
            throw new InvalidInputException(APIMessages.ID_NULL);
        }

        else {
            if (service.findOne(id) != null) {
                return service.update(courseManager);
            } else {
                throw new DatabaseUpdateException(APIMessages.DATABASE_UPDATE_FAIL);
            }
        }
    }

    @RequestMapping(
            value = "/api/courseManager/{id}",
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
