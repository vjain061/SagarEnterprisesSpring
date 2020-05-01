package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class CityEntity {
	@Id
	@Column(name = "cityId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cityId;

	@Override
	public String toString() {
		return "CityEntity [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

	@Column(name = "cityName")
	private String cityName;

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
