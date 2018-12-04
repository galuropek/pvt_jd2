package by.it.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = -4391652778167283801L;
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String Mark;
    @Column
    private String Model;

    public Integer getId() {
        return id;
    }

    public String getMark() {
        return Mark;
    }

    public String getModel() {
        return Model;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMark(String mark) {
        Mark = mark;
    }

    public void setModel(String model) {
        Model = model;
    }

}
