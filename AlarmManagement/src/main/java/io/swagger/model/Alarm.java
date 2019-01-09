package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AffectedService;
import io.swagger.model.AlarmedObject;
import io.swagger.model.Comments;
import io.swagger.model.CorrelatedAlarm;
import io.swagger.model.CrossedThresholdInformation;
import io.swagger.model.ParentAlarm;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A alarm base entity containing alarm rules.This entity  is  mandatoryThis entity  is  extendableThis entity   does not generate Object Creation notifications (NA)This entity   generates Object Deletion notificationsThis entity   does not generate Object Discovery notifications (NA)This entity supports the Common Get Operation.This entity supports the Common Get Multiple Operation.This entity supports the Common Create Operation.This entity supports the Common Delete Operation.
 */
@ApiModel(description = "A alarm base entity containing alarm rules.This entity  is  mandatoryThis entity  is  extendableThis entity   does not generate Object Creation notifications (NA)This entity   generates Object Deletion notificationsThis entity   does not generate Object Discovery notifications (NA)This entity supports the Common Get Operation.This entity supports the Common Get Multiple Operation.This entity supports the Common Create Operation.This entity supports the Common Delete Operation.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-06T21:03:59.754+03:00")

@Entity
public class Alarm   {
  @JsonProperty("id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id = null;

  @JsonProperty("href")
  @Column
  private String href = null;

  @JsonProperty("@type")
  @Column
  private String type = null;

  @JsonProperty("@baseType")
  @Column
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  @Column
  private String schemaLocation = null;

  @JsonProperty("externalAlarmId")
  @Column
  private String externalAlarmId = null;

  @JsonProperty("alarmType")
  @Column
  private String alarmType = null;

  @JsonProperty("perceivedSeverity")
  @Column
  private String perceivedSeverity = null;

  @JsonProperty("alarmedObjectType")
  @Column
  private String alarmedObjectType = null;

  @JsonProperty("alarmedObject")
  @OneToOne(cascade = CascadeType.ALL)
  private AlarmedObject alarmedObject = null;

  @JsonProperty("sourceSystemId")
  @Column
  private String sourceSystemId = null;

  @JsonProperty("alarmDetails")
  @Column
  private String alarmDetails = null;

  @JsonProperty("state")
  @Column
  private String state = null;

  @JsonProperty("alarmRaisedTime")
  @Column
  private OffsetDateTime alarmRaisedTime = null;

  @JsonProperty("alarmChangedTime")
  @Column
  private OffsetDateTime alarmChangedTime = null;

  @JsonProperty("alarmClearedTime")
  @Column
  private OffsetDateTime alarmClearedTime = null;

  @JsonProperty("proposedRepairedActions")
  @Column
  private String proposedRepairedActions = null;

  @JsonProperty("alarmReportingTime")
  @Column
  private OffsetDateTime alarmReportingTime = null;

  @JsonProperty("ackState")
  @Column
  private String ackState = null;

  @JsonProperty("ackUserId")
  @Column
  private String ackUserId = null;

  @JsonProperty("ackSystemId")
  @Column
  private String ackSystemId = null;

  @JsonProperty("clearUserId")
  @Column
  private String clearUserId = null;

  @JsonProperty("clearSystemId")
  @Column
  private String clearSystemId = null;

  @JsonProperty("plannedOutageIndicator")
  @Column
  private String plannedOutageIndicator = null;

  @JsonProperty("alarmEscelation")
  @Column
  private String alarmEscelation = null;

  @JsonProperty("serviceAffecting")
  @Column
  private String serviceAffecting = null;

  @JsonProperty("affectedService")
  @Valid
  @OneToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<AffectedService> affectedService = null;

  @JsonProperty("isRootCause")
  @Column
  private String isRootCause = null;

  @JsonProperty("correlatedAlarm")
  @Valid
  @OneToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<CorrelatedAlarm> correlatedAlarm = null;

  @JsonProperty("parentAlarm")
  @Valid
  @OneToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<ParentAlarm> parentAlarm = null;

  @JsonProperty("crossedThresholdInformation")
  @OneToOne(cascade = CascadeType.ALL)
  private CrossedThresholdInformation crossedThresholdInformation = null;

  @JsonProperty("comments")
  @Valid
  @OneToMany(cascade = CascadeType.ALL)
  @LazyCollection(LazyCollectionOption.FALSE)
  private List<Comments> comments = null;

  public Alarm id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the alarm, determined by the alarm owning system
   * @return id
  **/
  @ApiModelProperty(value = "Identifier of the alarm, determined by the alarm owning system")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Alarm href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A reference to the alarm.
   * @return href
  **/
  @ApiModelProperty(value = "A reference to the alarm.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Alarm type(String type) {
    this.type = type;
    return this;
  }

  /**
   * The type for this alarm.
   * @return type
  **/
  @ApiModelProperty(value = "The type for this alarm.")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Alarm baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * The base type of this alarm.
   * @return baseType
  **/
  @ApiModelProperty(value = "The base type of this alarm.")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Alarm schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * A reference to the schema describing this alarm.
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "A reference to the schema describing this alarm.")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Alarm externalAlarmId(String externalAlarmId) {
    this.externalAlarmId = externalAlarmId;
    return this;
  }

