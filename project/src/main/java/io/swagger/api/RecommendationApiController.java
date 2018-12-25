package io.swagger.api;

import io.swagger.model.Error;
import org.threeten.bp.OffsetDateTime;
import io.swagger.model.Recommendation;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T18:33:01.088+03:00")

@Controller
public class RecommendationApiController implements RecommendationApi {

    private static final Logger log = LoggerFactory.getLogger(RecommendationApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RecommendationApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Recommendation>> listRecommendation(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields,@ApiParam(value = "For filtering: It indicates the base type of REST resource.") @Valid @RequestParam(value = "@baseType", required = false) String baseType,@ApiParam(value = "For filtering: It provides the link to the schema describing REST resource") @Valid @RequestParam(value = "@schemaLocation", required = false) String schemaLocation,@ApiParam(value = "For filtering: It indicates the class type of the catalog.") @Valid @RequestParam(value = "@type", required = false) String type,@ApiParam(value = "For filtering: Name of recommendation") @Valid @RequestParam(value = "name", required = false) String name,@ApiParam(value = "For filtering: Type of recommendation. The basic type is : 'AD': it means the recommendation is the advertisement for display 'OFFER': it means the recommended content is the offer entry page. By clicking it, the user can be forwarded to the details of the offering") @Valid @RequestParam(value = "type", required = false) String type2,@ApiParam(value = "For filtering: An instant of time, ending at the TimePeriod.") @Valid @RequestParam(value = "validFor.endDateTime", required = false) OffsetDateTime validForEndDateTime,@ApiParam(value = "For filtering: An instant of time, starting at the TimePeriod") @Valid @RequestParam(value = "validFor.startDateTime", required = false) OffsetDateTime validForStartDateTime,@ApiParam(value = "For filtering: Name of the geographic location.") @Valid @RequestParam(value = "location.name", required = false) String locationName,@ApiParam(value = "For filtering: Type of the geographic location.") @Valid @RequestParam(value = "location.type", required = false) String locationType,@ApiParam(value = "For filtering: The rank of the list of recommended offering.") @Valid @RequestParam(value = "item.priority", required = false) Integer itemPriority,@ApiParam(value = "For filtering: Name of the related party.") @Valid @RequestParam(value = "party.name", required = false) String partyName,@ApiParam(value = "For filtering: Role of the related party.") @Valid @RequestParam(value = "party.role", required = false) String partyRole,@ApiParam(value = "For filtering: Name of the category.") @Valid @RequestParam(value = "category.name", required = false) String categoryName,@ApiParam(value = "For filtering: Name of the channel.") @Valid @RequestParam(value = "channel.name", required = false) String channelName) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Recommendation>>(objectMapper.readValue("[ {  \"item\" : [ {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  }, {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"channel\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"description\" : \"description\",  \"type\" : \"type\",  \"@baseType\" : \"@baseType\",  \"shoppingcart\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"name\" : \"name\",  \"location\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  },  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"party\" : {    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"order\" : {    \"href\" : \"href\",    \"id\" : \"id\"  }}, {  \"item\" : [ {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  }, {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"channel\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"description\" : \"description\",  \"type\" : \"type\",  \"@baseType\" : \"@baseType\",  \"shoppingcart\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"name\" : \"name\",  \"location\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  },  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"party\" : {    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"order\" : {    \"href\" : \"href\",    \"id\" : \"id\"  }} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Recommendation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Recommendation>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Recommendation>> retrieveRecommendation(@ApiParam(value = "Identifier of the Recommendation",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Recommendation>>(objectMapper.readValue("[ {  \"item\" : [ {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  }, {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"channel\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"description\" : \"description\",  \"type\" : \"type\",  \"@baseType\" : \"@baseType\",  \"shoppingcart\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"name\" : \"name\",  \"location\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  },  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"party\" : {    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"order\" : {    \"href\" : \"href\",    \"id\" : \"id\"  }}, {  \"item\" : [ {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  }, {    \"offering\" : {      \"name\" : \"name\",      \"href\" : \"href\",      \"id\" : \"id\"    },    \"priority\" : 0  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"@type\" : \"@type\",  \"channel\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"description\" : \"description\",  \"type\" : \"type\",  \"@baseType\" : \"@baseType\",  \"shoppingcart\" : {    \"href\" : \"href\",    \"id\" : \"id\"  },  \"name\" : \"name\",  \"location\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\",    \"type\" : \"type\"  },  \"href\" : \"href\",  \"id\" : \"id\",  \"@schemaLocation\" : \"@schemaLocation\",  \"category\" : {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"party\" : {    \"role\" : \"role\",    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"order\" : {    \"href\" : \"href\",    \"id\" : \"id\"  }} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Recommendation>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Recommendation>>(HttpStatus.NOT_IMPLEMENTED);
    }

}
