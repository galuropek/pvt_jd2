package io.swagger.util;

import io.swagger.model.*;
import org.springframework.beans.BeanUtils;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.List;

public class PropertiesUtils {

    public static Alarm clearProperties(Alarm original, Alarm edited) {

        Alarm clear = new Alarm();
        clear.setHref(clearStringProperties(
                original.getHref(),
                edited.getHref()
        ));
        clear.setType(clearStringProperties(
                original.getType(),
                edited.getType()
        ));
        clear.setBaseType(clearStringProperties(
                original.getBaseType(),
                edited.getBaseType()
        ));
        clear.setSchemaLocation(clearStringProperties(
                original.getSchemaLocation(),
                edited.getSchemaLocation()
        ));
        clear.setExternalAlarmId(clearStringProperties(
                original.getExternalAlarmId(),
                edited.getExternalAlarmId()
        ));
        clear.setAlarmType(clearStringProperties(
                original.getAlarmType(),
                edited.getAlarmType()
        ));
        clear.setPerceivedSeverity(clearStringProperties(
                original.getPerceivedSeverity(),
                edited.getPerceivedSeverity()
        ));
        clear.setAlarmedObjectType(clearStringProperties(
                original.getAlarmedObjectType(),
                edited.getAlarmedObjectType()
        ));

        //object -----------------------------------------------------
        clear.setAlarmedObject(clearAlarmedObject(
                original.getAlarmedObject(),
                edited.getAlarmedObject()
        ));
        //------------------------------------------------------------

        clear.setSourceSystemId(clearStringProperties(
                original.getSourceSystemId(),
                edited.getSourceSystemId()
        ));
        clear.setAlarmDetails(clearStringProperties(
                original.getAlarmDetails(),
                edited.getAlarmDetails()
        ));
        clear.setState(clearStringProperties(
                original.getState(),
                edited.getState()
        ));

        //OffsetDateTime
        clear.setAlarmRaisedTime(clearOffsetDateTime(
                original.getAlarmRaisedTime(),
                edited.getAlarmRaisedTime()
        ));

        //OffsetDateTime
        clear.setAlarmChangedTime(clearOffsetDateTime(
                original.getAlarmChangedTime(),
                edited.getAlarmChangedTime()
        ));

        //OffsetDateTime
        clear.setAlarmClearedTime(clearOffsetDateTime(
                original.getAlarmClearedTime(),
                edited.getAlarmClearedTime()
        ));

        clear.setProposedRepairedActions(clearStringProperties(
                original.getProposedRepairedActions(),
                edited.getProposedRepairedActions()
        ));

        //OffsetDateTime
        clear.setAlarmReportingTime(clearOffsetDateTime(
                original.getAlarmReportingTime(),
                edited.getAlarmReportingTime()
        ));

        clear.setAckState(clearStringProperties(
                original.getAckState(),
                edited.getAckState()));
        clear.setAckUserId(clearStringProperties(
                original.getAckUserId(),
                edited.getAckUserId()));
        clear.setAckSystemId(clearStringProperties(
                original.getAckSystemId(),
                edited.getAckSystemId()));
        clear.setClearUserId(clearStringProperties(
                original.getClearUserId(),
                edited.getClearUserId()));
        clear.setClearSystemId(clearStringProperties(
                original.getClearSystemId(),
                edited.getClearSystemId()));
        clear.setPlannedOutageIndicator(clearStringProperties(
                original.getPlannedOutageIndicator(),
                edited.getPlannedOutageIndicator()));
        clear.setAlarmEscelation(clearStringProperties(
                original.getAlarmEscelation(),
                edited.getAlarmEscelation()));
        clear.setServiceAffecting(clearStringProperties(
                original.getServiceAffecting(),
                edited.getServiceAffecting()));

        //list objects -------------------------------------------------------------
        clear.setAffectedService((List<AffectedService>) clearList(
                original.getAffectedService(),
                edited.getAffectedService()
        ));
        //--------------------------------------------------------------------------

        clear.setIsRootCause(clearStringProperties(
                original.getIsRootCause(),
                edited.getIsRootCause()));

        //list objects -------------------------------------------------------------

        clear.setCorrelatedAlarm((List<CorrelatedAlarm>) clearList(
                original.getCorrelatedAlarm(),
                edited.getCorrelatedAlarm()
        ));

        //--------------------------------------------------------------------------

        //list objects -------------------------------------------------------------
        clear.setParentAlarm((List<ParentAlarm>) clearList(
                original.getParentAlarm(),
                edited.getParentAlarm()
        ));
        //--------------------------------------------------------------------------

        //object -----------------------------------------------------
        clear.setCrossedThresholdInformation(clearCrossedThresholdInformation(
                original.getCrossedThresholdInformation(),
                edited.getCrossedThresholdInformation()
        ));
        //------------------------------------------------------------

        //list objects -------------------------------------------------------------
        clear.setComments((List<Comments>) clearList(
                original.getComments(),
                edited.getComments()
        ));
        //--------------------------------------------------------------------------

        return clear;

    }

