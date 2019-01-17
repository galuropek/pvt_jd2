package io.swagger.dao;

import io.swagger.configuration.AlarmInit;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.Alarm;
import io.swagger.model.AlarmedObject;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlarmDaoImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

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
        Alarm alarm5 = AlarmInit.init("5");
        alarmDao.save(alarm5);
        assertTrue(alarm5.getId() == 5L);
        assertEquals(alarm5.getAckUserId(), "AckUserId5");
        System.out.println("---> Print Alarm5:\n" + alarm5);

        assertEquals(alarm5.getType(), "Type5");
        assertEquals(alarm5.getBaseType(), "BaseType5");
        assertEquals(alarm5.getAlarmType(), "AlarmType5");
        assertEquals(alarm5.getClearSystemId(), "ClearSystemId5");

        assertEquals(alarm5.getComments().get(0).getComment(), "Comment1");
        assertNotNull(alarm5.getComments().get(0).getSystemId());

        assertEquals(alarm5.getCrossedThresholdInformation().getDirection(), "Direction5");
        assertNotNull(alarm5.getCrossedThresholdInformation().getThresholdId());


        assertEquals(alarm5.getParentAlarm().get(0).getHref(), "Href1");
        assertNotNull(alarm5.getParentAlarm().get(0).getId());

        assertEquals(alarm5.getCorrelatedAlarm().get(0).getHref(), "Href1");
        assertNotNull(alarm5.getCorrelatedAlarm().get(0).getId());

        assertEquals(alarm5.getAffectedService().get(0).getHref(), "Href1");
        assertNotNull(alarm5.getAffectedService().get(0).getId());

        assertEquals(alarm5.getAlarmedObject().getHref(), "Href5");
        assertNotNull(alarm5.getAlarmedObject().getId());

//        Alarm update = AlarmInit.init("7");
//        update.setId(alarm5.getId());
//        update.setAlarmedObject(alarm5.getAlarmedObject());
//        update.setAffectedService(alarm5.getAffectedService());
//        update.setCorrelatedAlarm(alarm5.getCorrelatedAlarm());
//        update.setParentAlarm(alarm5.getParentAlarm());
//        update.setCrossedThresholdInformation(alarm5.getCrossedThresholdInformation());
//        update.setComments(alarm5.getComments());
//        System.out.println(update);
//        alarm5.setId(null);
//        System.out.println(alarm5);
//        alarmDao.save(update);
//        System.out.println(alarmDao.get(5L));

        Alarm alarmUpdate = new Alarm()
                .id(alarm5.getId())
                .type("TypeUpdate")
                .alarmedObject(new AlarmedObject()
                        .href("hrefUpdate"));
        BeanUtils.copyProperties(alarmUpdate, alarm5);
        alarmDao.update(alarm5);
        System.out.println(alarm5);
        Alarm alarm = alarmDao.get(alarm5.getId());
        System.out.println(alarm);
    }

    @Test
    public void step5_delete() {
        Alarm alarm6 = AlarmInit.init("6");
        alarmDao.save(alarm6);
        assertTrue(alarm6.getId() == 6L);

        Alarm getAlarm = alarmDao.get(6L);
        assertEquals(alarm6, getAlarm);

        alarmDao.delete(getAlarm);

        Alarm getAfterDelete = alarmDao.get(6L);
        assertNull(getAfterDelete);
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}