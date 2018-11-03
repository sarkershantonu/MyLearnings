package org.tutoring.api.model;


import org.tutoring.api.model.person.Instroctor;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
    private Long id;
    private String title;
    private String description;
    private Long noOfClasses;
    private List<Instroctor> instroctor;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNoOfClasses() {
        return noOfClasses;
    }

    public void setNoOfClasses(Long noOfClasses) {
        this.noOfClasses = noOfClasses;
    }

    public List<Instroctor> getInstroctor() {
        return instroctor;
    }

    public void setInstroctor(List<Instroctor> instroctor) {
        this.instroctor = instroctor;
    }
}
