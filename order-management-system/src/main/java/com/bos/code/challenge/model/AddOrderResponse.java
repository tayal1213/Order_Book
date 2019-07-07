package com.bos.code.challenge.model;

public class AddOrderResponse {

	private String description;
	
	private String code;

	public AddOrderResponse(String description, String code) {
		this.description = description;
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "AddOrderResponse [description=" + description + ", code=" + code + "]";
	}
	
	


	
}
