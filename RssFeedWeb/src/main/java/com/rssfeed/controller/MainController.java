package com.rssfeed.controller;





import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory
			.getLogger(MainController.class);

	private JdbcCustomerDAO customerDAO;

	public void setCustomerDAO(JdbcCustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	/**
	 * This method is used to fetch rss feeds based on feedtype.
	 * 
	 * @param item
	 * @param result
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return feed list details
	 */
	@RequestMapping(value = "/videos.htm", method = RequestMethod.GET)
	public ModelAndView getVideos(@ModelAttribute("frontpageform") Item item,
			BindingResult result, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		final String strMethodName = "getVideos";

		LOG.info(CommonConstants.METHODSTART + strMethodName);
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("itemsList");
		session.removeAttribute("videosList");
		if (!Utility.isEmptyOrNullString(item.getFeedType())) {

			ApplicationContext app = new ClassPathXmlApplicationContext(
					"database-config.xml");

			JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) app
					.getBean("customerDAO");
			Category itemd;
			ArrayList<Item> items;
			Category objCategory =null;
			try {
				objCategory = customerDAO.fetchAllFeeds(item.getFeedType());
				items =objCategory.getItemLst();

				if (null != items && !items.isEmpty()) {
					session.setAttribute("videosList", items);
					Item objItem = new Item();
					objItem.setItems(items);

				} else {

					LOG.info("Item list is empty :");
					session.setAttribute("videosList", null);

					request.setAttribute("noregfound", "Currently No:" + " "
							+ item.getFeedType()
							+ "News . Please Check back later .");
					return new ModelAndView("error");
				}
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			LOG.info("Feed type is null or empty");
			request.setAttribute("feedmessage", "No feed type");
		}
		model.put("frontpageform", item);

		// addObject("lists", item.getItems());
		LOG.info(CommonConstants.METHODEND + strMethodName);
		return new ModelAndView("indextest");

	}

	@RequestMapping(value = "/newsdetail.htm", method = RequestMethod.POST)
	public ModelAndView getDetails(@ModelAttribute("newslistform") Item item,
			BindingResult result, ModelMap map, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		LOG.info("Inside MainController : getDetails ");
		/*
		 * final String strMethodName ="getDetails";
		 * LOG.info(CommonConstants.METHODSTART +strMethodName );
		 */

		Item items = null;

		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("videosList");
		session.removeAttribute("itemsList");
		if (item != null) {

			LOG.info("Inside MainController : getDetails  : image : "
					+ item.getImage());
			LOG.info("Inside MainController : getDetails  : title : "
					+ item.getTitle());
			LOG.info("Inside MainController : getDetails  : description : "
					+ item.getDescription());
			LOG.info("Inside MainController : getDetails  : link : "
					+ item.getLink());

			if (item.getImage() != null) {
				request.setAttribute("image", item.getImage());
			}

			if (item.getTitle() != null) {
				request.setAttribute("title", item.getTitle());
			}

			if (item.getDescription() != null) {
				request.setAttribute("description", item.getDescription());
			}

			if (item.getLink() != null) {
				request.setAttribute("link", item.getLink());
			}

			if (item.getShortDesc() != null) {
				request.setAttribute("link", item.getShortDesc());
			}
		}

		LOG.info("Exit MainController : getDetails ");
		return new ModelAndView("newsdetail");
	}

	@RequestMapping(value = "/videosdetail.htm", method = RequestMethod.POST)
	public ModelAndView getVideoDetails(@ModelAttribute("videoform") Item item,
			BindingResult result, ModelMap map, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		final String strMethodName = "getVideoDetails";
		Item items = null;
		LOG.info(CommonConstants.METHODSTART + strMethodName);
		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("videosList");
		session.removeAttribute("itemsList");
		if (item != null) {

			LOG.info("link" + item.getLink());

			if (item.getLink() != null) {
				request.setAttribute("link", item.getLink());
				// Log.info("link"+ item.getLink())
			}
		}

		LOG.info(CommonConstants.METHODEND + strMethodName);
		return new ModelAndView("videoss");

	}

	@RequestMapping(value = "/combineFeeds.htm", method = RequestMethod.GET)
	public ModelAndView getdataFeed(@ModelAttribute("frontpageform") Item item,
			BindingResult result, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		final String strMethodName = "getdataFeed";
		final String strViewName = "indextest";
		String key = null;

		Map<String, List<Item>> citiesByCountrySortedDesc = null;

		LOG.info(CommonConstants.METHODSTART + strMethodName);
		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("videosList");
		session.removeAttribute("itemsList");
		if (!Utility.isEmptyOrNullString(item.getFeedType())) {
			List<Item> items = Utility.getFeedList(item.getFeedType());

			Map<String, List<Item>> citiesByCountrySorted = Utility
					.groupToList(items);

			// Iterator it=citiesByCountry.entrySet().iterator();

			for (Map.Entry<String, List<Item>> entry : citiesByCountrySorted
					.entrySet()) {

				key = entry.getKey();

				for (Item i : entry.getValue()) {

					System.out.println("Title" + i.getTitle());
					System.out.println("Image" + i.getImage());
				}

			}
			// ArrayList<Item> groupedList=Utility.groupToList(items);

			if (null != items && !items.isEmpty()) {
				Item objItem = new Item();
				objItem.setItems(items);

				session.setAttribute("itemsList", citiesByCountrySorted);

				for (Item i : items) {
					System.out.println("Title" + i.getTitle());
					System.out.println("Desc" + i.getDescription());
					System.out.println("Image" + i.getImage());
					System.out.println("link" + i.getLink());

				}
			} else {

				LOG.info("Item list is empty :");
				session.setAttribute("itemsList", null);
				request.setAttribute("noregfound",
						"Currently No" + " " + item.getFeedType() + " "
								+ " News . Please Check back later .");
				return new ModelAndView("error");
			}
		} else {
			LOG.info("Feed type is null or empty");
			request.setAttribute("feedmessage", "No feed type");
		}
		model.put("frontpageform", item);

		LOG.info(CommonConstants.METHODEND + strMethodName);
		return new ModelAndView(strViewName);

	}

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public ModelAndView getdata(@ModelAttribute("frontpageform") Item item,
			BindingResult result, ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		LOG.info("Inside MainController : getdata");

		// final String strMethodName = "getdata" ;
		final String strViewName = "indextest";
		String key = null;
		String shortDesc = null;

		Map<String, List<Item>> citiesByCountrySortedDesc = null;

		// LOG.info(CommonConstants.METHODSTART +strMethodName );
		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("videosList");
		session.removeAttribute("itemsList");
		session.removeAttribute("topList");

		ApplicationContext app = new ClassPathXmlApplicationContext(
				"database-config.xml");

		JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) app
				.getBean("customerDAO");

		Category itemd;
		Category objCategory =null;

		ArrayList<Item> feedsList;
		List<Item> topnewslst;

		try {

			objCategory = customerDAO.fetchAllFeeds(item.getFeedType());

			/*
			 * SortRSSFeedByDate sortByDate = new SortRSSFeedByDate();
			 * Collections.sort(feedsList, sortByDate);
			 */

			System.out.println("check check check ");
			feedsList=	objCategory.getItemLst();
			topnewslst=	objCategory.getTopNewsLst();
			if(null != topnewslst && !topnewslst.isEmpty()){
				session.setAttribute("topList", topnewslst);
			}
			
			
			if (null != feedsList && !feedsList.isEmpty()) {
				ArrayList<Category> ctLst = null;
				ctLst = Utility.sortHotdealsByAPINames(feedsList);

				/*HashMap<String, Item> citiesByCountrySorted = new HashMap<String, Item>();
				for (Item product : feedsList) {
					citiesByCountrySorted.put(product.getPublishedDate(),
							product);
				}*/

				/*
				 * for(Item i:feedsList){ if( i.getDescription().length()>75){
				 * shortDesc =
				 * i.getDescription().replaceAll("([^\\w\\s\'.,-:&\"<>])",
				 * "").replaceAll("&mdash", "--").replaceAll("&rsquos",
				 * "'").replaceAll("&lsquos", "'").replaceAll("&39",
				 * "").substring(0, 75)+"..."; }else { shortDesc=
				 * i.getDescription().substring(0,
				 * 50).replaceAll("([^\\w\\s\'.,-:&\"<>])",
				 * "").replaceAll("&mdash", "--").replaceAll("&ldquo",
				 * "'").replaceAll("&rdquo", "'").replaceAll("&rsquo",
				 * "'").replaceAll("&lsquo", "'").replaceAll("&39", "")+"..."; }
				 * // session.setAttribute("shortDesc", shortDesc); }
				 */
				session.setAttribute("itemsList", ctLst);
			}

			else {

				LOG.info("Item list is empty :");
				session.setAttribute("feedsList", null);
				request.setAttribute("noregfound", "No News Found :" + " "
						+ "feedsList");
				return new ModelAndView("error");
			}

		} catch (Exception e) {
			LOG.info("Inside MainController : getdata : " + e);
			e.printStackTrace();
		}

		LOG.info("Exit MainController : getdata");
		return new ModelAndView(strViewName);

	}

	@RequestMapping(value = "/frontpage.htm", method = RequestMethod.GET)
	public ModelAndView getFrontData(HttpServletRequest request,
			HttpSession session, ModelMap model) {
		LOG.info("Inside MainController : getFrontData");

		// final String strMethodName = "getFrontData" ;
		final String strViewName = "frontpage";
		String strNew = "breaking/sports/food/health/life/real/top/opinion";

		String[] strNews = strNew.split("/");
		// LOG.info(CommonConstants.METHODSTART +strMethodName );
		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("itemsList");
		session.removeAttribute("videosList");

		ApplicationContext app = new ClassPathXmlApplicationContext(
				"database-config.xml");

		JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) app
				.getBean("customerDAO");
		Category items;
		ArrayList<Category> itemsList;
		try {
			itemsList = customerDAO.fetchAllImages();

			if (null != itemsList) {

				session.setAttribute("itemsList", itemsList);

				for (int i=0; i < itemsList.size(); i++) {
					
					if ("sports News".equals(itemsList.get(i).getCategoryName())) {
						session.setAttribute("sports", itemsList.get(i).getImagePath());
					} else if ("health News".equals(itemsList.get(i).getCategoryName())) {
						session.setAttribute("health", itemsList.get(i).getImagePath());
					} else if ("business News".equals(itemsList.get(i).getCategoryName())) {
						session.setAttribute("business", itemsList.get(i).getImagePath());
					} else if ("top News".equals(itemsList.get(i).getCategoryName())) {
						session.setAttribute("top", itemsList.get(i).getImagePath());
					} else if ("life News".equals(itemsList.get(i).getCategoryName())) {
						session.setAttribute("life", itemsList.get(i).getImagePath());
					} else if ("opinion News".equals(itemsList.get(i).getCategoryName())) {
						session.setAttribute("opinion", itemsList.get(i).getImagePath());
					} 
				}
				
			} else {
				session.setAttribute("imagesList", null);
				request.setAttribute("noregfound", "No News Found :" + " "
						+ "imagesList");
				return new ModelAndView("error");
			}

		} catch (RssFeedWebSqlException e) {
			LOG.error("Inside MainController : getFrontData : " + e);
			e.printStackTrace();
		}

		LOG.info("Exit MainController : getFrontData");
		return new ModelAndView("frontpage");
	}

	@RequestMapping(value = "/getevents.htm", method = RequestMethod.GET)
	public ModelAndView getEvents(ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		LOG.info("Inside MainController : getEvents");

		// final String strMethodName = "getEvents" ;
		final String strViewName = "indextest";

		// LOG.info(CommonConstants.METHODSTART +strMethodName );
		session.removeAttribute("realestateList");
		session.removeAttribute("employmentList");
		session.removeAttribute("videosList");
		session.removeAttribute("itemsList");
		session.removeAttribute("eventsList");

		ArrayList<Item> items = Utility.getEmployment("events");

		if (null != items && !items.isEmpty()) {
			Item objItem = new Item();
			objItem.setItems(items);

			session.setAttribute("eventsList", items);

			for (Item i : items) {
				LOG.info("Title" + i.getTitle());
				LOG.info("Desc" + i.getDescription());
				LOG.info("link" + i.getLink());
			}
		} else {
			LOG.info("Inside MainController : getEvents : Empty");
			session.setAttribute("eventsList", null);
			request.setAttribute("noregfound", "No Events Found ");
			return new ModelAndView("error");
		}

		LOG.info("Exit MainController : getEvents");
		return new ModelAndView(strViewName);
	}

	/*
	 * @RequestMapping(value = "/employment.htm", method = RequestMethod.GET)
	 * public ModelAndView getGoGuideData(@ModelAttribute("frontpageform") Item
	 * item,BindingResult result,ModelMap model,HttpServletRequest request,
	 * HttpServletResponse response,HttpSession session) {
	 * LOG.info("Inside MainController : getGoGuideData");
	 * 
	 * int count=0; // final String strMethodName = "getemployment" ; final
	 * String strViewName = "indextest";
	 * 
	 * // LOG.info(CommonConstants.METHODSTART +strMethodName );
	 * session.removeAttribute("realestateList");
	 * session.removeAttribute("eventsList");
	 * session.removeAttribute("employmentList");
	 * session.removeAttribute("itemsList");
	 * session.removeAttribute("videosList");
	 * 
	 * ApplicationContext app = new
	 * ClassPathXmlApplicationContext("database-config.xml");
	 * 
	 * JdbcCustomerDAO customerDAO = (JdbcCustomerDAO)
	 * app.getBean("customerDAO");
	 * 
	 * Category itemd; ArrayList<Item> items;
	 * 
	 * try { items = customerDAO.fetchAllFeeds(item.getFeedType()); for(Item
	 * i:items){ i.setId(count++); i.setTitle(items.get(0).getTitle());
	 * i.setDescription(items.get(0).getDescription());
	 * i.setLink(items.get(0).getLink()); i.setImage(items.get(0).getImage());
	 * i.setDate(items.get(0).getDate());
	 * i.setDate(items.get(0).getShortDesc()); items.add(i); }
	 * 
	 * 
	 * 
	 * if(null != items && !items.isEmpty()) { Item objItem = new Item();
	 * objItem.setItems(items);
	 * 
	 * session.setAttribute("employmentList", items);
	 * 
	 * for (Item i : items) { LOG.info("Title" + i.getTitle()); LOG.info("Desc"
	 * + i.getDescription()); LOG.info("link" + i.getLink()); } } else {
	 * 
	 * LOG.info("Inside MainController : getGoGuideData : Empty");
	 * session.setAttribute("employmentList",null);
	 * request.setAttribute("noregfound", "No News Found :" +" " +"Employment");
	 * return new ModelAndView("error"); }
	 * 
	 * } catch (RssFeedWebSqlException e) {
	 * LOG.error("Inside MainController : getGoGuideData : " + e);
	 * e.printStackTrace(); }
	 * 
	 * LOG.info("Exit MainController : getGoGuideData"); return new
	 * ModelAndView(strViewName); }
	 */

	@RequestMapping(value = "/employment.htm", method = RequestMethod.GET)
	public ModelAndView getGoGuideData(
			@ModelAttribute("frontpageform") Item item, BindingResult result,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		LOG.info("Inside MainController : getGoGuideData");
		int count = 0;
		// final String strMethodName = "getemployment" ;
		final String strViewName = "indextest";

		// LOG.info(CommonConstants.METHODSTART +strMethodName );
		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("itemsList");
		session.removeAttribute("videosList");

		ApplicationContext app = new ClassPathXmlApplicationContext(
				"database-config.xml");

		JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) app
				.getBean("customerDAO");

		Category itemd;
		ArrayList<Item> items;
		Category objCategory = null;

		try {
			objCategory = customerDAO.fetchAllFeeds(item.getFeedType());
			items =objCategory.getItemLst();
			//items = customerDAO.fetchAllFeeds(item.getFeedType());
			/*
			 * for(Item i:items){ i.setId(count++);
			 * i.setTitle(items.get(0).getTitle());
			 * i.setDescription(items.get(0).getDescription());
			 * i.setLink(items.get(0).getLink());
			 * i.setImage(items.get(0).getImage());
			 * i.setDate(items.get(0).getDate());
			 * i.setDate(items.get(0).getShortDesc()); items.add(i); }
			 */

			if (null != items && !items.isEmpty()) {
				Item objItem = new Item();
				objItem.setItems(items);

				session.setAttribute("employmentList", items);

				for (Item i : items) {
					LOG.info("Title" + i.getTitle());
					LOG.info("Desc" + i.getDescription());
					LOG.info("link" + i.getLink());
				}
			} else {

				LOG.info("Inside MainController : getGoGuideData : Empty");
				session.setAttribute("employmentList", null);
				request.setAttribute("noregfound", "No News Found :" + " "
						+ "Employment");
				return new ModelAndView("error");
			}

		} catch (RssFeedWebSqlException e) {
			LOG.error("Inside MainController : getGoGuideData : " + e);
			e.printStackTrace();
		}

		LOG.info("Exit MainController : getGoGuideData");
		return new ModelAndView(strViewName);
	}

	@SuppressWarnings("resource")
	@RequestMapping(value = "/realestate.htm", method = RequestMethod.GET)
	public ModelAndView getrealEstateData(ModelMap model,
			HttpServletRequest request, HttpServletResponse response,
			HttpSession session) {
		LOG.info("Inside MainController : getrealEstateData ");

		// final String strMethodName = "getRealEstateData" ;
		final String strViewName = "indextest";

		// LOG.info(CommonConstants.METHODSTART +strMethodName );
		session.removeAttribute("realestateList");
		session.removeAttribute("eventsList");
		session.removeAttribute("employmentList");
		session.removeAttribute("itemsList");
		session.removeAttribute("videosList");

		ApplicationContext app = new ClassPathXmlApplicationContext(
				"database-config.xml");

		JdbcCustomerDAO customerDAO = (JdbcCustomerDAO) app
				.getBean("customerDAO");
		RealEstate items;
		try {
			items = customerDAO.fetchAllItems();

			if (null != items) {
				session.setAttribute("realestateList",
						items.getRealestateList());
			} else {

				LOG.error("Inside MainController : getrealEstateData : Empty");
				session.setAttribute("realestateList", null);
				request.setAttribute("noregfound", "No News Found :" + " "
						+ "realestateList");
				return new ModelAndView("error");
			}

		} catch (RssFeedWebSqlException e) {
			LOG.error("Inside MainController : getrealEstateData : " + e);
			e.printStackTrace();
		}

		LOG.info("Inside MainController : getrealEstateData ");
		return new ModelAndView(strViewName);
	}

}
