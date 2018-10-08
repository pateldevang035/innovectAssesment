package com.innovect.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "temperature")
@Table(name = "temperature")
public class Temperature implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1135945250293329714L;
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	@Column(name = "id")
	private Long id; 
	
	@Temporal(TemporalType.TIME)
	@Column(name = "startTime")
	private Date startTime;
	
	@Temporal(TemporalType.TIME)
	@Column(name = "endTime")
	private Date endTime;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	private Date date;
	
	@Column(name = "averageTemperature")
	private Integer averageTemperature;
	
	@Column(name = "precipitation")
	private Integer precipitation;
	
	@Column(name = "zip")
	private Integer zip;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getAverageTemperature() {
		return averageTemperature;
	}
	public void setAverageTemperature(Integer averageTemperature) {
		this.averageTemperature = averageTemperature;
	}
	public Integer getPrecipitation() {
		return precipitation;
	}
	public void setPrecipitation(Integer precipitation) {
		this.precipitation = precipitation;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	

}
