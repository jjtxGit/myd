package com.shxt.entity;

public class Vip {

	private int id = 0;
	private String name = "";
	private String paw = "";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPaw() {
		return paw;
	}

	public void setPaw(String paw) {
		this.paw = paw;
	}

	public String getPnum() {
		return pnum;
	}

	public void setPnum(String pnum) {
		this.pnum = pnum;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	private String pnum = "";
	private String adress = "";
	private String mail = "";

	@Override
	public String toString() {
		return name + ":" + paw + ":" + mail + ":" + pnum + ":" + adress;

	}

}