    private static CrossedThresholdInformation clearCrossedThresholdInformation(
            CrossedThresholdInformation original,
            CrossedThresholdInformation edited) {
        if (edited != null) {
            return null;
        } else
            return original;
    }

    private static List<?> clearList(
            List<?> original,
            List<?> edited) {
        if (edited != null) {
            return null;
        } else
            return original;
    }

    private static OffsetDateTime clearOffsetDateTime(
            OffsetDateTime original,
            OffsetDateTime edited) {
        if (edited != null) {
            return null;
        } else
            return original;
    }

    private static AlarmedObject clearAlarmedObject(
            AlarmedObject original,
            AlarmedObject edited) {
        if (edited != null) {
            return null;
        } else
            return original;
    }

    private static String clearStringProperties(
            String original,
            String edited) {
        if (edited != null) {
            return null;
        } else
            return original;
    }

    public static Alarm updateProperties(Alarm original, Alarm edited) {

        Alarm update = new Alarm();
        update.setHref((String) PropertiesUtils.copyStringProperties(
                original.getHref(),
                edited.getHref()));
        update.setType((String) PropertiesUtils.copyStringProperties(
                original.getType(),
                edited.getType()));
        update.setBaseType((String) PropertiesUtils.copyStringProperties(
                original.getBaseType(),
                edited.getBaseType()));
        update.setSchemaLocation((String) PropertiesUtils.copyStringProperties(
                original.getSchemaLocation(),
                edited.getSchemaLocation()));
        update.setExternalAlarmId((String) PropertiesUtils.copyStringProperties(
                original.getExternalAlarmId(),
                edited.getExternalAlarmId()));
        update.setAlarmType((String) PropertiesUtils.copyStringProperties(
                original.getAlarmType(),
                edited.getAlarmType()));
        update.setPerceivedSeverity((String) PropertiesUtils.copyStringProperties(
                original.getPerceivedSeverity(),
                edited.getPerceivedSeverity()));
        update.setAlarmedObjectType((String) PropertiesUtils.copyStringProperties(
                original.getAlarmedObjectType(),
                edited.getAlarmedObjectType()));

        //object -----------------------------------------------------
        AlarmedObject alarmedObject = updateAlarmedObject(
                original.getAlarmedObject(),
                edited.getAlarmedObject());
        if (alarmedObject != null) {
            update.setAlarmedObject(alarmedObject);
        }
        //------------------------------------------------------------

        update.setSourceSystemId((String) PropertiesUtils.copyStringProperties(
                original.getSourceSystemId(),
                edited.getSourceSystemId()));
        update.setAlarmDetails((String) PropertiesUtils.copyStringProperties(
                original.getAlarmDetails(),
                edited.getAlarmDetails()));
        update.setState((String) PropertiesUtils.copyStringProperties(
                original.getState(),
                edited.getState()));

        //OffsetDateTime
        update.setAlarmRaisedTime((OffsetDateTime) PropertiesUtils.copyOffsetDateTimeProperties(
                original.getAlarmRaisedTime(),
                edited.getAlarmRaisedTime()));

        //OffsetDateTime
        update.setAlarmChangedTime((OffsetDateTime) PropertiesUtils.copyOffsetDateTimeProperties(
                original.getAlarmChangedTime(),
                edited.getAlarmChangedTime()));

        //OffsetDateTime
        update.setAlarmClearedTime((OffsetDateTime) PropertiesUtils.copyOffsetDateTimeProperties(
                original.getAlarmClearedTime(),
                edited.getAlarmClearedTime()));

        update.setProposedRepairedActions((String) PropertiesUtils.copyStringProperties(
                original.getProposedRepairedActions(),
                edited.getProposedRepairedActions()));

        //OffsetDateTime
        update.setAlarmReportingTime((OffsetDateTime) PropertiesUtils.copyOffsetDateTimeProperties(
                original.getAlarmReportingTime(),
                edited.getAlarmReportingTime()));

        update.setAckState((String) PropertiesUtils.copyStringProperties(
                original.getAckState(),
                edited.getAckState()));
        update.setAckUserId((String) PropertiesUtils.copyStringProperties(
                original.getAckUserId(),
                edited.getAckUserId()));
        update.setAckSystemId((String) PropertiesUtils.copyStringProperties(
                original.getAckSystemId(),
                edited.getAckSystemId()));
        update.setClearUserId((String) PropertiesUtils.copyStringProperties(
                original.getClearUserId(),
                edited.getClearUserId()));
        update.setClearSystemId((String) PropertiesUtils.copyStringProperties(
                original.getClearSystemId(),
                edited.getClearSystemId()));
        update.setPlannedOutageIndicator((String) PropertiesUtils.copyStringProperties(
                original.getPlannedOutageIndicator(),
                edited.getPlannedOutageIndicator()));
        update.setAlarmEscelation((String) PropertiesUtils.copyStringProperties(
                original.getAlarmEscelation(),
                edited.getAlarmEscelation()));
        update.setServiceAffecting((String) PropertiesUtils.copyStringProperties(
                original.getServiceAffecting(),
                edited.getServiceAffecting()));

        //list objects -------------------------------------------------------------
        List<AffectedService> affectedServicesUpdate = processAffectedService(
                original.getAffectedService(),
                edited.getAffectedService());
        if (affectedServicesUpdate != null) {
            update.setAffectedService(affectedServicesUpdate);
        }
        //--------------------------------------------------------------------------

        update.setIsRootCause((String) PropertiesUtils.copyStringProperties(
                original.getIsRootCause(),
                edited.getIsRootCause()));

        //list objects -------------------------------------------------------------
        List<CorrelatedAlarm> correlatedAlarmsUpdate = processCorrelatedAlarm(
                original.getCorrelatedAlarm(),
                edited.getCorrelatedAlarm());
        if (correlatedAlarmsUpdate != null) {
            update.setCorrelatedAlarm(correlatedAlarmsUpdate);
        }
        //--------------------------------------------------------------------------

        //list objects -------------------------------------------------------------
        List<ParentAlarm> parentAlarmsUpdate = processParentAlarm(
                original.getParentAlarm(),
                edited.getParentAlarm());
        if (parentAlarmsUpdate != null) {
            update.setParentAlarm(parentAlarmsUpdate);
        }
        //--------------------------------------------------------------------------

        //object -----------------------------------------------------
        CrossedThresholdInformation crossedThresholdInformation =
                processCrossedThresholdInformation(
                        original.getCrossedThresholdInformation(),
                        edited.getCrossedThresholdInformation());
        if (crossedThresholdInformation != null) {
            update.setCrossedThresholdInformation(crossedThresholdInformation);
        }
        //------------------------------------------------------------

        //list objects -------------------------------------------------------------
        List<Comments> commentsUpdate = processComments(
                original.getComments(),
                edited.getComments());
        if (commentsUpdate != null) {
            update.setComments(commentsUpdate);
        }
        //--------------------------------------------------------------------------

        return update;
    }

