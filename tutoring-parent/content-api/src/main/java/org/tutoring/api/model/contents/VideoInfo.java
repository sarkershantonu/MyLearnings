package org.tutoring.api.model.contents;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by SSarker on 10/27/2018.
 */
@Entity
@Data
public class VideoInfo extends RawFile {
    @Id
    @GeneratedValue
    private Long id;

}
