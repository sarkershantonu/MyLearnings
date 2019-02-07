package org.tutoring.api.model.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class PostalAddress {
    @Id
    @GeneratedValue
    private Long id;
    private String streetNo;
    private String streetName;
    private String apartmentNo;
    private String zip_postBox;
    private String country;
    private String state;
    private String division;

}
