package io.swagger.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BasePojo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(strategy = "uuid", name = "system-uuid")
    private String id;
}
