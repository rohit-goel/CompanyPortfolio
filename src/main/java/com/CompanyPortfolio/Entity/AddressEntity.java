package com.CompanyPortfolio.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rohit
 *
 */
@Entity
@Table(name = "address")
public class AddressEntity {

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "plotno")
	private String plotno;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPlotNo() {
		return plotno;
	}

	public void setPlotNo(String plotno) {
		this.plotno = plotno;
	}

}
