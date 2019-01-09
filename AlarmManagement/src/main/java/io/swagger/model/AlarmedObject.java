package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * 
 */
@ApiModel(description = "")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-06T21:03:59.754+03:00")

@Entity
public class AlarmedObject   {
  @JsonProperty("href")
  @Column
  private String href = null;

  @JsonProperty("id")
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column
  private String id = null;

  public AlarmedObject href(String href) {
    this.href = href;
    return this;
  }

  /**
   * A reference to the alarm
   * @return href
  **/
  @ApiModelProperty(value = "A reference to the alarm")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AlarmedObject id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The identifier of the object associated with the event
   * @return id
  **/
  @ApiModelProperty(value = "The identifier of the object associated with the event")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AlarmedObject alarmedObject = (AlarmedObject) o;
    return Objects.equals(this.href, alarmedObject.href) &&
        Objects.equals(this.id, alarmedObject.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AlarmedObject {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

