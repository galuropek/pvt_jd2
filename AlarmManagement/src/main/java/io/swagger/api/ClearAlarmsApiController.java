package io.swagger.api;

import io.swagger.model.Alarm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-06T21:03:59.754+03:00")

@Controller
public class ClearAlarmsApiController implements ClearAlarmsApi {

    private static final Logger log = LoggerFactory.getLogger(ClearAlarmsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ClearAlarmsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Alarm> clearAlarmsCreate(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Alarm alarms) {
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

}
