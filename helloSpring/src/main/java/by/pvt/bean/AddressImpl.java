package by.pvt.bean;

import java.util.List;
import java.util.Map;

public class AddressImpl implements Address {

    private List<String> flats;

    private Map coordinats;

    public Map getCoordinats() {
        return coordinats;
    }

    public void setCoordinats(Map coordinats) {
        this.coordinats = coordinats;
    }

    public String getStreet() {
        return "Fish Street";
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
}
