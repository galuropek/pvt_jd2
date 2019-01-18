package io.swagger.service;

import io.swagger.configuration.AlarmInit;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateXMLConfTest.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AlarmServiceImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    AlarmServiceImpl objServiceTest;

    @Test
    public void step1_listTest(){

        //init Alarms
        Alarm alarm1 = AlarmInit.init("1");
        Alarm alarm2 = AlarmInit.init("2");
        Alarm alarm3 = AlarmInit.init("3");

        //save Alarms
        objServiceTest.save(alarm1);
        objServiceTest.save(alarm2);
        objServiceTest.save(alarm3);
        assertNotNull(alarm1.getId());
        assertNotNull(alarm2.getId());
        assertNotNull(alarm3.getId());


        //init and save Alarms
//        List<Alarm> listAlarms = List.of(
//                AlarmInit.init("1"),
//                AlarmInit.init("2"),
//                AlarmInit.init("3"),
//                AlarmInit.init("4"),
//                AlarmInit.init("5")
//        );
//        listAlarms.forEach(item ->
//                objServiceTest.save(item)
//        );

        //get list
        List<Alarm> list = objServiceTest.list();
        assertEquals(3, list.size());

        //Alarm 1
        assertEquals(alarm1.getId(), list.get(0).getId());
        assertEquals(alarm1.getAlarmedObject().getId(), list.get(0).getAlarmedObject().getId());

        assertEquals(alarm1.getAckUserId(), "AckUserId1");
        assertEquals(alarm1.getType(), "Type1");
        assertEquals(alarm1.getBaseType(), "BaseType1");

        assertEquals(list.get(0).getAckUserId(), "AckUserId1");
        assertEquals(list.get(0).getType(), "Type1");
        assertEquals(list.get(0).getBaseType(), "BaseType1");

        //Alarm 2
        assertEquals(alarm2.getId(), list.get(1).getId());
        assertEquals(alarm2.getAlarmedObject().getId(), list.get(1).getAlarmedObject().getId());

        assertEquals(alarm2.getAckUserId(), "AckUserId2");
        assertEquals(alarm2.getType(), "Type2");
        assertEquals(alarm2.getBaseType(), "BaseType2");

        assertEquals(list.get(1).getAckUserId(), "AckUserId2");
        assertEquals(list.get(1).getType(), "Type2");
        assertEquals(list.get(1).getBaseType(), "BaseType2");

        //Alarm 3
        assertEquals(alarm3.getId(), list.get(2).getId());
        assertEquals(alarm3.getAlarmedObject().getId(), list.get(2).getAlarmedObject().getId());

        assertEquals(alarm3.getAckUserId(), "AckUserId3");
        assertEquals(alarm3.getType(), "Type3");
        assertEquals(alarm3.getBaseType(), "BaseType3");

        assertEquals(list.get(2).getAckUserId(), "AckUserId3");
        assertEquals(list.get(2).getType(), "Type3");
        assertEquals(list.get(2).getBaseType(), "BaseType3");
    }

    @Test
    public void step2_saveTest(){

        //init Alarm
        Alarm alarm4 = AlarmInit.init("4");

        //save Alarm
        objServiceTest.save(alarm4);
        assertNotNull(alarm4.getId());

        //get Alarm
        Alarm retrieve = objServiceTest.retrieve(4L);
        assertEquals(alarm4.getId(), retrieve.getId());

        assertEquals(retrieve.getAckUserId(), "AckUserId4");
        assertEquals(retrieve.getType(), "Type4");
        assertEquals(retrieve.getBaseType(), "BaseType4");
        assertEquals(retrieve.getAlarmType(), "AlarmType4");
        assertEquals(retrieve.getClearSystemId(), "ClearSystemId4");

        assertNotNull(retrieve.getComments().get(0).getSystemId());
        assertEquals(2, retrieve.getComments().size());

        assertEquals("Direction4", retrieve.getCrossedThresholdInformation().getDirection());
        assertNotNull(retrieve.getCrossedThresholdInformation().getThresholdId());


        assertEquals(2, retrieve.getParentAlarm().size());
        assertNotNull(retrieve.getParentAlarm().get(0).getId());

        assertEquals(2, retrieve.getCorrelatedAlarm().size());
        assertNotNull(retrieve.getCorrelatedAlarm().get(0).getId());

        assertEquals(2, retrieve.getAffectedService().size());
        assertNotNull(retrieve.getAffectedService().get(0).getId());

        assertEquals("Href4", retrieve.getAlarmedObject().getHref());
        assertNotNull(retrieve.getAlarmedObject().getId());
    }

//    @Test
//    public void testMethods() {
//
////        // save Alarm pojo
////        Alarm alarm1 = AlarmInit.init("1");
////        objServiceTest.save(alarm1);
////        System.out.println("---> Alarm ID: " + alarm1.getId());
////        assertNotNull(alarm1.getId());
////
////        assertTrue(alarm1.getAffectedService().size() > 0);
////
////        AffectedService affectedService = alarm1.getAffectedService().get(alarm1.getAffectedService().size() - 1);
////        System.out.println("---> Affected service: " + affectedService);
////        assertNotNull(affectedService);
////
////
////        // get Alarm pojo
////        Serializable id = alarm1.getId();
////        Alarm alarmRetrieved = objServiceTest.retrieve(id);
////        assertEquals(alarm1.getId(), alarmRetrieved.getId());
////
////        // get List<Alarm> pojos
////        List<Alarm> list = objServiceTest.list();
////        assertTrue(list.size() == 1);
////
////        Alarm gotAlarm = list.get(0);
//
//    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}