package io.swagger.api;

import io.swagger.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.service.AlarmServiceImpl;
import io.swagger.util.Properties;
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

    //in processing...
    public ResponseEntity<Alarm> alarmClearbyID(@ApiParam(value = "", required = true) @PathVariable("alarmId") String alarmId, @ApiParam(value = "") @Valid @RequestBody Alarm alarm) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
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
//                alarmService.create(List.of(alarm("1"), alarm("2"), alarm("3"), alarm("4"), alarm("5")));
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
        if (accept != null && accept.contains("application/json")) {
            try {
                Serializable id = Long.valueOf(alarmId);
                return new ResponseEntity<Alarm>(alarmService.retrieve(id), HttpStatus.OK);
//                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Alarm>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Alarm>(HttpStatus.NOT_IMPLEMENTED);
    }

    //in processing...
    public ResponseEntity<Alarm> alarmPatch(@ApiParam(value = "", required = true) @PathVariable("alarmId") String alarmId, @ApiParam(value = "", required = true) @Valid @RequestBody Alarm alarm) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Alarm alarmOriginal = alarmService.retrieve(Long.valueOf(alarmId));
                Alarm alarmUpdate = copyProperties(alarmOriginal, alarm);
                alarmService.update(alarmUpdate);
                return new ResponseEntity<Alarm>(
                        alarmService.retrieve(alarmUpdate.getId()),
                        HttpStatus.OK);
//                return new ResponseEntity<Alarm>(objectMapper.readValue("{  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}", Alarm.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Alarm>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<Alarm>(HttpStatus.NOT_IMPLEMENTED);
    }

    private Alarm copyProperties(Alarm alarmOriginal, Alarm alarmRequest) {

        Properties properties = new Properties();

        Alarm alarmUpdate = new Alarm();
        alarmUpdate.setId(alarmOriginal.getId());
        alarmUpdate.setHref((String) properties.copy(
                alarmOriginal.getHref(),
                alarmRequest.getHref()));
        alarmUpdate.setType((String) properties.copy(
                alarmOriginal.getType(),
                alarmRequest.getType()));
        alarmUpdate.setBaseType((String) properties.copy(
                alarmOriginal.getBaseType(),
                alarmRequest.getBaseType()));
        alarmUpdate.setSchemaLocation((String) properties.copy(
                alarmOriginal.getSchemaLocation(),
                alarmRequest.getSchemaLocation()));
        alarmUpdate.setExternalAlarmId((String) properties.copy(
                alarmOriginal.getExternalAlarmId(),
                alarmRequest.getExternalAlarmId()));
        alarmUpdate.setAlarmType((String) properties.copy(
                alarmOriginal.getAlarmType(),
                alarmRequest.getAlarmType()));
        alarmUpdate.setPerceivedSeverity((String) properties.copy(
                alarmOriginal.getPerceivedSeverity(),
                alarmRequest.getPerceivedSeverity()));
        alarmUpdate.setAlarmedObjectType((String) properties.copy(
                alarmOriginal.getAlarmedObjectType(),
                alarmRequest.getAlarmedObjectType()));
        //object
        alarmUpdate.setAlarmedObject((AlarmedObject) properties.copy(
                alarmOriginal.getAlarmedObject(),
                alarmRequest.getAlarmedObject()));

        alarmUpdate.setSourceSystemId((String) properties.copy(
                alarmOriginal.getSourceSystemId(),
                alarmRequest.getSourceSystemId()));
        alarmUpdate.setAlarmDetails((String) properties.copy(
                alarmOriginal.getAlarmDetails(),
                alarmRequest.getAlarmDetails()));
        alarmUpdate.setState((String) properties.copy(
                alarmOriginal.getState(),
                alarmRequest.getState()));

        //object
        alarmUpdate.setAlarmRaisedTime((OffsetDateTime) properties.copy(
                alarmOriginal.getAlarmRaisedTime(),
                alarmRequest.getAlarmRaisedTime()));

        //object
        alarmUpdate.setAlarmChangedTime((OffsetDateTime) properties.copy(
                alarmOriginal.getAlarmChangedTime(),
                alarmRequest.getAlarmChangedTime()));

        //object
        alarmUpdate.setAlarmClearedTime((OffsetDateTime) properties.copy(
                alarmOriginal.getAlarmClearedTime(),
                alarmRequest.getAlarmClearedTime()));

        alarmUpdate.setProposedRepairedActions((String) properties.copy(
                alarmOriginal.getProposedRepairedActions(),
                alarmRequest.getProposedRepairedActions()));

        //object
        alarmUpdate.setAlarmReportingTime((OffsetDateTime) properties.copy(
                alarmOriginal.getAlarmReportingTime(),
                alarmRequest.getAlarmReportingTime()));

        alarmUpdate.setAckState((String) properties.copy(
                alarmOriginal.getAckState(),
                alarmRequest.getAckState()));
        alarmUpdate.setAckUserId((String) properties.copy(
                alarmOriginal.getAckUserId(),
                alarmRequest.getAckUserId()));
        alarmUpdate.setAckSystemId((String) properties.copy(
                alarmOriginal.getAckSystemId(),
                alarmRequest.getAckSystemId()));
        alarmUpdate.setClearUserId((String) properties.copy(
                alarmOriginal.getClearUserId(),
                alarmRequest.getClearUserId()));
        alarmUpdate.setClearSystemId((String) properties.copy(
                alarmOriginal.getClearSystemId(),
                alarmRequest.getClearSystemId()));
        alarmUpdate.setPlannedOutageIndicator((String) properties.copy(
                alarmOriginal.getPlannedOutageIndicator(),
                alarmRequest.getPlannedOutageIndicator()));
        alarmUpdate.setAlarmEscelation((String) properties.copy(
                alarmOriginal.getAlarmEscelation(),
                alarmRequest.getAlarmEscelation()));
        alarmUpdate.setServiceAffecting((String) properties.copy(
                alarmOriginal.getServiceAffecting(),
                alarmRequest.getServiceAffecting()));

        //object
//----------------------> for test set old List. Must edit later on update data.
        @Valid List<AffectedService> affectedServiceOriginal = alarmOriginal.getAffectedService();
        @Valid List<AffectedService> affectedServiceRequest = alarmRequest.getAffectedService();
        alarmUpdate.setAffectedService(affectedServiceOriginal);
//        alarmUpdate.setAffectedService((AffectedService)properties.copy(
//                alarmOriginal.getAffectedService(),
//                alarmRequest.getAffectedService()));

        alarmUpdate.setIsRootCause((String) properties.copy(
                alarmOriginal.getIsRootCause(),
                alarmRequest.getIsRootCause()));

        //object
//----------------------> for test set old List. Must edit later on update data.
        @Valid List<CorrelatedAlarm> correlatedAlarmOriginal = alarmOriginal.getCorrelatedAlarm();
        @Valid List<CorrelatedAlarm> correlatedAlarmRequest = alarmRequest.getCorrelatedAlarm();
        alarmUpdate.setCorrelatedAlarm(correlatedAlarmOriginal);

        //object
//----------------------> for test set old List. Must edit later on update data.
        @Valid List<ParentAlarm> parentAlarmOriginal = alarmOriginal.getParentAlarm();
        @Valid List<ParentAlarm> parentAlarmRequest = alarmRequest.getParentAlarm();
        alarmUpdate.setParentAlarm(parentAlarmOriginal);

        //object
        alarmUpdate.setCrossedThresholdInformation((CrossedThresholdInformation) properties.copy(
                alarmOriginal.getCrossedThresholdInformation(),
                alarmRequest.getCrossedThresholdInformation()));

        //object
//----------------------> for test set old List. Must edit later on update data.
        @Valid List<Comments> commentsOriginal = alarmOriginal.getComments();
        @Valid List<Comments> commentsRequest = alarmRequest.getComments();
        alarmUpdate.setComments(commentsOriginal);


//        alarmUpdate.set((String)properties.copy(
//                alarmOriginal.get,
//                alarmRequest.get));
        return alarmUpdate;
    }

    //edited - List<ALARM> GET method - worked
    public ResponseEntity<List<Alarm>> alarmsFind(@ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Alarm> list = alarmService.list();
                return new ResponseEntity<List<Alarm>>(list,
                        HttpStatus.OK);
//                return new ResponseEntity<List<Alarm>>(objectMapper.readValue("[ {  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"}, {  \"alarmRaisedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmClearedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObjectType\" : \"alarmedObjectType\",  \"@type\" : \"@type\",  \"proposedRepairedActions\" : \"proposedRepairedActions\",  \"correlatedAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"alarmReportingTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"alarmedObject\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"alarmChangedTime\" : \"2000-01-23T04:56:07.000+00:00\",  \"@baseType\" : \"@baseType\",  \"perceivedSeverity\" : \"perceivedSeverity\",  \"affectedService\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"ackSystemId\" : \"ackSystemId\",  \"id\" : 0,  \"href\" : \"href\",  \"state\" : \"state\",  \"@schemaLocation\" : \"@schemaLocation\",  \"crossedThresholdInformation\" : {    \"indicatorName\" : \"indicatorName\",    \"thresholdCrossingDescription\" : \"thresholdCrossingDescription\",    \"granularity\" : \"granularity\",    \"observedValue\" : \"observedValue\",    \"thresholdId\" : \"thresholdId\",    \"thresholdRef\" : \"thresholdRef\",    \"indicatorUnit\" : \"indicatorUnit\",    \"direction\" : \"direction\"  },  \"externalAlarmId\" : \"externalAlarmId\",  \"clearSystemId\" : \"clearSystemId\",  \"parentAlarm\" : [ {    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"isRootCause\" : \"isRootCause\",  \"ackUserId\" : \"ackUserId\",  \"comments\" : [ {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  }, {    \"systemId\" : \"systemId\",    \"comment\" : \"comment\",    \"time\" : \"2000-01-23T04:56:07.000+00:00\",    \"userId\" : \"userId\"  } ],  \"sourceSystemId\" : \"sourceSystemId\",  \"clearUserId\" : \"clearUserId\",  \"serviceAffecting\" : \"serviceAffecting\",  \"alarmEscelation\" : \"alarmEscelation\",  \"ackState\" : \"ackState\",  \"alarmType\" : \"alarmType\",  \"plannedOutageIndicator\" : \"plannedOutageIndicator\",  \"alarmDetails\" : \"alarmDetails\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Alarm>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Alarm>>(HttpStatus.NOT_IMPLEMENTED);
    }
}
