package by.pvt.main;

import by.pvt.bean.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-config2.xml");

        PersonImpl person = (PersonImpl) applicationContext.getBean("person");

        System.out.println(person.getAddress().getStreet() + ", " +
                person.getAddress().getCity());

        System.out.println(person.getName() + " " +
                person.getSecondName());

        System.out.println("Flats: " + ((AddressImpl) person.getAddress()).getFlats());

        System.out.println("Coordinats: " + ((AddressImpl) person.getAddress()).getCoordinats());

        System.out.println("Home: " + ((AddressImpl) person.getAddress()).getHome());

        System.out.println("Street: " + ((AddressImpl) person.getAddress()).getStreet());

        System.out.println("Full address: " + person.getFullAddress());

        System.out.println("Zip code: " + ((AddressImpl) person.getAddress()).getZipCode());

        System.out.println("End of street: " + ((AddressImpl) person.getAddress()).isEndOfStreet());

        System.out.println("The same street: " + ((AddressImpl) person.getAddress()).isTheSaneStreet());

        Inhabitant inhabitant = (Inhabitant) ((ClassPathXmlApplicationContext) applicationContext).getBean("inhabitant");

        for (PersonImpl inhabitantPerson : inhabitant.getPersons()) {
            System.out.println("Name: " + inhabitantPerson.getName() + "S" + inhabitantPerson.getSecondName());
        }

        Manager manager = (Manager) ((ClassPathXmlApplicationContext) applicationContext).getBean("manager");

        System.out.println("Manager: " + manager.getName() + " " + manager.getSecondName()
                + " " + manager.getPerson().getFullAddress());

        FilterPerson filterPerson = (FilterPerson) applicationContext.getBean("filter");
        System.out.println("Filter: person=" + filterPerson.getPerson());

        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
