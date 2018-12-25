package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.CategoryRef;
import io.swagger.model.ChannelRef;
import io.swagger.model.GeographicLocationRef;
import io.swagger.model.ProductOrderRef;
import io.swagger.model.RecommendationItem;
import io.swagger.model.RelatedPartyRef;
import io.swagger.model.ShoppingCartRef;
import io.swagger.model.TimePeriod;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Recommendation API is used to recommend offering quickly based on the history and real-time context of customer. It is a real-time and personalized recommendation API. It is usually provided by e-commerce or BSS, CRM system in omni-channel.
 */
@ApiModel(description = "Recommendation API is used to recommend offering quickly based on the history and real-time context of customer. It is a real-time and personalized recommendation API. It is usually provided by e-commerce or BSS, CRM system in omni-channel.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T18:33:01.088+03:00")

public class Recommendation   {
  @JsonProperty("@baseType")
  private String baseType = null;

  @JsonProperty("@schemaLocation")
  private String schemaLocation = null;

  @JsonProperty("@type")
  private String type = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("href")
  private String href = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("validFor")
  private TimePeriod validFor = null;

  @JsonProperty("order")
  private ProductOrderRef order = null;

  @JsonProperty("shoppingcart")
  private ShoppingCartRef shoppingcart = null;

  @JsonProperty("location")
  private GeographicLocationRef location = null;

  @JsonProperty("item")
  @Valid
  private List<RecommendationItem> item = null;

  @JsonProperty("party")
  private RelatedPartyRef party = null;

  @JsonProperty("category")
  private CategoryRef category = null;

  @JsonProperty("channel")
  private ChannelRef channel = null;

  public Recommendation baseType(String baseType) {
    this.baseType = baseType;
    return this;
  }

  /**
   * It indicates the base type of REST resource.
   * @return baseType
  **/
  @ApiModelProperty(value = "It indicates the base type of REST resource.")


  public String getBaseType() {
    return baseType;
  }

  public void setBaseType(String baseType) {
    this.baseType = baseType;
  }

