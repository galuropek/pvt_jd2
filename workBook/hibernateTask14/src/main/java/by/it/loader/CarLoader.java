package by.it.loader;

import by.it.pojos.Car;
import by.it.util.HibernateUtil;

import javax.persistence.EntityManager;

public class CarLoader {
    public static void main(String[] args) {
        Car car = new Car(null, "Audi", "A4");
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(car);
        em.getTransaction().commit();
        HibernateUtil.close();
    }
}
