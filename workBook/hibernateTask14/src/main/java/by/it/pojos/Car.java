package by.it.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Car implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String Mark;
    @Column
    private String Model;

}
