package com.project.fundamentals.ENTITY;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "CARD_GROUP_DETAILS")
public class CardGroupDetails {

@Id	
@Column(name = "CARD_GROUP_SET_ID", nullable = false, length = 11)
@GeneratedValue(strategy = GenerationType.AUTO)
int	cardGroupSetId;

@Column(name = "VERSION", nullable = false,length = 50)
String	version;


@Column(name = "CARD_GROUP_ID", nullable=false, length = 10)
String	cardGroupId;

@Column(name = "START_RANGE",  nullable = true, length = 11)
//@Temporal(TemporalType.DATE)
//@CreatedDate
int startRange;

@Column(name = "END_RANGE", nullable = true, length = 20)
int	endRange;


@OneToMany
@JoinColumn(name = "CARD_GROUP_SET_ID", insertable = false, updatable = false, referencedColumnName="CARD_GROUP_SET_ID")
private List<CardGroupBonusDetails> bonusAccList;


@Column(name = "CARD_NAME", nullable = true, length = 10)
String cardName;


@Column(name = "VOUCHER_TYPE", nullable = false, length = 10)
String voucherType;

@Column(name = "VOUCHER_SEGMENT", nullable = false, length = 10)
String voucherSegment;

@Column(name = "VOUCHER_PRODUCT_ID", nullable = false, length = 10)
String voucherProductId;

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

public int getStartRange() {
	return startRange;
}

public void setStartRange(int startRange) {
	this.startRange = startRange;
}

public int getEndRange() {
	return endRange;
}

public void setEndRange(int endRange) {
	this.endRange = endRange;
}

public String getCardName() {
	return cardName;
}

public void setCardName(String cardName) {
	this.cardName = cardName;
}

public String getVoucherType() {
	return voucherType;
}

public void setVoucherType(String voucherType) {
	this.voucherType = voucherType;
}

public String getVoucherSegment() {
	return voucherSegment;
}


public void setVoucherSegment(String voucherSegment) {
	this.voucherSegment = voucherSegment;
}


public List<CardGroupBonusDetails> getBonus() {
	return bonusAccList;
}

public void setBonus(List<CardGroupBonusDetails> bonusAccList) {
	this.bonusAccList = bonusAccList;
}

public String getVoucherProductId() {
	return voucherProductId;
}

public void setVoucherProductId(String voucherProductId) {
	this.voucherProductId = voucherProductId;
}
}