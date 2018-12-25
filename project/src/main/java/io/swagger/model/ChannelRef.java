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
 * Channel(ChannelRef)The channel where the recommendation is used. May be online web, mobile app, social ,etc.
 */
@ApiModel(description = "Channel(ChannelRef)The channel where the recommendation is used. May be online web, mobile app, social ,etc.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T18:33:01.088+03:00")

public class ChannelRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  public ChannelRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hypertext Reference of the channel.
   * @return href
  **/
  @ApiModelProperty(value = "Hypertext Reference of the channel.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ChannelRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of channel
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of channel")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ChannelRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the channel.
   * @return name
  **/
  @ApiModelProperty(value = "Name of the channel.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChannelRef channelRef = (ChannelRef) o;
    return Objects.equals(this.href, channelRef.href) &&
        Objects.equals(this.id, channelRef.id) &&
        Objects.equals(this.name, channelRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChannelRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

