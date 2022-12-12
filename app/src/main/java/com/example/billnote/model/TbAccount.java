package com.example.billnote.model;

public class TbAccount {
	String account_id;
	String account_password;
	Double account_surplusMoney;
	String account_name;
	String account_tel;
	String account_address;
	String account_q1;
	String account_a1;
	String account_q2;
	String account_a2;
	String account_q3;
	String account_a3;
	String account_status;

	public String getAccount_id () {
		return account_id;
	}

	public void setAccount_id ( String account_id ) {
		this.account_id = account_id;
	}

	public String getAccount_password () {
		return account_password;
	}

	public void setAccount_password ( String account_password ) {
		this.account_password = account_password;
	}

	public Double getAccount_surplusMoney () {
		return account_surplusMoney;
	}

	public void setAccount_surplusMoney ( Double account_surplusMoney ) {
		this.account_surplusMoney = account_surplusMoney;
	}

	public String getAccount_name () {
		return account_name;
	}

	public void setAccount_name ( String account_name ) {
		this.account_name = account_name;
	}

	public String getAccount_tel () {
		return account_tel;
	}

	public void setAccount_tel ( String account_tel ) {
		this.account_tel = account_tel;
	}

	public String getAccount_address () {
		return account_address;
	}

	public void setAccount_address ( String account_address ) {
		this.account_address = account_address;
	}

	public String getAccount_q1 () {
		return account_q1;
	}

	public void setAccount_q1 ( String account_q1 ) {
		this.account_q1 = account_q1;
	}

	public String getAccount_a1 () {
		return account_a1;
	}

	public void setAccount_a1 ( String account_a1 ) {
		this.account_a1 = account_a1;
	}

	public String getAccount_q2 () {
		return account_q2;
	}

	public void setAccount_q2 ( String account_q2 ) {
		this.account_q2 = account_q2;
	}

	public String getAccount_a2 () {
		return account_a2;
	}

	public void setAccount_a2 ( String account_a2 ) {
		this.account_a2 = account_a2;
	}

	public String getAccount_q3 () {
		return account_q3;
	}

	public void setAccount_q3 ( String account_q3 ) {
		this.account_q3 = account_q3;
	}

	public String getAccount_a3 () {
		return account_a3;
	}

	public void setAccount_a3 ( String account_a3 ) {
		this.account_a3 = account_a3;
	}

	public String getAccount_status () {
		return account_status;
	}

	public void setAccount_status ( String account_status ) {
		this.account_status = account_status;


	}

	@Override
	public String toString () {
		return "TbAccount{" +
				"account_id='" + account_id + '\'' +
				", account_password='" + account_password + '\'' +
				", account_surplusMoney=" + account_surplusMoney +
				", acount_name='" + account_name + '\'' +
				", account_tel='" + account_tel + '\'' +
				", account_address='" + account_address + '\'' +
				", account_q1='" + account_q1 + '\'' +
				", account_a1='" + account_a1 + '\'' +
				", account_q2='" + account_q2 + '\'' +
				", account_a2='" + account_a2 + '\'' +
				", account_q3='" + account_q3 + '\'' +
				", account_a3='" + account_a3 + '\'' +
				", account_status='" + account_status + '\'' +
				'}';
	}
}
