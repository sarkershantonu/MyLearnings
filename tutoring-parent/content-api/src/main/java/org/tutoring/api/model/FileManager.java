package org.tutoring.api.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class FileManager {

    @Id
    @GeneratedValue
    private Long fileManagerId;
    private Long  fileId;


}
