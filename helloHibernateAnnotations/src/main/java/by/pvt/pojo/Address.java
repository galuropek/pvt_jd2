package by.pvt.pojo;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String street;

    @Column
    private Integer zip;

    @Column
    private String houseNumber;

    @Column
    private int appartmentNumber;

    @Column
    private String officeNumber;

    public Address() {
    }

    public Address(String city, String street, String houseNumber, int appartmentNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.appartmentNumber = appartmentNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(int appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("country", country)
                .append("city", city)
                .append("appartmentNumber", appartmentNumber)
                .append("houseNumber", houseNumber)
                .append("officeNumber", officeNumber)
                .toString();
    }
}
