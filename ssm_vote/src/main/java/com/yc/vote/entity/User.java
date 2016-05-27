package com.yc.vote.entity;

public class User {
	private int vuId;

	private String vuUsername;

	private String vuPassword;

	private Integer vuStatus;

	private int vuVersion;
	
	private String vuEmail;

	
	public User(int vuId, String vuUsername, String vuPassword,
			Integer vuStatus, int vuVersion, String vuEmail) {
		this.vuUsername = vuUsername;
		this.vuPassword = vuPassword;
		this.vuStatus = vuStatus;
		this.vuEmail = vuEmail;
	}

	public User(int vuId, String vuPassword) {
		super();
		this.vuId = vuId;
		this.vuPassword = vuPassword;
	}

	public User() {
		super();
	}

	public int getVuId() {
		return vuId;
	}

	public void setVuId(int vuId) {
		this.vuId = vuId;
	}

	public String getVuUsername() {
		return vuUsername;
	}

	public void setVuUsername(String vuUsername) {
		this.vuUsername = vuUsername;
	}

	public String getVuPassword() {
		return vuPassword;
	}

	public void setVuPassword(String vuPassword) {
		this.vuPassword = vuPassword;
	}

	public Integer getVuStatus() {
		return vuStatus;
	}

	public void setVuStatus(Integer vuStatus) {
		this.vuStatus = vuStatus;
	}

	public int getVuVersion() {
		return vuVersion;
	}

	public void setVuVersion(int vuVersion) {
		this.vuVersion = vuVersion;
	}

	public String getVuEmail() {
		return vuEmail;
	}

	public void setVuEmail(String vuEmail) {
		this.vuEmail = vuEmail;
	}

	@Override
	public String toString() {
		return "User [vuId=" + vuId + ", vuUsername=" + vuUsername
				+ ", vuPassword=" + vuPassword + ", vuStatus=" + vuStatus
				+ ", vuVersion=" + vuVersion + ", vuEmail=" + vuEmail + "]";
	}
}