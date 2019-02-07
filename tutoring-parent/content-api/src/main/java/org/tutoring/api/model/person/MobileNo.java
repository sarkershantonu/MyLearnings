package org.tutoring.api.model.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class MobileNo {
    @Id
    @GeneratedValue
    private Long id;
    private String countryCode;
    private String areaCode;
    private String no;
    
}
