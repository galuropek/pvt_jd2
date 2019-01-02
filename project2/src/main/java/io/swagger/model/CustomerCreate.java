package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AccountRef;
import io.swagger.model.AgreementRef;
import io.swagger.model.Characteristic;
import io.swagger.model.ContactMedium;
import io.swagger.model.CreditProfile;
import io.swagger.model.PartyRef;
import io.swagger.model.PaymentMethodRef;
import io.swagger.model.RelatedPartyRef;
import io.swagger.model.RoleTypeRef;
import io.swagger.model.TimePeriod;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Skipped properties: id,href
 */
@ApiModel(description = " Skipped properties: id,href")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-22T19:45:02.882+03:00")

public class CustomerCreate {
    @JsonProperty("name")
    private String name = null;

    @JsonProperty("status")
    private String status = null;

    @JsonProperty("statusReason")
    private String statusReason = null;

    @JsonProperty("validFor")
    private TimePeriod validFor = null;

    @JsonProperty("engagedParty")
    private PartyRef engagedParty = null;

    @JsonProperty("type")
    private RoleTypeRef type = null;

    @JsonProperty("account")
    @Valid
    private List<AccountRef> account = null;

    @JsonProperty("paymentMethod")
    @Valid
    private List<PaymentMethodRef> paymentMethod = null;

    @JsonProperty("contactMedium")
    @Valid
    private List<ContactMedium> contactMedium = null;

    @JsonProperty("characteristic")
    @Valid
    private List<Characteristic> characteristic = null;

    @JsonProperty("creditProfile")
    @Valid
    private List<CreditProfile> creditProfile = null;

    @JsonProperty("agreement")
    @Valid
    private List<AgreementRef> agreement = null;

    @JsonProperty("relatedParty")
    @Valid
    private List<RelatedPartyRef> relatedParty = null;

    public CustomerCreate name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.
     *
     * @return name
     **/
    @ApiModelProperty(required = true, value = "A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.")
    @NotNull


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerCreate status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Used to track the lifecycle status of the party role.
     *
     * @return status
     **/
    @ApiModelProperty(value = "Used to track the lifecycle status of the party role.")


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CustomerCreate statusReason(String statusReason) {
        this.statusReason = statusReason;
        return this;
    }

    /**
     * A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.
     *
     * @return statusReason
     **/
    @ApiModelProperty(value = "A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.")


    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public CustomerCreate validFor(TimePeriod validFor) {
        this.validFor = validFor;
        return this;
    }

    /**
     * The time period that the PartyRole is valid for.
     *
     * @return validFor
     **/
    @ApiModelProperty(value = "The time period that the PartyRole is valid for.")

    @Valid

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public CustomerCreate engagedParty(PartyRef engagedParty) {
        this.engagedParty = engagedParty;
        return this;
    }

    /**
     * Get engagedParty
     *
     * @return engagedParty
     **/
    @ApiModelProperty(value = "")

    @Valid

    public PartyRef getEngagedParty() {
        return engagedParty;
    }

    public void setEngagedParty(PartyRef engagedParty) {
        this.engagedParty = engagedParty;
    }

