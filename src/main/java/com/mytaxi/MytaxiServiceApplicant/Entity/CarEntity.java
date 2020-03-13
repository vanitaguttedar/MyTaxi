package com.mytaxi.MytaxiServiceApplicant.Entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "car")
public class CarEntity {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	@Column(nullable = false, name = "date_created")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private ZonedDateTime dateCreated = ZonedDateTime.now();

	@Column
	private Float rating;

	@Column(name = "engine_type")
	private String engineType;

	@Column(name = "license_plate")
	private String licensePlate;

	@Column(name = "seat_count")
	private Integer seatCount;

	@Column
	private Boolean convertible;

	@Column(nullable = false)
	private Boolean deleted = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public Boolean getConvertible() {
		return convertible;
	}

	public void setConvertible(Boolean convertible) {
		this.convertible = convertible;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public CarEntity(Float rating, String engineType, String licensePlate, Integer seatCount, Boolean convertible){
	        this.rating = rating;
	        this.engineType = engineType;
	        this.licensePlate = licensePlate;
	        this.seatCount = seatCount;
	        this.convertible = convertible;
	        this.deleted = false;
	 }

	public CarEntity() {
	}

	@Override
	public String toString() {
		return "CarEntity [id=" + id + ", dateCreated=" + dateCreated + ", rating=" + rating + ", engineType="
				+ engineType + ", licensePlate=" + licensePlate + ", seatCount=" + seatCount + ", convertible="
				+ convertible + ", deleted=" + deleted + "]";
	}
	
	
}
