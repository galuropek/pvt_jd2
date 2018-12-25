package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * GeographicLocation (GeographicLocationRef) The geographic location which the recommendation is related with
 */
@ApiModel(description = "GeographicLocation (GeographicLocationRef) The geographic location which the recommendation is related with")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T18:33:01.088+03:00")

public class GeographicLocationRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  public GeographicLocationRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hypertext Reference of the geographic location.
   * @return href
  **/
  @ApiModelProperty(value = "Hypertext Reference of the geographic location.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public GeographicLocationRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of geographic location
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of geographic location")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GeographicLocationRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the geographic location.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the geographic location.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GeographicLocationRef type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of the geographic location.
   * @return type
  **/
  @ApiModelProperty(value = "Type of the geographic location.")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GeographicLocationRef geographicLocationRef = (GeographicLocationRef) o;
    return Objects.equals(this.href, geographicLocationRef.href) &&
        Objects.equals(this.id, geographicLocationRef.id) &&
        Objects.equals(this.name, geographicLocationRef.name) &&
        Objects.equals(this.type, geographicLocationRef.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GeographicLocationRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

