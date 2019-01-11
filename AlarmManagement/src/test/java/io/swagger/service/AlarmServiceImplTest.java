package io.swagger.service;

import io.swagger.configuration.AlarmInit;
import io.swagger.configuration.HibernateXMLConfTest;
import io.swagger.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class AlarmServiceImplTest {

    @MockBean
    com.fasterxml.jackson.databind.ObjectMapper objectMapper;

    @MockBean
    HttpServletRequest httpServletRequest;

    @Resource
    AlarmServiceImpl objServiceTest;

    @Test
    public void testMethods() {

        // save Alarm pojo
        Alarm alarm1 = AlarmInit.init("1");
        objServiceTest.save(alarm1);
        System.out.println("---> Alarm ID: " + alarm1.getId());
        assertNotNull(alarm1.getId());

        assertTrue(alarm1.getAffectedService().size() > 0);

        AffectedService affectedService = alarm1.getAffectedService().get(alarm1.getAffectedService().size() - 1);
        System.out.println("---> Affected service: " + affectedService);
        assertNotNull(affectedService);


        // get Alarm pojo
        Serializable id = alarm1.getId();
        Alarm alarmRetrieved = objServiceTest.retrieve(id);
        assertEquals(alarm1.getId(), alarmRetrieved.getId());

        // get List<Alarm> pojos
        List<Alarm> list = objServiceTest.list();
        assertTrue(list.size() == 1);

        Alarm gotAlarm = list.get(0);

    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}