package com.project.fundamentals;



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


//@OneToOne
//@JoinColumn(name = "CARD_GROUP_ID", insertable = false, updatable = false, referencedColumnName="CARD_GROUP_ID")
//private CardGroupBonusDetails bonus;


//@Column(name = "VALIDITY_PERIOD_TYPE", nullable = true, length = 11)
//@Temporal(TemporalType.TIMESTAMP)
//@CreatedDate
//String validityPeriodType;


//@Column(name = "VALIDITY_PERIOD", nullable = true, length = 20)
//int validityPeriod;

//@Column(name = "GRACE_PERIOD", nullable = true, length = 5)
//int gracePeriod;


//@Column(name = "SENDER_TAX1_NAME", nullable = true, length = 10)
//String	sendeTax1Name;

//@Column(name = "SENDER_TAX1_TYPE", nullable = true, length = 1)
//String senderTax1Type;

//@Column(name = "SENDER_TAX1_RATE", nullable = true, length = 140)
//int senderTax1Rate;


//@Column(name = "SENDER_TAX2_NAME", nullable = true, length = 10)
//String	sendeTax2Name;

//@Column(name = "SENDER_TAX2_TYPE", nullable = true, length = 1)
//String senderTax2Type;

//@Column(name = "SENDER_TAX2_RATE", nullable = true, length = 140)
//int senderTax2Rate;

//@Column(name = "RECEIVER_TAX1_NAME", nullable = true, length = 10)
//String	receiverTax1Name;

//@Column(name = "RECEIVER_TAX1_TYPE", nullable = true, length = 1)
//String receiverTax1Type;

//@Column(name = "RECEIVER_TAX1_RATE", nullable = true, length = 140)
//int receiverTax1Rate;

//@Column(name = "RECEIVER_TAX2_NAME", nullable = true, length = 10)
//String	receiverTax2Name;

//@Column(name = "RECEIVER_TAX2_TYPE", nullable = true, length = 1)
//String receiverTax2Type;

//@Column(name = "RECEIVER_TAX2_RATE", nullable = true, length = 140)
//int receiverTax2Rate;


//@Column(name = "BONUS_VALIDITY_VALUE", nullable = true, length = 10)
//int bonusValidityValue;

//@Column(name = "SENDER_ACCESS_FEE_TYPE", nullable = true, length = 10)
//String	senderAccessFeeType;

//@Column(name = "SENDER_ACCESS_FEE_RATE", nullable = true, length = 10)
//int senderAccessFeeRate;

//@Column(name = "MIN_SENDER_ACCESS_FEE", nullable = true, length = 10)
//int minSenderAccessFee;

//@Column(name = "MAX_SENDER_ACCESS_FEE", nullable = true, length = 10)
//int maxSenderAccessFee;


//@Column(name = "RECEIVER_ACCESS_FEE_TYPE", nullable = true, length = 10)
//String	receiverAccessFeeType;

//@Column(name = "RECEIVER_ACCESS_FEE_RATE", nullable = true, length = 10)
//int receiverAccessFeeRate;

//@Column(name = "MIN_RECEIVER_ACCESS_FEE", nullable = true, length = 10)
//int minReceiverAccessFee;

//@Column(name = "MAX_RECEIVER_ACCESS_FEE", nullable = true, length = 10)
//int maxReceiverAccessFee;


//@Column(name = "CARD_GROUP_CODE", nullable = false, length = 10)
//String	cardGroupCode;

//@Column(name = "MULTIPLE_OF", nullable = true, length = 10)
//int multipleOf;

//@Column(name = "ONLINE_OFFLINE", nullable = true, length = 10)
//String onlineOffline;

//@Column(name = "BOTH", nullable = true, length = 10)
//String both;


//@Column(name = "SENDER_MULT_FACTOR", nullable = true, length = 10)
//int senderMultFactor;

//@Column(name = "RECEIVER_MULT_FACTOR", nullable = true, length = 10)
//int receiverMultFactor;

//@Column(name = "STATUS", nullable = true, length = 10)
//String status;

//@Column(name = "COS_REQUIRED", nullable = true, length = 10)
//String cosRequired;

//@Column(name = "IN_PROMO", nullable = true, length = 10)
//int inPromo;

//public CardGroupBonusDetails getBonus() {
	//return bonus;
//}

//public void setBonus(CardGroupBonusDetails bonus) {
	//this.bonus = bonus;
//}

public List<CardGroupBonusDetails> getBonus() {
	return bonusAccList;
}

public void setBonus(List<CardGroupBonusDetails> bonusAccList) {
	this.bonusAccList = bonusAccList;
}

@Column(name = "CARD_NAME", nullable = true, length = 10)
String cardName;

//@Column(name = "REVERSAL_PERMITTED", nullable = true, length = 10)
//String reversalPermitted;

//@Column(name = "REVERSAL_MODIFIED_DATE", nullable = true, length = 10)
//Date reversalModifiedDate;

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

public String getVoucherProductId() {
	return voucherProductId;
}

public void setVoucherProductId(String voucherProductId) {
	this.voucherProductId = voucherProductId;
}

@Column(name = "VOUCHER_TYPE", nullable = false, length = 10)
String voucherType;

@Column(name = "VOUCHER_SEGMENT", nullable = false, length = 10)
String voucherSegment;

@Column(name = "VOUCHER_PRODUCT_ID", nullable = false, length = 10)
String voucherProductId;
}