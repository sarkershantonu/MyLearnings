package org.tutoring.api.model.person;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class EmailNo {

    @Id
    @GeneratedValue
    private Long id;
    private String emailAddress;
    private String domain;

    public EmailNo(String completeEmail) {
        this.emailAddress = completeEmail.substring(0,completeEmail.indexOf("@")+1);
        this.domain = completeEmail.substring(completeEmail.indexOf("@")+1);
    }
    public String getEmail(){return emailAddress +"@"+domain;}
}
