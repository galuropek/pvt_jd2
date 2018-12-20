package by.pvt.dao;

import by.pvt.pojo.Employee;
import by.pvt.pojo.Meeting;
import by.pvt.pojo.Status;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

import static org.junit.Assert.*;

public class MeetingDaoImplTest {

    DaoImpl<Meeting> meetingDao;

    DaoImpl<Employee> employeeDao;

    @Before
    public void setUp() {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        meetingDao = new DaoImpl<>(Meeting.class);
        employeeDao = new DaoImpl<>(Employee.class);

        lock.unlock();
    }

    @Test
    public void step1_createInstance() {

        Employee employee1 = createEmployee("1");
        employeeDao.saveOrUpdate(employee1);

        Employee employee2 = createEmployee("2");
        employeeDao.saveOrUpdate(employee2);

        Meeting meeting1 = createMeeting("1");
        meeting1.setAttendees(Set.of(employee1, employee2));
        meeting1.setOrganizer(employee1);

        meetingDao.saveOrUpdate(meeting1);

    }

    private Meeting createMeeting(String postfix) {
        Meeting meeting = new Meeting();
        meeting.setSubject("subject " + postfix);
        meeting.setStatus(Status.NEW);
        meeting.setDateTime(Calendar.getInstance().getTime());
        return meeting;
    }

    private Employee createEmployee(String postfix) {
        Employee employee = new Employee();
        employee.setFirstName("Name" + postfix);
        employee.setLastName("LastName" + postfix);
        return employee;
    }

    @Test
    public void step3_deleteMeetign() {
        meetingDao.delete(1L);
        assertNull(meetingDao.find(1L));
    }

    @Before
    public void tearDown() {

    }

}
