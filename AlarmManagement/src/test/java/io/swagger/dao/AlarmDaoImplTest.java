package io.swagger.dao;

import io.swagger.configuration.AlarmInit;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.Alarm;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlarmDaoImplTest {

    @Resource
    AlarmDaoImpl alarmDao;

    @Test
    public void step1_save() {
        Alarm alarm1 = AlarmInit.init("1");
        alarmDao.save(alarm1);
        assertTrue(alarm1.getId() == 1L);
        assertEquals(alarm1.getAckUserId(), "AckUserId1");
        System.out.println("---> Print Alarm1:\n" + alarm1);

        assertEquals(alarm1.getComments().get(0).getComment(), "Comment1");
        assertNotNull(alarm1.getComments().get(0).getSystemId());

        assertEquals(alarm1.getCrossedThresholdInformation().getDirection(), "Direction1");
        assertNotNull(alarm1.getCrossedThresholdInformation().getThresholdId());

        assertEquals(alarm1.getParentAlarm().get(0).getHref(), "Href1");
        assertNotNull(alarm1.getParentAlarm().get(0).getId());

        assertEquals(alarm1.getCorrelatedAlarm().get(0).getHref(), "Href1");
        assertNotNull(alarm1.getCorrelatedAlarm().get(0).getId());

        assertEquals(alarm1.getAffectedService().get(0).getHref(), "Href1");
        assertNotNull(alarm1.getAffectedService().get(0).getId());

        assertEquals(alarm1.getAlarmedObject().getHref(), "Href1");
        assertNotNull(alarm1.getAlarmedObject().getId());
    }

    @Test
    public void step2_get() {
        Alarm alarm2 = AlarmInit.init("2");
        alarmDao.save(alarm2);
        assertTrue(alarm2.getId() == 2L);
        assertEquals(alarm2.getAckUserId(), "AckUserId2");
        System.out.println("---> Print Alarm2\n" + alarm2);

        assertEquals(alarm2.getComments().get(0).getComment(), "Comment1");
        assertNotNull(alarm2.getComments().get(0).getSystemId());

        assertEquals(alarm2.getCrossedThresholdInformation().getDirection(), "Direction2");
        assertNotNull(alarm2.getCrossedThresholdInformation().getThresholdId());

        assertEquals(alarm2.getParentAlarm().get(0).getHref(), "Href1");
        assertNotNull(alarm2.getParentAlarm().get(0).getId());

        assertEquals(alarm2.getCorrelatedAlarm().get(0).getHref(), "Href1");
        assertNotNull(alarm2.getCorrelatedAlarm().get(0).getId());

        assertEquals(alarm2.getAffectedService().get(0).getHref(), "Href1");
        assertNotNull(alarm2.getAffectedService().get(0).getId());

        assertEquals(alarm2.getAlarmedObject().getHref(), "Href2");
        assertNotNull(alarm2.getAlarmedObject().getId());
    }

    @Test
    public void step3_getAll() {
        Alarm alarm3 = AlarmInit.init("3");
        alarmDao.save(alarm3);

        Alarm alarm4 = AlarmInit.init("4");
        alarmDao.save(alarm4);

        List<Alarm> allAlarms = alarmDao.getAll();
        assertTrue(allAlarms.size() > 0);

        assertEquals(allAlarms.get(0), alarm3);
        assertEquals(allAlarms.get(1), alarm4);

        assertTrue(allAlarms.get(0).getId() == 3L);
        assertTrue(allAlarms.get(1).getId() == 4L);
    }

    @Test
    public void step4_update() {
        //do something

    }

    @Test
    public void step5_delete() {
        Alarm alarm6 = AlarmInit.init("5");
        alarmDao.save(alarm6);
        assertTrue(alarm6.getId() == 5L);

        Alarm getAlarm = alarmDao.get(5L);
        assertEquals(alarm6, getAlarm);

        alarmDao.delete(getAlarm);

        Alarm getAfterDelete = alarmDao.get(5L);
        assertNull(getAfterDelete);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}