  /**
   * An identifier of the alarm in the source system
   * @return externalAlarmId
  **/
  @ApiModelProperty(value = "An identifier of the alarm in the source system")


  public String getExternalAlarmId() {
    return externalAlarmId;
  }

  public void setExternalAlarmId(String externalAlarmId) {
    this.externalAlarmId = externalAlarmId;
  }

  public Alarm alarmType(String alarmType) {
    this.alarmType = alarmType;
    return this;
  }

  /**
   * Categorize the alarm.
   * @return alarmType
  **/
  @ApiModelProperty(value = "Categorize the alarm.")


  public String getAlarmType() {
    return alarmType;
  }

  public void setAlarmType(String alarmType) {
    this.alarmType = alarmType;
  }

  public Alarm perceivedSeverity(String perceivedSeverity) {
    this.perceivedSeverity = perceivedSeverity;
    return this;
  }

  /**
   * Lists the possible severities that can be allocated to an Alarm. The values are consistent with ITU-T Recommendation X.733. Once an alarm has been cleared, its perceived severity is set to Cleared and can no longer be set.
   * @return perceivedSeverity
  **/
  @ApiModelProperty(value = "Lists the possible severities that can be allocated to an Alarm. The values are consistent with ITU-T Recommendation X.733. Once an alarm has been cleared, its perceived severity is set to Cleared and can no longer be set.")


  public String getPerceivedSeverity() {
    return perceivedSeverity;
  }

  public void setPerceivedSeverity(String perceivedSeverity) {
    this.perceivedSeverity = perceivedSeverity;
  }

  public Alarm alarmedObjectType(String alarmedObjectType) {
    this.alarmedObjectType = alarmedObjectType;
    return this;
  }

  /**
   * The type (class) of the object associated with the event. 
   * @return alarmedObjectType
  **/
  @ApiModelProperty(value = "The type (class) of the object associated with the event. ")


  public String getAlarmedObjectType() {
    return alarmedObjectType;
  }

  public void setAlarmedObjectType(String alarmedObjectType) {
    this.alarmedObjectType = alarmedObjectType;
  }

  public Alarm alarmedObject(AlarmedObject alarmedObject) {
    this.alarmedObject = alarmedObject;
    return this;
  }

  /**
   * Get alarmedObject
   * @return alarmedObject
  **/
  @ApiModelProperty(value = "")

  @Valid

  public AlarmedObject getAlarmedObject() {
    return alarmedObject;
  }

  public void setAlarmedObject(AlarmedObject alarmedObject) {
    this.alarmedObject = alarmedObject;
  }

  public Alarm sourceSystemId(String sourceSystemId) {
    this.sourceSystemId = sourceSystemId;
    return this;
  }

  /**
   * Get sourceSystemId
   * @return sourceSystemId
  **/
  @ApiModelProperty(value = "")


  public String getSourceSystemId() {
    return sourceSystemId;
  }

  public void setSourceSystemId(String sourceSystemId) {
    this.sourceSystemId = sourceSystemId;
  }

  public Alarm alarmDetails(String alarmDetails) {
    this.alarmDetails = alarmDetails;
    return this;
  }

  /**
   * Contains further information on the alarm
   * @return alarmDetails
  **/
  @ApiModelProperty(value = "Contains further information on the alarm")


  public String getAlarmDetails() {
    return alarmDetails;
  }

  public void setAlarmDetails(String alarmDetails) {
    this.alarmDetails = alarmDetails;
  }

