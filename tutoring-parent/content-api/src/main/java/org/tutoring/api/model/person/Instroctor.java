package org.tutoring.api.model.person;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Instroctor {
    @Id
    @GeneratedValue
    private Long id;
    private PersonName name;
    @OneToMany
    private MobileNo mobileNo;
    @OneToMany
    private EmailNo emailNo;
    @ManyToOne
    private PostalAddress address;

}
