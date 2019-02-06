package org.tutoring.api.model.person;

import lombok.Data;

@Data
public class PostalAddress {
    private String streetNo;
    private String streetName;
    private String apartmentNo;
    private String zip_postBox;
    private String country;
    private String state;
    private String division;

}
