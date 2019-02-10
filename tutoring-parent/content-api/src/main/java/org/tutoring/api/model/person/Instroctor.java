package org.tutoring.api.model.person;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Instroctor {
    @Id
    @GeneratedValue
    private Long id;
//    private PersonName name;
    @OneToOne
    private MobileNo mobileNo;
    @OneToOne
    @JoinColumn(name="id")
    private EmailNo emailNo;
    @ManyToOne
    private PostalAddress address;

}
