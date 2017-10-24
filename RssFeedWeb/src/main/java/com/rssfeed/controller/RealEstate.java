package com.rssfeed.controller;

import java.util.ArrayList;

public class RealEstate {
	
	private String Title;
	private String StartDate;
	private String EndDate;
	private String CreatedUserID;
	private String DateCreated;
	private ArrayList<RealEstate> realestateList;
	private int Status;
	private String ErrorNumber;
	private String ErrorMessage;
	
	public RealEstate(){
		
	}
	
	public RealEstate(String title,String startDate,String endDate){
		this.Title=title;
		this.StartDate=startDate;
		this.EndDate=endDate;
	}
	
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getErrorNumber() {
		return ErrorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		ErrorNumber = errorNumber;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public ArrayList<RealEstate> getRealestateList() {
		return realestateList;
	}
	public void setRealestateList(ArrayList<RealEstate> realestateList) {
		this.realestateList = realestateList;
	}
	public String getCreatedUserID() {
		return CreatedUserID;
	}
	public void setCreatedUserID(String createdUserID) {
		this.CreatedUserID = createdUserID;
	}
	public String getDateCreated() {
		return DateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.DateCreated = dateCreated;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		this.StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		this.EndDate = endDate;
	}
	

}
