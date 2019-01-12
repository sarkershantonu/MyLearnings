package org.tutoring.api.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.User;
import org.tutoring.api.service.UserService;
import org.tutoring.api.web.BaseController;

import java.util.Collection;

//todo rumki
public class UserController extends BaseController {

    @Autowired
    UserService service;

    @RequestMapping(
            value = "/api/allUser",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    public ResponseEntity<Collection<User>> getAll() throws InvalidDataException {
        return new ResponseEntity<Collection<User>>(service.viewAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/allUser/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> get(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException {

        User user = service.findOne(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/allUser",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<User> create(@RequestBody User user) throws InvalidDataException, DatabaseUpdateException, NullDataException {

        User courseReturnValue = service.create(user) ;
        return new ResponseEntity<>(courseReturnValue, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/api/allUser/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    ResponseEntity<User> update(@RequestBody User user, @PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {

        if(id == null ){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        if(id != user.getId()){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        User userFound = service.findOne(id);

        if(user != null){
            return new ResponseEntity<User>(service.update(user),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/allUser/{id}",
            method = RequestMethod.DELETE
    )

    public ResponseEntity<User> delete(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {
        if(id==null ){
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        User userFound = service.findOne(id);
        if(userFound == null){
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        service.delete(id);

        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);

    }


}
