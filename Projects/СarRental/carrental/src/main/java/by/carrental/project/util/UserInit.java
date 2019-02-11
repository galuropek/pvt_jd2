package by.carrental.project.util;

import by.carrental.project.model.Address;
import by.carrental.project.model.User;
import by.carrental.project.model.UserDetails;

public class UserInit {

    public static User init(String suffix) {
        User user = new User();
        user.setLogin("Login" + suffix);
        user.setPassword("Password" + suffix);
        user.setDetails(initUserDetails(suffix));
        return user;
    }

    private static UserDetails initUserDetails(String suffix) {
        UserDetails details = new UserDetails();
        details.setFirstName("Name" + suffix);
        details.setLastName("LastName" + suffix);
        details.setAddress(initAddress(suffix));
        return details;
    }

    private static Address initAddress(String suffix) {
        Address address = new Address();
        address.setCity("City" + suffix);
        address.setStreet("Street" + suffix);
        address.setHouseNumber("HouseNumber" + suffix);
        address.setApartmentNumber("ApartmentNumber" + suffix);
        return address;
    }
}
