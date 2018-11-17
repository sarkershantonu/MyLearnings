package org.tutoring.api.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tutoring.api.model.Course;
import org.tutoring.api.service.CourseService;
import org.tutoring.api.web.BaseController;

import java.util.Collection;

@Controller
public class CourseController extends BaseController {

    @Autowired
    CourseService service;

    @RequestMapping(
            value = "/api/viewAllCourses",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Collection<Course>> getAllCourse(){

        return null;
    }
}
