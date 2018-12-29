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
    private String subscriptionStatus;
    private String userPaymentInfo;

    public boolean isValid() {

        if (id == null || id <= 0
                || username == null || username.isEmpty()
                || subscriptionStatus == null || subscriptionStatus.isEmpty()
                || userPaymentInfo == null || userPaymentInfo.isEmpty()) {

            return false;
        }
        return true;
    }

}
