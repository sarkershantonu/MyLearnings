package org.tutoring.api.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.AudioManager;
import org.tutoring.api.service.AudioManagerService;
import org.tutoring.api.web.BaseController;

import java.util.Collection;

public class AudioManagerController extends BaseController {

    @Autowired
    AudioManagerService service;

    @RequestMapping(
            value = "/api/audioManager",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<AudioManager>> getAll() throws InvalidDataException {
        return new ResponseEntity<Collection<AudioManager>>(service.viewAll(), HttpStatus.OK);

    }

    @RequestMapping(
            value = "/api/audioManager/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    ResponseEntity<AudioManager> get(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException {
       AudioManager audioManager = service.findOne(id);
       return new ResponseEntity<AudioManager>(audioManager,HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/audioManager",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<AudioManager> create(@RequestBody AudioManager audioManager ) throws NullDataException, DatabaseUpdateException {
        AudioManager returnValue = service.create(audioManager);

        return new ResponseEntity<>(returnValue,HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/api/audioManager/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<AudioManager> update(@RequestBody AudioManager audioManager, @PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {

        if(id == null ){
            return new ResponseEntity<AudioManager>(HttpStatus.BAD_REQUEST);
        }

        if(id != audioManager.getId()){
            return new ResponseEntity<AudioManager>(HttpStatus.BAD_REQUEST);
        }

        AudioManager returnValue = service.findOne(id);

        if(returnValue != null){
            return new ResponseEntity<AudioManager>(service.update(returnValue),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<AudioManager>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "api/audioManager/{id}",
            method = RequestMethod.DELETE
    )

    public ResponseEntity<AudioManager> delete(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {
        if(id==null ){
            return new ResponseEntity<AudioManager>(HttpStatus.BAD_REQUEST);
        }

        AudioManager userFound = service.findOne(id);
        if(userFound == null){
            return new ResponseEntity<AudioManager>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        service.delete(id);

        return new ResponseEntity<AudioManager>(HttpStatus.NO_CONTENT);

    }
}
