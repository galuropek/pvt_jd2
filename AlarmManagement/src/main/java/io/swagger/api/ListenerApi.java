/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.1-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.AlarmAckStateNotification;
import io.swagger.model.AlarmChangeNotification;
import io.swagger.model.AlarmClearedNotification;
import io.swagger.model.AlarmCreateNotification;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-06T21:03:59.754+03:00")

@Api(value = "listener", description = "the listener API")
public interface ListenerApi {

    @ApiOperation(value = "alarmAckStateNotification", nickname = "alarmAckStateNotification", notes = "", response = AlarmAckStateNotification.class, tags={ "notification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "alarm", response = AlarmAckStateNotification.class) })
    @RequestMapping(value = "/listener/alarmAckStateNotification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AlarmAckStateNotification> alarmAckStateNotification(@ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "alarmChangeNotification", nickname = "alarmChangeNotification", notes = "", response = AlarmChangeNotification.class, tags={ "notification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "alarm", response = AlarmChangeNotification.class) })
    @RequestMapping(value = "/listener/alarmChangeNotification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AlarmChangeNotification> alarmChangeNotification(@ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "alarmClearedNotification", nickname = "alarmClearedNotification", notes = "", response = AlarmClearedNotification.class, tags={ "notification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "alarm", response = AlarmClearedNotification.class) })
    @RequestMapping(value = "/listener/alarmClearedNotification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AlarmClearedNotification> alarmClearedNotification(@ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields);


    @ApiOperation(value = "alarmCreateNotification", nickname = "alarmCreateNotification", notes = "", response = AlarmCreateNotification.class, tags={ "notification", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "alarm", response = AlarmCreateNotification.class) })
    @RequestMapping(value = "/listener/alarmCreateNotification",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<AlarmCreateNotification> alarmCreateNotification(@ApiParam(value = "") @Valid @RequestParam(value = "fields", required = false) String fields);

}