    private static List<Comments> processComments(
            List<Comments> original,
            List<Comments> edited) {
        List<Comments> update = new ArrayList<>();
        if (original != null && edited != null) {
            original.forEach(itemOriginal -> {
                Comments comments = new Comments();
                comments.setUserId(itemOriginal.getUserId());
                comments.setTime(itemOriginal.getTime());
                comments.setComment(itemOriginal.getComment());
                update.add(comments);
            });
            updateComments(edited, update);
            return update;
        } else if (original == null && edited != null) {
            updateComments(edited, update);
            return update;
        } else if (original != null) {
            return original;
        } else
            return null;
    }

    private static void updateComments(
            List<Comments> edited,
            List<Comments> update) {
        edited.forEach(item -> {
            if (item.getSystemId() != null) {
                item.setSystemId(null);
                update.add(item);
            }
        });
    }

    private static List<ParentAlarm> processParentAlarm(
            List<ParentAlarm> original,
            List<ParentAlarm> edited) {
        List<ParentAlarm> update = new ArrayList<>();
        if (original != null && edited != null) {
            original.forEach(itemOriginal -> {
                ParentAlarm parentAlarm =
                        new ParentAlarm();
                parentAlarm.setHref(itemOriginal.getHref());
                update.add(parentAlarm);
            });
            updateParentAlarm(edited, update);
            return update;
        } else if (original == null && edited != null) {
            updateParentAlarm(edited, update);
            return update;
        } else if (original != null) {
            return original;
        } else
            return null;
    }

    private static void updateParentAlarm(
            List<ParentAlarm> edited,
            List<ParentAlarm> update) {
        edited.forEach(item -> {
            if (item.getId() != null) {
                item.setId(null);
                update.add(item);
            }
        });
    }

