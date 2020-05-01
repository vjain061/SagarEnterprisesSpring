package com.model;

public class AdminDto {
	private int adminId;
	private String adminPassword;
	private String adminName;

	@Override
	public String toString() {
		return "AdminDto [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminName=" + adminName + "]";
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
}