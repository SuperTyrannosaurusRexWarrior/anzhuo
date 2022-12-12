package com.example.billnote.model;

public class TbSeller {
	String seller_id;
	String seller_password;
	Double seller_surplusMoney;
	String seller_name;
	String seller_businessLicence_id;
	String seller_legalperson_iDcard;
	String seller_tel;
	String seller_address;
	String seller_status;

	public String getSeller_id () {
		return seller_id;
	}

	public void setSeller_id ( String seller_id ) {
		this.seller_id = seller_id;
	}

	public String getSeller_password () {
		return seller_password;
	}

	public void setSeller_password ( String seller_password ) {
		this.seller_password = seller_password;
	}

	public Double getSeller_surplusMoney () {
		return seller_surplusMoney;
	}

	public void setSeller_surplusMoney ( Double seller_surplusMoney ) {
		this.seller_surplusMoney = seller_surplusMoney;
	}

	public String getSeller_name () {
		return seller_name;
	}

	public void setSeller_name ( String seller_name ) {
		this.seller_name = seller_name;
	}

	public String getSeller_businessLicence_id () {
		return seller_businessLicence_id;
	}

	public void setSeller_businessLicence_id ( String seller_businessLicence_id ) {
		this.seller_businessLicence_id = seller_businessLicence_id;
	}

	public String getSeller_legalperson_iDcard () {
		return seller_legalperson_iDcard;
	}

	public void setSeller_legalperson_iDcard ( String seller_legalperson_iDcard ) {
		this.seller_legalperson_iDcard = seller_legalperson_iDcard;
	}

	public String getSeller_tel () {
		return seller_tel;
	}

	public void setSeller_tel ( String seller_tel ) {
		this.seller_tel = seller_tel;
	}

	public String getSeller_address () {
		return seller_address;
	}

	public void setSeller_address ( String seller_address ) {
		this.seller_address = seller_address;
	}

	public String getSeller_status () {
		return seller_status;
	}

	public void setSeller_status ( String seller_status ) {
		this.seller_status = seller_status;
	}

	@Override
	public String toString () {
		return "TbSeller{" +
				"seller_id='" + seller_id + '\'' +
				", seller_password='" + seller_password + '\'' +
				", seller_surplusMoney=" + seller_surplusMoney +
				", seller_name='" + seller_name + '\'' +
				", seller_businessLicence_id='" + seller_businessLicence_id + '\'' +
				", seller_legalperson_iDcard='" + seller_legalperson_iDcard + '\'' +
				", seller_tel='" + seller_tel + '\'' +
				", seller_address='" + seller_address + '\'' +
				", seller_status='" + seller_status + '\'' +
				'}';
	}
}
