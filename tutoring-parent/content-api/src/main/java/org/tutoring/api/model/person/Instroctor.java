package org.tutoring.api.model.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Instroctor {
    @Id
    @GeneratedValue
    private Long id;
    private PersonName name;
    private MobileNo mobileNo;
    private EmailNo emailNo;
    private PostalAddress address;

}
