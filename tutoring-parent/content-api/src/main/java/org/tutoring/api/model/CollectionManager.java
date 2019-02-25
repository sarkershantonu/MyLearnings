package org.tutoring.api.model;

import lombok.Data;
import org.tutoring.api.emums.CollectionFormat;

import javax.persistence.*;

@Entity
@Data
public class CollectionManager {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    @Enumerated(EnumType.STRING)
    private CollectionFormat collectionFormat;

    public boolean isValid() {

        if (fileId <= 0 || filePath == null || filePath.isEmpty() || collectionFormat == null ) {
            return false;
        }
        return true;
    }
}