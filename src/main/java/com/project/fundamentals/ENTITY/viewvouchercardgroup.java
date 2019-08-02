package com.project.fundamentals.ENTITY;

public class viewvouchercardgroup {

	
	int cardGroupSetId;
	String lastVersion;
	public int getCardGroupSetId() {
		return cardGroupSetId;
	}
	public void setCardGroupSetId(int cardGroupSetId) {
		this.cardGroupSetId = cardGroupSetId;
	}
	public String getLastVersion() {
		return lastVersion;
	}
	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}
	
	public viewvouchercardgroup(int cardGroupSetId, String lastVersion)
	{
		this.cardGroupSetId=cardGroupSetId;
		this.lastVersion=lastVersion;
	}
	
}
