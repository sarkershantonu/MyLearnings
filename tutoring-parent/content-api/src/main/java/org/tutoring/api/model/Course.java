package org.tutoring.api.model;


import lombok.Data;
import org.tutoring.api.model.person.Instroctor;

import java.util.List;
import javax.persistence.*;

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
//    @JoinColumn(name = "id")
    private List<Instroctor> instroctor;

}
