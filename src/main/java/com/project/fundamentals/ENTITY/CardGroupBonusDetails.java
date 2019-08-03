package com.project.fundamentals.ENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description="Details about CARD")
@Table(name = "CARD_GROUP_SUB_BON_ACC_DETAILS")
public class CardGroupBonusDetails {

	
@Column(name = "CARD_GROUP_SET_ID", nullable = false, length = 11)
@ApiModelProperty(notes="This is AUTO generated ID")
@GeneratedValue(strategy = GenerationType.AUTO)
int	cardGroupSetId;

@Column(name = "VERSION", nullable = false,length = 50)

String	version;

@Id
@Column(name = "CARD_GROUP_ID", nullable= false, length = 2)
String	cardGroupId;

@Column(name = "BONDLE_ID",  nullable = false, length = 11)
//@Temporal(TemporalType.DATE)
//@CreatedDate
int bondleId;

@Column(name = "TYPE", nullable = false, length = 20)
String	type;


@Column(name = "VALIDITY", nullable = false, length = 11)
//@Temporal(TemporalType.TIMESTAMP)
//@CreatedDate
int validity;

@Column(name = "VALUE", nullable = false, length = 20)
int value;

@Column(name = "MULT_FACTOR", nullable = true, length = 5)
int multFactor;

public int getCardGroupSetId() {
	return cardGroupSetId;
}

public void setCardGroupSetId(int cardGroupSetId) {
	this.cardGroupSetId = cardGroupSetId;
}

public String getVersion() {
	return version;
}

public void setVersion(String version) {
	this.version = version;
}

public String getCardGroupId() {
	return cardGroupId;
}

public void setCardGroupId(String cardGroupId) {
	this.cardGroupId = cardGroupId;
}

public int getBondleId() {
	return bondleId;
}

public void setBondleId(int bondleId) {
	this.bondleId = bondleId;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public int getValidity() {
	return validity;
}

public void setValidity(int validity) {
	this.validity = validity;
}

public int getValue() {
	return value;
}

public void setValue(int value) {
	this.value = value;
}

public int getMultFactor() {
	return multFactor;
}

public void setMultFactor(int multFactor) {
	this.multFactor = multFactor;
}


}