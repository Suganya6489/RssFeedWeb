package com.rssfeed.controller;


import java.util.List;

public class Item {
	private int id;
	private String title;
	private String image;
	private String ImagePath;
	private String PublishedDate;
	private String PubStrtDate;
	public String getPublishedDate() {
		return PublishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		PublishedDate = publishedDate;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	private String link;
	private String feedType;
	private String date;
	private String shortDesc;



	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFeedType() {
		return feedType;
	}

	public void setFeedType(String feedType) {
		this.feedType = feedType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	private String description;

	private List<Item> items;

	public Item() {

	}
	
	public Item(String tit, String description, String ImagePath, String link,String date,String shortDesc,String pubSrtDate) {
		this.title = tit;
		this.description = description;
		this.ImagePath = ImagePath;
		this.link = link;
		this.PublishedDate=date;
		this.shortDesc=shortDesc;
		this.PubStrtDate=pubSrtDate;
	}

	public Item(String tit, String description, String ImagePath, String link,String pubSrtDate) {
		this.title = tit;
		this.description = description;
		this.ImagePath = ImagePath;
		this.link = link;
		this.PubStrtDate=pubSrtDate;
	}
	
	


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null) {
			this.title = title;
		} else {
			this.title = null;
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPubStrtDate() {
		return PubStrtDate;
	}

	public void setPubStrtDate(String pubStrtDate) {
		PubStrtDate = pubStrtDate;
	}

}
