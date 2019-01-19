package io.swagger.api;

import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.AffectedServiceServiceImpl;
import io.swagger.service.AlarmServiceImpl;
import io.swagger.service.AlarmedObjectServiceImpl;
import io.swagger.util.PropertiesUtils;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-06T21:03:59.754+03:00")

@Controller
public class AlarmApiController implements AlarmApi {

    private static final Logger log = LoggerFactory.getLogger(AlarmApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private AlarmServiceImpl alarmService;

    @org.springframework.beans.factory.annotation.Autowired
    public AlarmApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    //edited - ALARM POST mothod - worked
    public ResponseEntity<Alarm> alarmClearbyID(@ApiParam(value = "", required = true) @PathVariable("alarmId") String alarmId, @ApiParam(value = "") @Valid @RequestBody Alarm alarm) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                alarmService.clearFieldsById(Long.valueOf(alarmId), alarm);
                return new ResponseEntity<Alarm>(
                        alarmService.retrieve(Long.valueOf(alarmId)),
                        HttpStatus.OK);
//                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Alarm>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Alarm>(HttpStatus.NOT_IMPLEMENTED);
    }

    //edited - ALARM POST method - worked
    public ResponseEntity<Alarm> alarmCreate(@ApiParam(value = "", required = true) @Valid @RequestBody Alarm alarm) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Alarm copyAlarm = new Alarm();
                BeanUtils.copyProperties(alarm, copyAlarm);
                alarmService.save(copyAlarm);
                return new ResponseEntity<Alarm>(copyAlarm, HttpStatus.OK);
//                alarmService.create(List.of(init("1"), init("2"), init("3")));
//                return new ResponseEntity<Alarm>(alarm, HttpStatus.OK);
//                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Alarm>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Alarm>(HttpStatus.NOT_IMPLEMENTED);
    }

    //edited - VOID DELETE method - worked
    public ResponseEntity<Void> alarmDelete(@ApiParam(value = "", required = true) @PathVariable("alarmId") String alarmId) {
        String accept = request.getHeader("Accept");
        try {
            alarmService.delete(Long.valueOf(alarmId));
        } catch (NumberFormatException e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    //edited - ALARM GET method - worked
    public ResponseEntity<Alarm> alarmGet(@ApiParam(value = "", required = true) @PathVariable("alarmId") String alarmId, @ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
        try {
//            if (fields != null) {
//                List<Alarm> retrieve = alarmService.retrieve(Long.valueOf(alarmId), fields);
//                return new ResponseEntity<Alarm>(
//                        retrieve.get(0),
//                        HttpStatus.OK);
//            } else {
                return new ResponseEntity<Alarm>(
                        alarmService.retrieve(Long.valueOf(alarmId)),
                        HttpStatus.OK);
//            }

//                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<Alarm>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        }

//        return new ResponseEntity<Alarm>(HttpStatus.NOT_IMPLEMENTED);
    }

    //edited - ALARM POST method - worked
    public ResponseEntity<Alarm> alarmPatch(@ApiParam(value = "", required = true) @PathVariable("alarmId") String alarmId, @ApiParam(value = "", required = true) @Valid @RequestBody Alarm alarm) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                alarmService.update(Long.valueOf(alarmId), alarm);
                return new ResponseEntity<Alarm>(
                        alarmService.retrieve(Long.valueOf(alarmId)),
                        HttpStatus.OK);
//                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Alarm>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Alarm>(HttpStatus.NOT_IMPLEMENTED);
    }

    //edited - List<ALARM> GET method - worked
    public ResponseEntity<List<Alarm>> alarmsFind(@ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
//        if (accept != null && accept.contains("application/json")) {
        try {
            if (fields != null) {
                return new ResponseEntity<List<Alarm>>(
                        alarmService.listFields(fields),
                        HttpStatus.OK);
            } else {
                List<Alarm> list = alarmService.list();
                return new ResponseEntity<List<Alarm>>(list,
                        HttpStatus.OK);
            }
//                return new ResponseEntity<List<Alarm>>(objectMapper.readValue("[ {  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}, {  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
        } catch (Exception e) {
            log.error("Couldn't serialize response for content type application/json", e);
            return new ResponseEntity<List<Alarm>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        }

//        return new ResponseEntity<List<Alarm>>(HttpStatus.NOT_IMPLEMENTED);
    }

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
