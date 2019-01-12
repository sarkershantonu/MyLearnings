package org.tutoring.api.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tutoring.api.errors.bll.DatabaseUpdateException;
import org.tutoring.api.errors.bll.InvalidDataException;
import org.tutoring.api.errors.bll.InvalidInputException;
import org.tutoring.api.errors.bll.NullDataException;
import org.tutoring.api.model.Course;
import org.tutoring.api.service.CourseService;
import org.tutoring.api.web.BaseController;

import javax.print.attribute.standard.Media;
import java.util.Collection;

//todo rumki
@Controller
public class CourseController extends BaseController {

    @Autowired
    CourseService service;

    @RequestMapping(
            value = "/api/viewAllCourses",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Course>> getAllCourse() throws InvalidDataException {
        return new ResponseEntity<Collection<Course>>(service.viewAll(), HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/viewAllCourses/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Course> get(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException {

        Course course = service.findOne(id);
        return new ResponseEntity<Course>(course,HttpStatus.OK);

    }

    @RequestMapping(
            value = "/api/viewAllCourses",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Course> create(@RequestBody Course couse) throws NullDataException, DatabaseUpdateException {

        Course courseReturnValue = service.create(couse);
        return new ResponseEntity<Course>(courseReturnValue,HttpStatus.CREATED);

    }

    @RequestMapping(
            value = "/api/viewAllCourses/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Course> update(@RequestBody Course course, @PathVariable("id") Long id) throws NullDataException, DatabaseUpdateException, InvalidInputException, InvalidDataException {

        if(id == null ){
            return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
        }

        if(id != course.getId()){
            return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
        }

        Course courseFound = service.findOne(id);
        if(courseFound != null ){
            return new ResponseEntity<Course>(service.update(course),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(
            value = "/api/viewAllCourses/{id}",
            method = RequestMethod.DELETE
    )

    public ResponseEntity<Course> delete(@PathVariable("id") Long id) throws InvalidDataException, InvalidInputException, NullDataException, DatabaseUpdateException {

        if(id==null ){
            return new ResponseEntity<Course>(HttpStatus.BAD_REQUEST);
        }
        Course courseFound  = service.findOne(id);

        if(courseFound == null){
            return new ResponseEntity<Course>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
