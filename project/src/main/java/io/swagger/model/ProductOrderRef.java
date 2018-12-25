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
 * ProductOrder (ProductOrder) .The product order which the recommendation is related with.
 */
@ApiModel(description = "ProductOrder (ProductOrder) .The product order which the recommendation is related with.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T18:33:01.088+03:00")

public class ProductOrderRef   {
  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  public ProductOrderRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hypertext Reference of the product order.
   * @return href
  **/
  @ApiModelProperty(value = "Hypertext Reference of the product order.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public ProductOrderRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of product order
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of product order")


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
    ProductOrderRef productOrderRef = (ProductOrderRef) o;
    return Objects.equals(this.href, productOrderRef.href) &&
        Objects.equals(this.id, productOrderRef.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOrderRef {\n");
    
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

