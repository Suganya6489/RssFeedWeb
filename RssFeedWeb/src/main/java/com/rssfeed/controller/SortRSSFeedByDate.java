package com.rssfeed.controller;

import java.util.Comparator;
import java.util.Date;


	
	public class SortRSSFeedByDate implements Comparator<Category> {

		//private static final Logger LOG = LoggerFactory.getLogger(SortRSSFeedByDate.class);

		

		/*public int compare(Item item1, Item item2) {
			Date date1, date2;
			Integer dateCompare = 0;
			try	{
				date1 = Utility.getDateFromString(item1.getPubStrtDate());
				date2 = Utility.getDateFromString(item2.getPubStrtDate());
				if(null != date1 && null != date2)	{
					dateCompare = date2.compareTo(date1);
				} else if(null == date1 && null != date2)	{
					//LOG.error("PubDate is empty for title: " + item1.getTitle() + ", link: " + item1.getLink());
					dateCompare = 1;
				} else if(null == date2 && null != date1)	{
					dateCompare = -1;
					//LOG.error("PubDate is empty for title: " + item2.getTitle() + ", link: " + item2.getLink());
				} else	{
					dateCompare = 0;
				//	LOG.error("PubDate is empty for title: " + item1.getTitle() + ", " + item2.getTitle() + ", link: " + item1.getLink() + ", " + item2.getLink());
				}
			} catch(Exception e)	{
				//LOG.error("Exception in SortRSSFeedByDate: Message: " + e.getMessage());
			}
			return dateCompare;
		}
		
		*/

		public int compare(Category arg0, Category arg1) {
			
			Date date1, date2;
			Integer dateCompare = 0;
			try	{
				date1 = Utility.getDateFromString(arg0.getPublishedDate());
				date2 = Utility.getDateFromString(arg1.getPublishedDate());
				if(null != date1 && null != date2)	{
					dateCompare = date2.compareTo(date1);
				} else if(null == date1 && null != date2)	{
					//LOG.error("PubDate is empty for title: " + item1.getTitle() + ", link: " + item1.getLink());
					dateCompare = 1;
				} else if(null == date2 && null != date1)	{
					dateCompare = -1;
					//LOG.error("PubDate is empty for title: " + item2.getTitle() + ", link: " + item2.getLink());
				} else	{
					dateCompare = 0;
				//	LOG.error("PubDate is empty for title: " + item1.getTitle() + ", " + item2.getTitle() + ", link: " + item1.getLink() + ", " + item2.getLink());
				}
			} catch(Exception e)	{
				//LOG.error("Exception in SortRSSFeedByDate: Message: " + e.getMessage());
			}
			return dateCompare;
		}
		
	}