  public Recommendation schemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
    return this;
  }

  /**
   * It provides the link to the schema describing REST resource
   * @return schemaLocation
  **/
  @ApiModelProperty(value = "It provides the link to the schema describing REST resource")


  public String getSchemaLocation() {
    return schemaLocation;
  }

  public void setSchemaLocation(String schemaLocation) {
    this.schemaLocation = schemaLocation;
  }

  public Recommendation type(String type) {
    this.type = type;
    return this;
  }

  /**
   * It indicates the class type of the catalog.
   * @return type
  **/
  @ApiModelProperty(value = "It indicates the class type of the catalog.")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Recommendation description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Recommendation href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Hypertext Reference of the recommendation.
   * @return href
  **/
  @ApiModelProperty(value = "Hypertext Reference of the recommendation.")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Recommendation id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of recommendation
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of recommendation")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Recommendation name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of recommendation
   * @return name
  **/
  @ApiModelProperty(value = "Name of recommendation")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Recommendation type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Type of recommendation. The basic type is : 'AD': it means the recommendation is the advertisement for display 'OFFER': it means the recommended content is the offer entry page. By clicking it, the user can be forwarded to the details of the offering
   * @return type
  **/
  @ApiModelProperty(value = "Type of recommendation. The basic type is : 'AD': it means the recommendation is the advertisement for display 'OFFER': it means the recommended content is the offer entry page. By clicking it, the user can be forwarded to the details of the offering")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Recommendation validFor(TimePeriod validFor) {
    this.validFor = validFor;
    return this;
  }

  /**
   * The period in which the recommendation is valid.
   * @return validFor
  **/
  @ApiModelProperty(value = "The period in which the recommendation is valid.")

  @Valid

  public TimePeriod getValidFor() {
    return validFor;
  }

  public void setValidFor(TimePeriod validFor) {
    this.validFor = validFor;
  }

  public Recommendation order(ProductOrderRef order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ProductOrderRef getOrder() {
    return order;
  }

  public void setOrder(ProductOrderRef order) {
    this.order = order;
  }

  public Recommendation shoppingcart(ShoppingCartRef shoppingcart) {
    this.shoppingcart = shoppingcart;
    return this;
  }

  /**
   * Get shoppingcart
   * @return shoppingcart
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ShoppingCartRef getShoppingcart() {
    return shoppingcart;
  }

  public void setShoppingcart(ShoppingCartRef shoppingcart) {
    this.shoppingcart = shoppingcart;
  }

  public Recommendation location(GeographicLocationRef location) {
    this.location = location;
    return this;
  }

  /**
   * Get location
   * @return location
  **/
  @ApiModelProperty(value = "")

  @Valid

  public GeographicLocationRef getLocation() {
    return location;
  }

  public void setLocation(GeographicLocationRef location) {
    this.location = location;
  }

  public Recommendation item(List<RecommendationItem> item) {
    this.item = item;
    return this;
  }

  public Recommendation addItemItem(RecommendationItem itemItem) {
    if (this.item == null) {
      this.item = new ArrayList<RecommendationItem>();
    }
    this.item.add(itemItem);
    return this;
  }

  /**
   * Get item
   * @return item
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<RecommendationItem> getItem() {
    return item;
  }

  public void setItem(List<RecommendationItem> item) {
    this.item = item;
  }

  public Recommendation party(RelatedPartyRef party) {
    this.party = party;
    return this;
  }

  /**
   * Get party
   * @return party
  **/
  @ApiModelProperty(value = "")

  @Valid

  public RelatedPartyRef getParty() {
    return party;
  }

  public void setParty(RelatedPartyRef party) {
    this.party = party;
  }

  public Recommendation category(CategoryRef category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  **/
  @ApiModelProperty(value = "")

  @Valid

  public CategoryRef getCategory() {
    return category;
  }

  public void setCategory(CategoryRef category) {
    this.category = category;
  }

  public Recommendation channel(ChannelRef channel) {
    this.channel = channel;
    return this;
  }

  /**
   * Get channel
   * @return channel
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ChannelRef getChannel() {
    return channel;
  }

  public void setChannel(ChannelRef channel) {
    this.channel = channel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recommendation recommendation = (Recommendation) o;
    return Objects.equals(this.baseType, recommendation.baseType) &&
        Objects.equals(this.schemaLocation, recommendation.schemaLocation) &&
        Objects.equals(this.type, recommendation.type) &&
        Objects.equals(this.description, recommendation.description) &&
        Objects.equals(this.href, recommendation.href) &&
        Objects.equals(this.id, recommendation.id) &&
        Objects.equals(this.name, recommendation.name) &&
        Objects.equals(this.type, recommendation.type) &&
        Objects.equals(this.validFor, recommendation.validFor) &&
        Objects.equals(this.order, recommendation.order) &&
        Objects.equals(this.shoppingcart, recommendation.shoppingcart) &&
        Objects.equals(this.location, recommendation.location) &&
        Objects.equals(this.item, recommendation.item) &&
        Objects.equals(this.party, recommendation.party) &&
        Objects.equals(this.category, recommendation.category) &&
        Objects.equals(this.channel, recommendation.channel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(baseType, schemaLocation, type, description, href, id, name, type, validFor, order, shoppingcart, location, item, party, category, channel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recommendation {\n");
    
    sb.append("    baseType: ").append(toIndentedString(baseType)).append("\n");
    sb.append("    schemaLocation: ").append(toIndentedString(schemaLocation)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    shoppingcart: ").append(toIndentedString(shoppingcart)).append("\n");
    sb.append("    location: ").append(toIndentedString(location)).append("\n");
    sb.append("    item: ").append(toIndentedString(item)).append("\n");
    sb.append("    party: ").append(toIndentedString(party)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
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