    public CustomerCreate type(RoleTypeRef type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(required = true, value = "")
    @NotNull

    @Valid

    public RoleTypeRef getType() {
        return type;
    }

    public void setType(RoleTypeRef type) {
        this.type = type;
    }

    public CustomerCreate account(List<AccountRef> account) {
        this.account = account;
        return this;
    }

    public CustomerCreate addAccountItem(AccountRef accountItem) {
        if (this.account == null) {
            this.account = new ArrayList<AccountRef>();
        }
        this.account.add(accountItem);
        return this;
    }

    /**
     * Get account
     *
     * @return account
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<AccountRef> getAccount() {
        return account;
    }

    public void setAccount(List<AccountRef> account) {
        this.account = account;
    }

    public CustomerCreate paymentMethod(List<PaymentMethodRef> paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public CustomerCreate addPaymentMethodItem(PaymentMethodRef paymentMethodItem) {
        if (this.paymentMethod == null) {
            this.paymentMethod = new ArrayList<PaymentMethodRef>();
        }
        this.paymentMethod.add(paymentMethodItem);
        return this;
    }

    /**
     * Get paymentMethod
     *
     * @return paymentMethod
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<PaymentMethodRef> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<PaymentMethodRef> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CustomerCreate contactMedium(List<ContactMedium> contactMedium) {
        this.contactMedium = contactMedium;
        return this;
    }

    public CustomerCreate addContactMediumItem(ContactMedium contactMediumItem) {
        if (this.contactMedium == null) {
            this.contactMedium = new ArrayList<ContactMedium>();
        }
        this.contactMedium.add(contactMediumItem);
        return this;
    }

    /**
     * Get contactMedium
     *
     * @return contactMedium
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<ContactMedium> getContactMedium() {
        return contactMedium;
    }

    public void setContactMedium(List<ContactMedium> contactMedium) {
        this.contactMedium = contactMedium;
    }

    public CustomerCreate characteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
        return this;
    }

    public CustomerCreate addCharacteristicItem(Characteristic characteristicItem) {
        if (this.characteristic == null) {
            this.characteristic = new ArrayList<Characteristic>();
        }
        this.characteristic.add(characteristicItem);
        return this;
    }

    /**
     * Get characteristic
     *
     * @return characteristic
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Characteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
    }

    public CustomerCreate creditProfile(List<CreditProfile> creditProfile) {
        this.creditProfile = creditProfile;
        return this;
    }

    public CustomerCreate addCreditProfileItem(CreditProfile creditProfileItem) {
        if (this.creditProfile == null) {
            this.creditProfile = new ArrayList<CreditProfile>();
        }
        this.creditProfile.add(creditProfileItem);
        return this;
    }

    /**
     * Get creditProfile
     *
     * @return creditProfile
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<CreditProfile> getCreditProfile() {
        return creditProfile;
    }

    public void setCreditProfile(List<CreditProfile> creditProfile) {
        this.creditProfile = creditProfile;
    }

    public CustomerCreate agreement(List<AgreementRef> agreement) {
        this.agreement = agreement;
        return this;
    }

    public CustomerCreate addAgreementItem(AgreementRef agreementItem) {
        if (this.agreement == null) {
            this.agreement = new ArrayList<AgreementRef>();
        }
        this.agreement.add(agreementItem);
        return this;
    }

    /**
     * Get agreement
     *
     * @return agreement
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<AgreementRef> getAgreement() {
        return agreement;
    }

    public void setAgreement(List<AgreementRef> agreement) {
        this.agreement = agreement;
    }

    public CustomerCreate relatedParty(List<RelatedPartyRef> relatedParty) {
        this.relatedParty = relatedParty;
        return this;
    }

    public CustomerCreate addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
        if (this.relatedParty == null) {
            this.relatedParty = new ArrayList<RelatedPartyRef>();
        }
        this.relatedParty.add(relatedPartyItem);
        return this;
    }

    /**
     * Get relatedParty
     *
     * @return relatedParty
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<RelatedPartyRef> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
        this.relatedParty = relatedParty;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerCreate customerCreate = (CustomerCreate) o;
        return Objects.equals(this.name, customerCreate.name) &&
                Objects.equals(this.status, customerCreate.status) &&
                Objects.equals(this.statusReason, customerCreate.statusReason) &&
                Objects.equals(this.validFor, customerCreate.validFor) &&
                Objects.equals(this.engagedParty, customerCreate.engagedParty) &&
                Objects.equals(this.type, customerCreate.type) &&
                Objects.equals(this.account, customerCreate.account) &&
                Objects.equals(this.paymentMethod, customerCreate.paymentMethod) &&
                Objects.equals(this.contactMedium, customerCreate.contactMedium) &&
                Objects.equals(this.characteristic, customerCreate.characteristic) &&
                Objects.equals(this.creditProfile, customerCreate.creditProfile) &&
                Objects.equals(this.agreement, customerCreate.agreement) &&
                Objects.equals(this.relatedParty, customerCreate.relatedParty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, statusReason, validFor, engagedParty, type, account, paymentMethod, contactMedium, characteristic, creditProfile, agreement, relatedParty);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomerCreate {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
        sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
        sb.append("    engagedParty: ").append(toIndentedString(engagedParty)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
        sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
        sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
        sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
        sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

