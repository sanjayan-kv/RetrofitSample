package com.example.retrofittest.Model;

import java.util.Vector;

public class Phones {

	private Vector<String> phones;

	public Vector<String> getPhones() {
		return phones;
	}

	public void setPhones(Vector<String> phones) {
		this.phones = phones;
	}
	
	public void addPhone(String phone) {
		if(phones == null) {
			phones = new Vector<String>();
		}

		if (phone != null) {
			// Remove any non-numeric character
			phone = phone.replaceAll("[^\\d]", "");
			   phones.add(phone);
		}
	}
	
}
