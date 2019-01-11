package io.swagger.configuration;

import io.swagger.model.*;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import java.util.List;

public class AlarmInit {

    public static Alarm init(String prefix) {
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

    private static Comments comments(String prefix) {
        Comments comments = new Comments();
        comments.setComment("Comment" + prefix);
        comments.setTime(OffsetDateTime.now());
        comments.setUserId("UserId" + prefix);
        return comments;
    }

    private static CrossedThresholdInformation crossedThresholdInformation(String prefix) {
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

    private static ParentAlarm parentAlarm(String prefix) {
        ParentAlarm parentAlarm = new ParentAlarm();
        parentAlarm.setHref("Href" + prefix);
        return parentAlarm;
    }

    private static CorrelatedAlarm correlatedAlarm(String prefix) {
        CorrelatedAlarm correlatedAlarm = new CorrelatedAlarm();
        correlatedAlarm.setHref("Href" + prefix);
        return correlatedAlarm;
    }

    private static AffectedService affectedservice(String prefix) {
        AffectedService affectedService = new AffectedService();
        affectedService.setHref("Href" + prefix);
        return affectedService;
    }

    private static AlarmedObject alarmedObject(String prefix) {
        AlarmedObject alarmedObject = new AlarmedObject();
        alarmedObject.setHref("Href" + prefix);
        return alarmedObject;
    }
}
