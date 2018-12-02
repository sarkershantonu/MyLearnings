package org.tutoring.api.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String username;
    private String SubscriptionStatus;
    private String UserPaymentInfo;

}