  public Alarm state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Defines the alarm state during its life cycle RAISED, UPDATED or CLEARED
   * @return state
  **/
  @ApiModelProperty(value = "Defines the alarm state during its life cycle RAISED, UPDATED or CLEARED")


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Alarm alarmRaisedTime(OffsetDateTime alarmRaisedTime) {
    this.alarmRaisedTime = alarmRaisedTime;
    return this;
  }

  /**
   * Indicates the time (as a date + time) at which the alarm occurred at its source.
   * @return alarmRaisedTime
  **/
  @ApiModelProperty(value = "Indicates the time (as a date + time) at which the alarm occurred at its source.")

  @Valid

  public OffsetDateTime getAlarmRaisedTime() {
    return alarmRaisedTime;
  }

  public void setAlarmRaisedTime(OffsetDateTime alarmRaisedTime) {
    this.alarmRaisedTime = alarmRaisedTime;
  }

  public Alarm alarmChangedTime(OffsetDateTime alarmChangedTime) {
    this.alarmChangedTime = alarmChangedTime;
    return this;
  }

  /**
   * Indicates the last date and time when the alarm is changed on the alarm-owning system. Any change to the alarm whether coming from the alarmed resource, or triggered by a change from the client is changing this time.
   * @return alarmChangedTime
  **/
  @ApiModelProperty(value = "Indicates the last date and time when the alarm is changed on the alarm-owning system. Any change to the alarm whether coming from the alarmed resource, or triggered by a change from the client is changing this time.")

  @Valid

  public OffsetDateTime getAlarmChangedTime() {
    return alarmChangedTime;
  }

  public void setAlarmChangedTime(OffsetDateTime alarmChangedTime) {
    this.alarmChangedTime = alarmChangedTime;
  }

  public Alarm alarmClearedTime(OffsetDateTime alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
    return this;
  }

  /**
   * Indicates the time (as a date + time) at which the alarm is cleared at the source. 
   * @return alarmClearedTime
  **/
  @ApiModelProperty(value = "Indicates the time (as a date + time) at which the alarm is cleared at the source. ")

  @Valid

  public OffsetDateTime getAlarmClearedTime() {
    return alarmClearedTime;
  }

  public void setAlarmClearedTime(OffsetDateTime alarmClearedTime) {
    this.alarmClearedTime = alarmClearedTime;
  }

  public Alarm proposedRepairedActions(String proposedRepairedActions) {
    this.proposedRepairedActions = proposedRepairedActions;
    return this;
  }

  /**
   * Indicates proposed repair actions, if known to the system emitting the alarm.
   * @return proposedRepairedActions
  **/
  @ApiModelProperty(value = "Indicates proposed repair actions, if known to the system emitting the alarm.")


  public String getProposedRepairedActions() {
    return proposedRepairedActions;
  }

  public void setProposedRepairedActions(String proposedRepairedActions) {
    this.proposedRepairedActions = proposedRepairedActions;
  }

  public Alarm alarmReportingTime(OffsetDateTime alarmReportingTime) {
    this.alarmReportingTime = alarmReportingTime;
    return this;
  }

  /**
   * Indicates the time (as a date + time) at which the alarm was reported by the owning OSS. It might be different from the alarmRaisedTime. For instance, if the alarm list is maintained by an EMS, the alarmRaisedtime would be the time the alarm   was detected by the NE, while the alarmReportingTime would be the time this alarm was stored in the alarm list of the EMS.
   * @return alarmReportingTime
  **/
  @ApiModelProperty(value = "Indicates the time (as a date + time) at which the alarm was reported by the owning OSS. It might be different from the alarmRaisedTime. For instance, if the alarm list is maintained by an EMS, the alarmRaisedtime would be the time the alarm   was detected by the NE, while the alarmReportingTime would be the time this alarm was stored in the alarm list of the EMS.")

  @Valid

  public OffsetDateTime getAlarmReportingTime() {
    return alarmReportingTime;
  }

  public void setAlarmReportingTime(OffsetDateTime alarmReportingTime) {
    this.alarmReportingTime = alarmReportingTime;
  }

  public Alarm ackState(String ackState) {
    this.ackState = ackState;
    return this;
  }

  /**
   * Provides the Acknowledgement State of the alarm ACKNOWLEDGED, UNACKNOWLEDGED
   * @return ackState
  **/
  @ApiModelProperty(value = "Provides the Acknowledgement State of the alarm ACKNOWLEDGED, UNACKNOWLEDGED")


