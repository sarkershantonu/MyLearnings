package org.tutoring.api.model.person;

import lombok.Data;

@Data
public class EmailNo {

    private String id;
    private String domain;

    public EmailNo(String completeEmail) {
        this.id = completeEmail.substring(0,completeEmail.indexOf("@")+1);
        this.domain = completeEmail.substring(completeEmail.indexOf("@")+1);
    }
    public String getEmail(){return id+"@"+domain;}
}
