package com.rssfeed.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


public class JdbcCustomerDAO {
	
	
	
	/**
	 * Getting the logger Instance.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(JdbcCustomerDAO.class);
	public static final String APPSCHEMA = "dbo";
	/**
	 * For JDBC connection.
	 */
	private JdbcTemplate jdbcTemplate;
	/**
	 * Getting the SimpleJdbcTemplate Instance.
	 */
	private SimpleJdbcTemplate simpleJdbcTemplate;
	/**
	 * To call the StoredProcedure.
	 */
	private SimpleJdbcCall simpleJdbcCall;

	/**
	 * To set the dataSource to jdbcTemplate...
	 * 
	 * @param dataSource
	 *            from DataSource
	 */
	
    private DataSource dataSource;
	 
	
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	public Category fetchAllFeeds(String newsType) throws RssFeedWebSqlException {
		LOG.info("Inside JdbcCustomerDAO : fetchAllFeeds ");

		Item item = new Item();
		int id=0;

		ArrayList<Item> feedsList = null;
		ArrayList<Item> topnewslst = null;
		Category newsObj = null;
		try
		{

			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			simpleJdbcCall.setSchemaName(APPSCHEMA);

			simpleJdbcCall.withProcedureName("usp_WebRssFeedNewsDisplay");
			simpleJdbcCall.returningResultSet("itemsList", new BeanPropertyRowMapper<Item>(Item.class));
			simpleJdbcCall.returningResultSet("topnewslst", new BeanPropertyRowMapper<Item>(Item.class));
	
			MapSqlParameterSource map=new MapSqlParameterSource();
				map.addValue("NewsType", newsType);
				map.addValue("HcHubCitiID", PropertiesReader.getPropertyValue("hubciti_id"));
			final Map<String, Object> resultFromProcedure= simpleJdbcCall.execute(map);
			final Integer errorNum = (Integer) resultFromProcedure.get(CommonConstants.ERRORNUMBER);
			final String errorMsg = (String) resultFromProcedure.get(CommonConstants.ERRORMESSAGE);
			
			if(null!=resultFromProcedure){
				
				if(null==errorNum){
					
					newsObj = new Category();
					
					feedsList = (ArrayList<Item>) resultFromProcedure.get("itemsList");
					if(null != feedsList && !feedsList.isEmpty())
					{
						newsObj.setItemLst(feedsList);
					}
					
					topnewslst=(ArrayList<Item>) resultFromProcedure.get("topnewslst");
					if(null != topnewslst && !topnewslst.isEmpty())
					{
						newsObj.setTopNewsLst(topnewslst);
					}
					
					
				} else {
					LOG.info("Inside JdbcCustomerDAO : fetchAllFeeds : " + errorNum + "errorMsg  .." + errorMsg);
				}
			}

		} catch (DataAccessException e) {
			LOG.error("Inside JdbcCustomerDAO : fetchAllFeeds : "+ e);
			e.printStackTrace();
		}

		LOG.info("Exit JdbcCustomerDAO : fetchAllFeeds ");
		return newsObj;
	}
	
	
	public ArrayList<Category> fetchAllImages() throws RssFeedWebSqlException {
		LOG.info("Inside JdbcCustomerDAO : fetchAllImages ");
		
		Category item=null;
		ArrayList<Category> arImagesList = null;

		try
		{

			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			simpleJdbcCall.setSchemaName(APPSCHEMA);

			simpleJdbcCall.withProcedureName("usp_WebRssFeedCategoryDisplay");

			simpleJdbcCall.returningResultSet("itemsList", new BeanPropertyRowMapper<Category>(Category.class));

			MapSqlParameterSource map=new MapSqlParameterSource();
			map.addValue("HcHubCitiID", PropertiesReader.getPropertyValue("hubciti_id"));

			final Map<String, Object> resultFromProcedure= simpleJdbcCall.execute(map);
			final Integer errorNum = (Integer) resultFromProcedure.get(CommonConstants.ERRORNUMBER);
			final String errorMsg = (String) resultFromProcedure.get(CommonConstants.ERRORMESSAGE);
			if(null!=resultFromProcedure){
				if(null==errorNum){
					
					arImagesList = (ArrayList<Category>) resultFromProcedure.get("itemsList");
					
					for(Category category : arImagesList){
						item = new Category();
						item.setCategoryName(category.getCategoryName());
						item.setImagePath(category.getImagePath());
					}
					/*if(null!=imagesList&&!ima.gesList.isEmpty()){
				 item.setItems(imagesList);
				}
					 */
				} else {
					LOG.info("Inside JdbcCustomerDAO : fetchAllImages : " + errorNum + " errorMsg " + errorMsg);
				}
			}

		} catch (DataAccessException e) {
			LOG.error("Inside JdbcCustomerDAO : fetchAllImages : "+ e);
			e.printStackTrace();
		}
		
		LOG.info("Exit JdbcCustomerDAO : fetchAllImages ");
		return arImagesList;
	}
	

	@SuppressWarnings("unchecked")
	public RealEstate fetchAllItems()throws RssFeedWebSqlException
	{
		LOG.info("Inside JdbcCustomerDAO : fetchAllFeeds ");
		/*final String methodName = "fetchRealEstateFeedItems";
		 LOG.info(CommonConstants.METHODSTART + methodName);*/

		RealEstate item=null;
		item=new RealEstate();
		ArrayList<RealEstate> itemsList = null;

		try
		{

			simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate);
			simpleJdbcCall.setSchemaName(APPSCHEMA);
			simpleJdbcCall.withProcedureName("BatchRealEstateProcessedDataDisplay");
			simpleJdbcCall.returningResultSet("itemsList", new BeanPropertyRowMapper<RealEstate>(RealEstate.class));

			MapSqlParameterSource map=new MapSqlParameterSource();

			final Map<String, Object> resultFromProcedure= simpleJdbcCall.execute(map);
			final Integer errorNum = (Integer) resultFromProcedure.get(CommonConstants.ERRORNUMBER);
			final String errorMsg = (String) resultFromProcedure.get(CommonConstants.ERRORMESSAGE);
			if(null!=resultFromProcedure){
				if(null==errorNum){
					itemsList=(ArrayList<RealEstate>) resultFromProcedure.get("itemsList");
					if(null!=itemsList&&!itemsList.isEmpty()){
						item.setRealestateList(itemsList);
					}

				} else {
					LOG.info("Inside JdbcCustomerDAO : fetchAllFeeds  : " + errorNum + "errorMsg  .." + errorMsg);
				}
			}

		} catch (DataAccessException e) {
			LOG.error("Inside JdbcCustomerDAO : fetchAllFeeds : "+ e);
			e.printStackTrace();
		}
		// log.info(ApplicationConstants.METHODEND + methodName);
		LOG.info("Exit JdbcCustomerDAO : fetchAllFeeds ");
		return item;
	}

	
	
	
	
	public static void main(String[] args) {
	
	}
	
	
	
	
	
	
	
	
}