    private static CrossedThresholdInformation processCrossedThresholdInformation(
            CrossedThresholdInformation original,
            CrossedThresholdInformation edited) {
        CrossedThresholdInformation crossedThresholdInformation =
                new CrossedThresholdInformation();
        if (original != null && edited != null) {
            crossedThresholdInformation.setThresholdRef(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getThresholdRef(),
                            edited.getThresholdRef()));
            crossedThresholdInformation.setIndicatorName(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getIndicatorName(),
                            edited.getIndicatorName()));
            crossedThresholdInformation.setObservedValue(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getObservedValue(),
                            edited.getObservedValue()));
            crossedThresholdInformation.setIndicatorUnit(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getIndicatorUnit(),
                            edited.getIndicatorUnit()));
            crossedThresholdInformation.setGranularity(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getGranularity(),
                            edited.getGranularity()));
            crossedThresholdInformation.setDirection(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getDirection(),
                            edited.getDirection()));
            crossedThresholdInformation.setThresholdCrossingDescription(
                    (String) PropertiesUtils.copyStringProperties(
                            original.getThresholdCrossingDescription(),
                            edited.getThresholdCrossingDescription()));
            return crossedThresholdInformation;
        } else if (original == null && edited != null) {
            crossedThresholdInformation.setThresholdRef(
                    edited.getThresholdRef());
            crossedThresholdInformation.setIndicatorName(
                    edited.getIndicatorName());
            crossedThresholdInformation.setObservedValue(
                    edited.getObservedValue());
            crossedThresholdInformation.setIndicatorUnit(
                    edited.getIndicatorUnit());
            crossedThresholdInformation.setGranularity(
                    edited.getGranularity());
            crossedThresholdInformation.setDirection(
                    edited.getDirection());
            crossedThresholdInformation.setThresholdCrossingDescription(
                    edited.getThresholdCrossingDescription());
            return crossedThresholdInformation;
        } else if (original != null) {
            return original;
        } else
            return null;
    }

    private static AlarmedObject updateAlarmedObject(
            AlarmedObject original,
            AlarmedObject edited) {
        AlarmedObject alarmedObject = new AlarmedObject();
        if (original != null && edited != null && !edited.getHref().equals("string")) {
            alarmedObject.setHref((String) PropertiesUtils.copyStringProperties(
                    original.getHref(),
                    edited.getHref()));
            String id = original.getId();
            BeanUtils.copyProperties(alarmedObject, original);
            original.setId(id);
            return original;
        } else if (original == null && edited != null && !edited.getHref().equals("string")) {
            alarmedObject.setHref(edited.getHref());
            return alarmedObject;
        } else if (original != null) {
            return original;
        } else
            return null;
    }

    private static List<CorrelatedAlarm> processCorrelatedAlarm(
            List<CorrelatedAlarm> original,
            List<CorrelatedAlarm> edited) {
        List<CorrelatedAlarm> update = new ArrayList<>();
        if (original != null && edited != null) {
            original.forEach(itemOriginal -> {
                CorrelatedAlarm correlatedAlarm =
                        new CorrelatedAlarm();
                correlatedAlarm.setHref(itemOriginal.getHref());
                update.add(correlatedAlarm);
            });
            updateCorrelatedAlarm(edited, update);
            return update;
        } else if (original == null && edited != null) {
            updateCorrelatedAlarm(edited, update);
            return update;
        } else if (original != null) {
            return original;
        } else
            return null;
    }

    private static void updateCorrelatedAlarm(
            List<CorrelatedAlarm> edited,
            List<CorrelatedAlarm> update) {
        edited.forEach(item -> {
            if (item.getId() != null) {
                item.setId(null);
                update.add(item);
            }
        });
    }

    private static List<AffectedService> processAffectedService(
            List<AffectedService> original,
            List<AffectedService> edited) {
        List<AffectedService> update = new ArrayList<>();
        if (original != null && edited != null) {
            original.forEach(itemOriginal -> {
                AffectedService affectedService =
                        new AffectedService();
                affectedService.setHref(itemOriginal.getHref());
                update.add(affectedService);
            });
            updateAffectedService(edited, update);
            return update;
        } else if (original == null && edited != null) {
            updateAffectedService(edited, update);
            return update;
        } else if (original != null) {
            return original;
        } else
            return null;
    }

    private static void updateAffectedService(
            List<AffectedService> edited,
            List<AffectedService> update) {
        edited.forEach(item -> {
            if (item.getId() != null) {
                item.setId(null);
                update.add(item);
            }
        });
    }

    private static String copyStringProperties(String oldValue, String newValue) {
        if (newValue != null && !newValue.equals("string"))
            return newValue;
        else
            return oldValue;
    }

    private static OffsetDateTime copyOffsetDateTimeProperties(OffsetDateTime oldValue, OffsetDateTime newValue) {
        if (newValue != null)
            return newValue;
        else
            return oldValue;
    }


}
