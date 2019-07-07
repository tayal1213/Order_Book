package com.bos.code.challenge.model;

/**
 * Created by Atul on 6/7/19.
 */
public enum ResponseCodes {

    ORDER_ADDED("Order Successfully Added","001")
    , ORDER_BOOK_CLOSED ("Order Book Closed","002")
    , ORDER_UNRECOGNIZED ("Order Not Recognized","003")
    , ERROR_ADDING_ORDER("Order Addition Failed","004")
    , EXECUTION_SUCCESSFULL("Execution Successful","005")
    , EXECUTION_UNSUCCESSFULL("Execution Failed","005");
	
	private final String description;
    private final String code;
    
	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	private ResponseCodes(String description, String code) {
		this.description = description;
		this.code = code;
	}
   

}
