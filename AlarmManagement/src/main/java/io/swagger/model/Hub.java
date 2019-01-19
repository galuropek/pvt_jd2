package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Hub
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-01-06T21:03:59.754+03:00")

@Entity
public class Hub   {
  @JsonProperty("id")
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id = null;

  @JsonProperty("callback")
  @Column
  private String callback = null;

  @JsonProperty("query")
  @Column
  private String query = null;

  public Hub id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Hub callback(String callback) {
    this.callback = callback;
    return this;
  }

  /**
   * Get callback
   * @return callback
  **/
  @ApiModelProperty(value = "")


  public String getCallback() {
    return callback;
  }

  public void setCallback(String callback) {
    this.callback = callback;
  }

  public Hub query(String query) {
    this.query = query;
    return this;
  }

  /**
   * Get query
   * @return query
  **/
  @ApiModelProperty(value = "hub")


  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Hub hub = (Hub) o;
    return Objects.equals(this.id, hub.id) &&
        Objects.equals(this.callback, hub.callback) &&
        Objects.equals(this.query, hub.query);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, callback, query);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Hub {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    callback: ").append(toIndentedString(callback)).append("\n");
    sb.append("    query: ").append(toIndentedString(query)).append("\n");
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

