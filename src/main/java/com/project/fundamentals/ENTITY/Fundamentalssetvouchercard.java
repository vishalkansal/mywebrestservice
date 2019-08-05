package com.project.fundamentals.ENTITY;


import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "CARD_GROUP_SET")
public class Fundamentalssetvouchercard {

	
@Column(name = "CARD_GROUP_SET_ID", nullable = false, length = 11)
@Id
@GeneratedValue(strategy= GenerationType.AUTO)
int	cardGroupSetId;

@Column(name = "card_group_set_name", nullable = false,length = 50)
String	cardGroupSetName;

@Column(name = "network_code", length = 2)
String	networkCode;

@Column(name = "created_on",  nullable = false, length = 11)
//@Temporal(TemporalType.DATE)
//@CreatedDate
Date createdOn;

@Column(name = "created_by", nullable = false, length = 20)
String	createdBy;


@Column(name = "modified_on", nullable = false, length = 11)
//@Temporal(TemporalType.TIMESTAMP)
//@CreatedDate
Date modifiedOn;


@Column(name = "modified_by", nullable = false, length = 20)
String	modifiedBy;

@Column(name = "last_version", nullable = true, length = 5)
String	lastVersion;


@Column(name = "module_code", nullable = true, length = 10)
String	moduleCode;

@Column(name = "status", nullable = true, length = 1)
String status;

@Column(name = "language_1_message", nullable = false, length = 140)
String	language1Message;

@Column(name = "language_2_message", nullable = false, length = 140)
String	language2Mmessage;

@Column(name = "sub_service", nullable = true, length = 10)
String	subService;

@Column(name = "service_type", nullable = false, length = 10)
String	serviceType;

@Column(name = "set_type", nullable = true, length = 10)
String	setType;


@Column(name = "is_default", nullable = true, length = 1)
String	isDefault;


public int getCardGroupSetId() {
	return cardGroupSetId;
}


public void setCardGroupSetId(int cardGroupSetId) {
	this.cardGroupSetId = cardGroupSetId;
}


public String getCardGroupSetName() {
	return cardGroupSetName;
}


public void setCardGroupSetName(String cardGroupSetName) {
	this.cardGroupSetName = cardGroupSetName;
}


public String getNetworkCode() {
	return networkCode;
}


public void setNetworkCode(String networkCode) {
	this.networkCode = networkCode;
}





public String getCreatedBy() {
	return createdBy;
}


public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}





public Date getCreatedOn() {
	return createdOn;
}


public void setCreatedOn(Date createdOn) {
	this.createdOn = createdOn;
}


public Date getModifiedOn() {
	return modifiedOn;
}


public void setModifiedOn(Date modifiedOn) {
	this.modifiedOn = modifiedOn;
}


public String getModifiedBy() {
	return modifiedBy;
}


public void setModifiedBy(String modifiedBy) {
	this.modifiedBy = modifiedBy;
}


public String getLastVersion() {
	return lastVersion;
}


public void setLastVersion(String lastVersion) {
	this.lastVersion = lastVersion;
}


public String getModuleCode() {
	return moduleCode;
}


public void setModuleCode(String moduleCode) {
	this.moduleCode = moduleCode;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


public String getLanguage1Message() {
	return language1Message;
}


public void setLanguage1Message(String language1Message) {
	this.language1Message = language1Message;
}


public String getLanguage2Mmessage() {
	return language2Mmessage;
}


public void setLanguage2Mmessage(String language2Mmessage) {
	this.language2Mmessage = language2Mmessage;
}


public String getSubService() {
	return subService;
}


public void setSubService(String subService) {
	this.subService = subService;
}


public String getServiceType() {
	return serviceType;
}


public void setServiceType(String serviceType) {
	this.serviceType = serviceType;
}


public String getSetType() {
	return setType;
}


public void setSetType(String setType) {
	this.setType = setType;
}


public String getIsDefault() {
	return isDefault;
}


public void setIsDefault(String isDefault) {
	this.isDefault = isDefault;
}

}