package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminEntity {
	@Id
	@Column(name = "adminId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	@Column(name = "adminpassword")
	private String adminPassword;
	@Column(name = "adminName")
	private String adminName;

	@Override
	public String toString() {
		return "AdminEntity [adminId=" + adminId + ", adminPassword=" + adminPassword + ", adminName=" + adminName
				+ "]";
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