  public String getAckState() {
    return ackState;
  }

  public void setAckState(String ackState) {
    this.ackState = ackState;
  }

  public Alarm ackUserId(String ackUserId) {
    this.ackUserId = ackUserId;
    return this;
  }

  /**
   * Provides the id of the user who has last changed the ack state of the alarm, i.e. acknowledged or unacknowledged the alarm.
   * @return ackUserId
  **/
  @ApiModelProperty(value = "Provides the id of the user who has last changed the ack state of the alarm, i.e. acknowledged or unacknowledged the alarm.")


  public String getAckUserId() {
    return ackUserId;
  }

  public void setAckUserId(String ackUserId) {
    this.ackUserId = ackUserId;
  }

  public Alarm ackSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
    return this;
  }

  /**
   * Provides the name of the system that last changed the ackState of an alarm, i.e. acknowledged or unacknowledged the alarm.
   * @return ackSystemId
  **/
  @ApiModelProperty(value = "Provides the name of the system that last changed the ackState of an alarm, i.e. acknowledged or unacknowledged the alarm.")


  public String getAckSystemId() {
    return ackSystemId;
  }

  public void setAckSystemId(String ackSystemId) {
    this.ackSystemId = ackSystemId;
  }

  public Alarm clearUserId(String clearUserId) {
    this.clearUserId = clearUserId;
    return this;
  }

  /**
   * Provides the id of the user who invoked the alarmCleared operation
   * @return clearUserId
  **/
  @ApiModelProperty(value = "Provides the id of the user who invoked the alarmCleared operation")


  public String getClearUserId() {
    return clearUserId;
  }

  public void setClearUserId(String clearUserId) {
    this.clearUserId = clearUserId;
  }

  public Alarm clearSystemId(String clearSystemId) {
    this.clearSystemId = clearSystemId;
    return this;
  }

  /**
   * Provides the id of the system where the user who invoked the alarmCleared operation is located. 
   * @return clearSystemId
  **/
  @ApiModelProperty(value = "Provides the id of the system where the user who invoked the alarmCleared operation is located. ")


  public String getClearSystemId() {
    return clearSystemId;
  }

  public void setClearSystemId(String clearSystemId) {
    this.clearSystemId = clearSystemId;
  }

  public Alarm plannedOutageIndicator(String plannedOutageIndicator) {
    this.plannedOutageIndicator = plannedOutageIndicator;
    return this;
  }

  /**
   * Indicates that the Managed Object (related to this alarm) is in planned outage (in planned maintenance, or out-of-service). 
   * @return plannedOutageIndicator
  **/
  @ApiModelProperty(value = "Indicates that the Managed Object (related to this alarm) is in planned outage (in planned maintenance, or out-of-service). ")


  public String getPlannedOutageIndicator() {
    return plannedOutageIndicator;
  }

  public void setPlannedOutageIndicator(String plannedOutageIndicator) {
    this.plannedOutageIndicator = plannedOutageIndicator;
  }

  public Alarm alarmEscelation(String alarmEscelation) {
    this.alarmEscelation = alarmEscelation;
    return this;
  }

  /**
   * Indicates if this alarm has been escalated or not. 
   * @return alarmEscelation
  **/
  @ApiModelProperty(value = "Indicates if this alarm has been escalated or not. ")


  public String getAlarmEscelation() {
    return alarmEscelation;
  }

  public void setAlarmEscelation(String alarmEscelation) {
    this.alarmEscelation = alarmEscelation;
  }

  public Alarm serviceAffecting(String serviceAffecting) {
    this.serviceAffecting = serviceAffecting;
    return this;
  }

  /**
   * Indicates whether the alarm affects service or not. 
   * @return serviceAffecting
  **/
  @ApiModelProperty(value = "Indicates whether the alarm affects service or not. ")


  public String getServiceAffecting() {
    return serviceAffecting;
  }

  public void setServiceAffecting(String serviceAffecting) {
    this.serviceAffecting = serviceAffecting;
  }

  public Alarm affectedService(List<AffectedService> affectedService) {
    this.affectedService = affectedService;
    return this;
  }

  public Alarm addAffectedServiceItem(AffectedService affectedServiceItem) {
    if (this.affectedService == null) {
      this.affectedService = new ArrayList<AffectedService>();
    }
    this.affectedService.add(affectedServiceItem);
    return this;
  }

  /**
   * Get affectedService
   * @return affectedService
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<AffectedService> getAffectedService() {
    return affectedService;
  }

  public void setAffectedService(List<AffectedService> affectedService) {
    this.affectedService = affectedService;
  }

  public Alarm isRootCause(String isRootCause) {
    this.isRootCause = isRootCause;
    return this;
  }

  /**
   * Indicates whether the alarm is a root cause alarm.. 
   * @return isRootCause
  **/
  @ApiModelProperty(value = "Indicates whether the alarm is a root cause alarm.. ")


  public String getIsRootCause() {
    return isRootCause;
  }

  public void setIsRootCause(String isRootCause) {
    this.isRootCause = isRootCause;
  }

  public Alarm correlatedAlarm(List<CorrelatedAlarm> correlatedAlarm) {
    this.correlatedAlarm = correlatedAlarm;
    return this;
  }

  public Alarm addCorrelatedAlarmItem(CorrelatedAlarm correlatedAlarmItem) {
    if (this.correlatedAlarm == null) {
      this.correlatedAlarm = new ArrayList<CorrelatedAlarm>();
    }
    this.correlatedAlarm.add(correlatedAlarmItem);
    return this;
  }

  /**
   * Get correlatedAlarm
   * @return correlatedAlarm
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CorrelatedAlarm> getCorrelatedAlarm() {
    return correlatedAlarm;
  }

  public void setCorrelatedAlarm(List<CorrelatedAlarm> correlatedAlarm) {
    this.correlatedAlarm = correlatedAlarm;
  }

  public Alarm parentAlarm(List<ParentAlarm> parentAlarm) {
    this.parentAlarm = parentAlarm;
    return this;
  }

  public Alarm addParentAlarmItem(ParentAlarm parentAlarmItem) {
    if (this.parentAlarm == null) {
      this.parentAlarm = new ArrayList<ParentAlarm>();
    }
    this.parentAlarm.add(parentAlarmItem);
    return this;
  }

  /**
   * Get parentAlarm
   * @return parentAlarm
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<ParentAlarm> getParentAlarm() {
    return parentAlarm;
  }

  public void setParentAlarm(List<ParentAlarm> parentAlarm) {
    this.parentAlarm = parentAlarm;
  }

  public Alarm crossedThresholdInformation(CrossedThresholdInformation crossedThresholdInformation) {
    this.crossedThresholdInformation = crossedThresholdInformation;
    return this;
  }

  /**
   * Get crossedThresholdInformation
   * @return crossedThresholdInformation
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CrossedThresholdInformation getCrossedThresholdInformation() {
    return crossedThresholdInformation;
  }

  public void setCrossedThresholdInformation(CrossedThresholdInformation crossedThresholdInformation) {
    this.crossedThresholdInformation = crossedThresholdInformation;
  }

  public Alarm comments(List<Comments> comments) {
    this.comments = comments;
    return this;
  }

  public Alarm addCommentsItem(Comments commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<Comments>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Comments> getComments() {
    return comments;
  }

  public void setComments(List<Comments> comments) {
    this.comments = comments;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Alarm alarm = (Alarm) o;
    return Objects.equals(this.id, alarm.id) &&
        Objects.equals(this.href, alarm.href) &&
        Objects.equals(this.type, alarm.type) &&
        Objects.equals(this.baseType, alarm.baseType) &&
        Objects.equals(this.schemaLocation, alarm.schemaLocation) &&
        Objects.equals(this.externalAlarmId, alarm.externalAlarmId) &&
        Objects.equals(this.alarmType, alarm.alarmType) &&
        Objects.equals(this.perceivedSeverity, alarm.perceivedSeverity) &&
        Objects.equals(this.alarmedObjectType, alarm.alarmedObjectType) &&
        Objects.equals(this.alarmedObject, alarm.alarmedObject) &&
        Objects.equals(this.sourceSystemId, alarm.sourceSystemId) &&
        Objects.equals(this.alarmDetails, alarm.alarmDetails) &&
        Objects.equals(this.state, alarm.state) &&
        Objects.equals(this.alarmRaisedTime, alarm.alarmRaisedTime) &&
        Objects.equals(this.alarmChangedTime, alarm.alarmChangedTime) &&
        Objects.equals(this.alarmClearedTime, alarm.alarmClearedTime) &&
        Objects.equals(this.proposedRepairedActions, alarm.proposedRepairedActions) &&
        Objects.equals(this.alarmReportingTime, alarm.alarmReportingTime) &&
        Objects.equals(this.ackState, alarm.ackState) &&
        Objects.equals(this.ackUserId, alarm.ackUserId) &&
        Objects.equals(this.ackSystemId, alarm.ackSystemId) &&
        Objects.equals(this.clearUserId, alarm.clearUserId) &&
        Objects.equals(this.clearSystemId, alarm.clearSystemId) &&
        Objects.equals(this.plannedOutageIndicator, alarm.plannedOutageIndicator) &&
        Objects.equals(this.alarmEscelation, alarm.alarmEscelation) &&
        Objects.equals(this.serviceAffecting, alarm.serviceAffecting) &&
        Objects.equals(this.affectedService, alarm.affectedService) &&
        Objects.equals(this.isRootCause, alarm.isRootCause) &&
        Objects.equals(this.correlatedAlarm, alarm.correlatedAlarm) &&
        Objects.equals(this.parentAlarm, alarm.parentAlarm) &&
        Objects.equals(this.crossedThresholdInformation, alarm.crossedThresholdInformation) &&
        Objects.equals(this.comments, alarm.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, type, baseType, schemaLocation, externalAlarmId, alarmType, perceivedSeverity, alarmedObjectType, alarmedObject, sourceSystemId, alarmDetails, state, alarmRaisedTime, alarmChangedTime, alarmClearedTime, proposedRepairedActions, alarmReportingTime, ackState, ackUserId, ackSystemId, clearUserId, clearSystemId, plannedOutageIndicator, alarmEscelation, serviceAffecting, affectedService, isRootCause, correlatedAlarm, parentAlarm, crossedThresholdInformation, comments);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Alarm {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    externalAlarmId: ").append(toIndentedString(externalAlarmId)).append("\n");
    sb.append("    alarmType: ").append(toIndentedString(alarmType)).append("\n");
    sb.append("    perceivedSeverity: ").append(toIndentedString(perceivedSeverity)).append("\n");
    sb.append("    alarmedObjectType: ").append(toIndentedString(alarmedObjectType)).append("\n");
    sb.append("    alarmedObject: ").append(toIndentedString(alarmedObject)).append("\n");
    sb.append("    sourceSystemId: ").append(toIndentedString(sourceSystemId)).append("\n");
    sb.append("    alarmDetails: ").append(toIndentedString(alarmDetails)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    alarmRaisedTime: ").append(toIndentedString(alarmRaisedTime)).append("\n");
    sb.append("    alarmChangedTime: ").append(toIndentedString(alarmChangedTime)).append("\n");
    sb.append("    alarmClearedTime: ").append(toIndentedString(alarmClearedTime)).append("\n");
    sb.append("    proposedRepairedActions: ").append(toIndentedString(proposedRepairedActions)).append("\n");
    sb.append("    alarmReportingTime: ").append(toIndentedString(alarmReportingTime)).append("\n");
    sb.append("    ackState: ").append(toIndentedString(ackState)).append("\n");
    sb.append("    ackUserId: ").append(toIndentedString(ackUserId)).append("\n");
    sb.append("    ackSystemId: ").append(toIndentedString(ackSystemId)).append("\n");
    sb.append("    clearUserId: ").append(toIndentedString(clearUserId)).append("\n");
    sb.append("    clearSystemId: ").append(toIndentedString(clearSystemId)).append("\n");
    sb.append("    plannedOutageIndicator: ").append(toIndentedString(plannedOutageIndicator)).append("\n");
    sb.append("    alarmEscelation: ").append(toIndentedString(alarmEscelation)).append("\n");
    sb.append("    serviceAffecting: ").append(toIndentedString(serviceAffecting)).append("\n");
    sb.append("    affectedService: ").append(toIndentedString(affectedService)).append("\n");
    sb.append("    isRootCause: ").append(toIndentedString(isRootCause)).append("\n");
    sb.append("    correlatedAlarm: ").append(toIndentedString(correlatedAlarm)).append("\n");
    sb.append("    parentAlarm: ").append(toIndentedString(parentAlarm)).append("\n");
    sb.append("    crossedThresholdInformation: ").append(toIndentedString(crossedThresholdInformation)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

