package com.rssfeed.controller;

import java.util.List;
import java.util.Map;



public class TestApp 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
    	 int in=0;
    	 Map<String,List<Item>> citiesByCountry =null;
 			   
    	
    	List<Item> itemsList=null;
    	
    	/*ApplicationContext app = 
				new ClassPathXmlApplicationContext("database-config.xml");

		    JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) app.getBean("customerDAO");
//itemsList = Utility.getList("employment");
		    try {
			//	itemsList = customerDAO.fetchAllFeeds("sports");
			//	SortRSSFeedByDate sortByDate = new SortRSSFeedByDate();
			//	Collections.sort(itemsList, sortByDate);
			} catch (RssFeedWebSqlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
Map<String,List<Item>> citiesByCountry1=Utility.groupToList(itemsList);*/
//String date=Utility.formatDate(citiesByCountry1);

/*for(Item i:itemsList){
	System.out.println(i.getTitle());
	System.out.println(i.getImagePath());
	System.out.println(i.getPublishedDate());
	
	
}*/
//citiesByCountry=Utility.groupToList(itemsList);

 /* Iterator it=citiesByCountry1.entrySet().iterator();


for (Map.Entry<String, List<Item>> entry : citiesByCountry1.entrySet()) {
	System.out.println("\n");
	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    String key = entry.getKey();
    System.out.println("Date" + key);
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("Value" + entry.getValue());
    for(Item i: entry.getValue()){
		// System.out.println("Id"+i.getId());
		 System.out.println("Title"+ i.getTitle());
		 System.out.println("Image" + i.getImagePath());
		 System.out.println("Image" + i.getPublishedDate());
	 }
    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
   
}
    }*/
}
}
	 
	   
   
 
    
    	
    	
    	

		
    	
    



