package io.swagger.dao;

import io.swagger.model.Customer;
import io.swagger.model.PartyRef;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseDaoImpl<T> {

    public List<T> find() {
        return List.of(testData("1"), testData("2"), testData("3"));
    }

    public boolean add(List<T> items) {
        return false;
    }

    private T testData(String prefix) {
        Customer customer = new Customer();

        customer.setId(prefix);
        customer.setName("Name" + prefix);
        customer.setStatus("Status" + prefix);
        return (T) customer;
    }
}
