package by.pvt.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AddressImpl implements Address {

    private List<String> flats;

    private Map coordinats;

    private Float home;

    private String street;

    private String zipCode;

    private boolean endOfStreet;

    private boolean theSaneStreet;

    Collection<String> inhabitans;

    public Collection<String> getInhabitans() {
        return inhabitans;
    }

    public void setInhabitans(Collection<String> inhabitans) {
        this.inhabitans = inhabitans;
    }

    public boolean isTheSaneStreet() {
        return theSaneStreet;
    }

    public void setTheSaneStreet(boolean theSaneStreet) {
        this.theSaneStreet = theSaneStreet;
    }

    public AddressImpl(Float home) {
        this.home = home;
    }

    public boolean isEndOfStreet() {
        return endOfStreet;
    }

    public void setEndOfStreet(boolean endOfStreet) {
        this.endOfStreet = endOfStreet;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Float getHome() {
        return home != null ? home : 25;
    }

    public void setHome(Float home) {
        this.home = home;
    }

    public Map getCoordinats() {
        return coordinats;
    }

    public void setCoordinats(Map coordinats) {
        this.coordinats = coordinats;
    }

    public String getStreet() {
        return street != null ? street : "Строителей ";
    }

    public String getCity() {
        return "Stambul";
    }

    public List<String> getFlats() {
        return flats;
    }

    public void setFlats(List<String> flats) {
        this.flats = flats;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Call post construct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Call pre destroy");
    }
}
