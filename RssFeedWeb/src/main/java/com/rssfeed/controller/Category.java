package com.rssfeed.controller;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String CategoryName;
	private String ImagePath;
	
	private String PublishedDate;
	
	private String displayDate;
	
	private ArrayList<Item> itemLst;
	private List<Category> items;
	
	private List<Item> topNewsLst;
	public List<Category> getItems() {
		return items;
	}
	public void setItems(List<Category> items) {
		this.items = items;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public Category(){
		
	}
	public Category(String name,String path){
		this.CategoryName=name;
		this.ImagePath=path;
	}
	
	
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		this.CategoryName = categoryName;
	}
	public ArrayList<Item> getItemLst() {
		return itemLst;
	}
	public void setItemLst(ArrayList<Item> itemLst) {
		this.itemLst = itemLst;
	}
	public String getPublishedDate() {
		return PublishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		PublishedDate = publishedDate;
	}
	public String getDisplayDate() {
		return displayDate;
	}
	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}
	public List<Item> getTopNewsLst() {
		return topNewsLst;
	}
	public void setTopNewsLst(List<Item> topNewsLst) {
		this.topNewsLst = topNewsLst;
	}
	

}
