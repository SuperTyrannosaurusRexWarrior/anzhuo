package com.example.billnote.model;

public class TbAdmin {
	String admin_id;
	String admin_password;
	String admin_type;
	String admin_status;

	public String getAdmin_id () {
		return admin_id;
	}

	public void setAdmin_id ( String admin_id ) {
		this.admin_id = admin_id;
	}

	public String getAdmin_password () {
		return admin_password;
	}

	public void setAdmin_password ( String admin_password ) {
		this.admin_password = admin_password;
	}

	public String getAdmin_type () {
		return admin_type;
	}

	public void setAdmin_type ( String admin_type ) {
		this.admin_type = admin_type;
	}

	public String getAdmin_status () {
		return admin_status;
	}

	public void setAdmin_status ( String admin_status ) {
		this.admin_status = admin_status;
	}

	@Override
	public String toString () {
		return "TbAdmin{" +
				"admin_id='" + admin_id + '\'' +
				", admin_password='" + admin_password + '\'' +
				", admin_type='" + admin_type + '\'' +
				", admin_status='" + admin_status + '\'' +
				'}';
	}
}
