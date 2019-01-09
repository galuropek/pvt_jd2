package io.swagger.service;

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
        Alarm alarm1 = alarm("1");
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
        assertTrue(list.size() > 0);

    }

    private Alarm alarm(String prefix) {
        Alarm alarm = new Alarm();
        alarm.setHref("Href" + prefix);
        alarm.setType("Type" + prefix);
        alarm.setBaseType("BaseType" + prefix);
        alarm.setSchemaLocation("SchemaLocation" + prefix);
        alarm.setExternalAlarmId("ExternalAlarmId" + prefix);
        alarm.setAlarmType("AlarmType" + prefix);
        alarm.setPerceivedSeverity("PerceivedSeverity" + prefix);
        alarm.setAlarmedObjectType("AlarmObjectType" + prefix);
        alarm.setAlarmedObject(alarmedObject(prefix));
        alarm.setSourceSystemId("SourceSystemID" + prefix);
        alarm.setAlarmDetails("AlarmDetails" + prefix);
        alarm.setState("State" + prefix);
        alarm.setAlarmRaisedTime(OffsetDateTime.of(
                2019, 1, 1, 1, 10, 10, 1000, ZoneOffset.UTC));
        alarm.setAlarmChangedTime(OffsetDateTime.of(
                2019, 1, 1, 2, 10, 10, 1000, ZoneOffset.UTC));
        alarm.setAlarmClearedTime(OffsetDateTime.of(
                2019, 1, 1, 3, 10, 10, 1000, ZoneOffset.UTC));
        alarm.setProposedRepairedActions("ProposedRepairedActions" + prefix);
        alarm.setAlarmReportingTime(OffsetDateTime.of(
                2019, 1, 1, 4, 10, 10, 1000, ZoneOffset.UTC));
        alarm.setAckState("AckState" + prefix);
        alarm.setAckUserId("AckUserId" + prefix);
        alarm.setAckSystemId("AckSystemId" + prefix);
        alarm.setClearUserId("ClearUserId" + prefix);
        alarm.setClearSystemId("ClearSystemId" + prefix);
        alarm.setPlannedOutageIndicator("PlannedOutageIndicator" + prefix);
        alarm.setAlarmEscelation("AlarmEscelation" + prefix);
        alarm.setServiceAffecting("ServiceAffecting" + prefix);
        alarm.setAffectedService(List.of(
                affectedservice("1"),
                affectedservice("2")
        ));
        alarm.setIsRootCause("IsRootCause" + prefix);
        alarm.setCorrelatedAlarm(List.of(
                correlatedAlarm("1"),
                correlatedAlarm("2")
        ));
        alarm.setParentAlarm(List.of(
                parentAlarm("1"),
                parentAlarm("2")
        ));
        alarm.setCrossedThresholdInformation(crossedThresholdInformation(prefix));
        alarm.setComments(List.of(
                comments("1"),
                comments("2")
        ));
        return alarm;
    }

    private Comments comments(String prefix) {
        Comments comments = new Comments();
        comments.setComment("Comment" + prefix);
        comments.setTime(OffsetDateTime.now());
        comments.setUserId("UserId" + prefix);
        return comments;
    }

    private CrossedThresholdInformation crossedThresholdInformation(String prefix) {
        CrossedThresholdInformation crossedThresholdInformation =
                new CrossedThresholdInformation();
        crossedThresholdInformation.setDirection("Direction" + prefix);
        crossedThresholdInformation.setGranularity("Granularyty" + prefix);
        crossedThresholdInformation.setIndicatorName("IndicatorName" + prefix);
        crossedThresholdInformation.setIndicatorUnit("IndicatorUnit" + prefix);
        crossedThresholdInformation.setObservedValue("ObservedValue" + prefix);
        crossedThresholdInformation.setThresholdCrossingDescription("ThresholdCrossingDescription" + prefix);
        crossedThresholdInformation.setThresholdRef("ThresholdRef" + prefix);
        return crossedThresholdInformation;
    }

    private ParentAlarm parentAlarm(String prefix) {
        ParentAlarm parentAlarm = new ParentAlarm();
        parentAlarm.setHref("Href" + prefix);
        return parentAlarm;
    }

    private CorrelatedAlarm correlatedAlarm(String prefix) {
        CorrelatedAlarm correlatedAlarm = new CorrelatedAlarm();
        correlatedAlarm.setHref("Href" + prefix);
        return correlatedAlarm;
    }

    private AffectedService affectedservice(String prefix) {
        AffectedService affectedService = new AffectedService();
        affectedService.setHref("Href" + prefix);
        return affectedService;
    }

    private AlarmedObject alarmedObject(String prefix) {
        AlarmedObject alarmedObject = new AlarmedObject();
        alarmedObject.setHref("Href" + prefix);
        return alarmedObject;
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
}