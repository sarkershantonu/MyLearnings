package org.tutoring.api.model;


import lombok.Data;
import org.tutoring.api.model.person.Instroctor;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private Long noOfClasses;
    @OneToMany
    private List<Instroctor> instroctor;

}
