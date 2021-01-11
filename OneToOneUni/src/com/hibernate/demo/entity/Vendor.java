package com.hibernate.demo.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Vendor")
public class Vendor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Phone")
	private String Phone;
	
	@Column(name="VendorID")
	private String VendorID;
	
	public Vendor(String name, String phone, String vendorID) {
		super();
		Name = name;
		Phone = phone;
		VendorID = vendorID;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="VendorDetailsID")
	private VendorDetails vendorDetails;
	
	public Vendor() {
		
	}

	@Override
	public String toString() {
		return "Vendor [id=" + id + ", Name=" + Name + ", Phone=" + Phone + ", VendorID=" + VendorID
				+ ", vendorDetails=" + vendorDetails + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getVendorID() {
		return VendorID;
	}

	public void setVendorID(String vendorID) {
		VendorID = vendorID;
	}

	public VendorDetails getVendorDetails() {
		return vendorDetails;
	}

	public void setVendorDetails(VendorDetails vendorDetails) {
		this.vendorDetails = vendorDetails;
	}
	
	

}
