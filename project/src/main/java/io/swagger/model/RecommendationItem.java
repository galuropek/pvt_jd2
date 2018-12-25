package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ProductOfferingRef;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * A list of recommendation items. Every item is a product offering and its rank.
 */
@ApiModel(description = "A list of recommendation items. Every item is a product offering and its rank.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T18:33:01.088+03:00")

public class RecommendationItem   {
  @JsonProperty("priority")
  private Integer priority = null;

  @JsonProperty("offering")
  private ProductOfferingRef offering = null;

  public RecommendationItem priority(Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * The rank of the list of recommended offering.
   * @return priority
  **/
  @ApiModelProperty(value = "The rank of the list of recommended offering.")


  public Integer getPriority() {
    return priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public RecommendationItem offering(ProductOfferingRef offering) {
    this.offering = offering;
    return this;
  }

  /**
   * Get offering
   * @return offering
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ProductOfferingRef getOffering() {
    return offering;
  }

  public void setOffering(ProductOfferingRef offering) {
    this.offering = offering;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecommendationItem recommendationItem = (RecommendationItem) o;
    return Objects.equals(this.priority, recommendationItem.priority) &&
        Objects.equals(this.offering, recommendationItem.offering);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priority, offering);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecommendationItem {\n");
    
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    offering: ").append(toIndentedString(offering)).append("\n");
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

