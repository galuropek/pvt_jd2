package by.pvt.dao;

import by.pvt.pojo.Address;
import by.pvt.pojo.Company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompanyDaoImlTest {

    DaoImpl<Company> companyDao;

    @Before
    public void setUp() {
        companyDao = new DaoImpl<>(Company.class);
    }

    @Test
    public void saveOrUpdate() {
        Company company = new Company();
        company.setCompanyName("Romashka");
        company.setSiteUrl("www.romashka.by");

        company.setHomeAddress(
                new Address("Minsk", "Kazinca", "1", 2)
        );

        company.setLegalAddress(
                new Address("Minsk", "Romanovskaya Sloboda", "1", 2)
        );

        Company company2 = companyDao.saveOrUpdate(company);
        assertNotNull(company2);
        assertEquals(company2, company);
        assertEquals(company2.getLegalAddress(), company.getLegalAddress());

        System.out.println("Company ID: " + company.getId());
    }

    @Test
    public void updateAddress() {
        Company company = companyDao.load(1L);
        company.getHomeAddress().setCity("Vitebsk");
        companyDao.saveOrUpdate(company);

        assertEquals("Vitebsk", company.getHomeAddress().getCity());
    }

    @Test
    public void delete(){
        companyDao.delete(companyDao.load(1L).getId());

        assertNull(companyDao.find(1L));
    }

    public void tearDown() {
        companyDao = null;
    }
}
