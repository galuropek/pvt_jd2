/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.1-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.Alarm;
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

@Api(value = "unAckAlarms", description = "the unAckAlarms API")
public interface UnAckAlarmsApi {

    @ApiOperation(value = "unAckAlarmsCreate", nickname = "unAckAlarmsCreate", notes = "", response = Alarm.class, tags={ "alarms", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Alarms", response = Alarm.class) })
    @RequestMapping(value = "/unAckAlarms",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Alarm> unAckAlarmsCreate(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Alarm alarms);

}