package com.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class StateEntity {
	@Id
	@Column(name = "stateId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int stateId;
	@Column(name = "stateName")
	private String stateName;

	@OneToMany(targetEntity = CityEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "stateId", referencedColumnName = "stateId")
	private List<CityEntity> cityList;

	public List<CityEntity> getCityList() {
		return cityList;
	}

	public void setCityList(List<CityEntity> cityList) {
		this.cityList = cityList;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
