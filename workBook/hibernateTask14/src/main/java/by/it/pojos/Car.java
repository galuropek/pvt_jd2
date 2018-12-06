package by.it.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//@NoArgsConstructor
//@AllArgsConstructor
@Data
@EqualsAndHashCode
@Entity
public class Car implements Serializable {

    private static final long serialVersionUID = -4391652778167283801L;
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String mark;
    @Column
    private String model;

    public Car(Integer id, String mark, String model) {
        this.id = id;
        this.mark = mark;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMark(String mark) {
        mark = mark;
    }

    public void setModel(String model) {
        model = model;
    }

}
