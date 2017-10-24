package com.rssfeed.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Utility {

	public static boolean validateURL(String strUrlLink) {
		Pattern pattern = null;
		Matcher matcher;
		if (!"".equals(Utility.checkNull(strUrlLink))) {
			strUrlLink = strUrlLink.trim();
			pattern = Pattern.compile(CommonConstants.URL_PATTERN);
			matcher = pattern.matcher(strUrlLink);
			return matcher.matches();
		}
		return true;
	}

	/**
	 * Method to Check if the String object is null
	 * 
	 * @param strValue
	 *            String
	 * @return strValue String
	 */
	public static String checkNull(String strValue) {
		if (null == strValue || "null".equals(strValue) || "".equals(strValue)
				|| "undefined".equals(strValue)) {
			return "";
		} else {
			return strValue.trim();
		}
	}

	public static ArrayList<Item> getEmployment(String name) {
		ArrayList<Item> empItems = new ArrayList<Item>();
		URL url = null;

		try {

			if (name.equalsIgnoreCase("employment")) {
				url = new URL(CommonConstants.employment);
			} else if (name.equalsIgnoreCase("events")) {
				url = new URL(CommonConstants.goguideEvents);
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(url.openStream()));
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("item");

			for (int i = 0; i < nodeList.getLength(); i++) {

				String tit = null;
				String longDesc = null;
				String category = null;
				String link = null;

				Node node = nodeList.item(i);

				Element fstElmnt = (Element) node;

				NodeList linkList = fstElmnt.getElementsByTagName("link");
				Element linkElement = (Element) linkList.item(0);
				linkList = linkElement.getChildNodes();
				if (validateURL(((Node) linkList.item(0)).getNodeValue())) {
					link = ((Node) linkList.item(0)).getNodeValue();
				}

				NodeList titleList = fstElmnt.getElementsByTagName("title");
				Element titleElement = (Element) titleList.item(0);
				titleList = titleElement.getChildNodes();

				tit = ((Node) titleList.item(0)).getNodeValue().replaceAll(
						"[^\\w\\s\'.,&:\"]", "");

				NodeList websiteList = fstElmnt
						.getElementsByTagName("description");

				Element websiteElement = (Element) websiteList.item(0);
				websiteList = websiteElement.getChildNodes();

				longDesc = ((Node) websiteList.item(0)).getNodeValue()
						.replaceAll("([^\\w\\s\'.,-:&\"])", "");

				/*
				 * longDesc = websiteList.item(0).toString(); if (null !=
				 * longDesc && !"".equals(longDesc)) { longDesc =
				 * longDesc.replace("[#text:", ""); longDesc =
				 * longDesc.substring(0, longDesc.length() - 1).trim(); }
				 */
				String sortPubdate = null;
				Item item = new Item(tit, longDesc, null, link, category, null,
						sortPubdate);
				item.setId(i + 1);
				empItems.add(item);
			}

		}

		catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}
		return empItems;
	}

	public static List<Item> getVideoList(String name) {
		List<Item> videoItems = new ArrayList<Item>();

		URL url = null;
		URL url1 = null;
		String tit = null;
		String shortDesc = null;

		try {

			if (name.equalsIgnoreCase("videos")) {

				JSONObject json = readJsonFromUrl(CommonConstants.newsVideos);
				System.out.println(json.toString());

				JSONArray array = json.getJSONArray("items");

				for (int i = 0; i < array.length(); i++) {
					if (array.getJSONObject(i).getString("name") != null) {
						tit = array.getJSONObject(i).getString("name")
								.replaceAll("([^\\w\\s\'.,-:&\"<>])", "");
					}

					String videoId = array.getJSONObject(i).getString("id");
					BigDecimal bd = new BigDecimal(videoId);
					System.out.println(bd.longValue());

					if (!array.getJSONObject(i).getString("shortDescription")
							.equalsIgnoreCase("null")) {
						shortDesc = array.getJSONObject(i)
								.getString("shortDescription")
								.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
								.replaceAll("&mdash", "--");
						// System.out.println(shortDesc);
					} else {
						shortDesc = "";
					}

					// String link =
					// "http://link.brightcove.com/services/player/bcpid3742235943001?bckey=AQ~~,AAACHKYdcFk~,IGxDpm7wjyHsFkDSEiehCuhZ0IVXD7vt"+"&bctid="+bd.longValue();
					String link = getMP4RssFeedVideo(bd.longValue());
					System.out.println(link);
					String sortPubdate = null;
					Item item = new Item(tit, null, null, link, null,
							shortDesc, sortPubdate);

					item.setId(i + 1);
					videoItems.add(item);

				}

			}
		}

		catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}
		return videoItems;
	}

	public static List<Item> getFeedList(String name) {
		List<Item> items = new ArrayList<Item>();

		URL url = null;
		URL url1 = null;

		try {

			if (name.equalsIgnoreCase("top")) {

				url = new URL(CommonConstants.breaking);

				DocumentBuilderFactory dbf = DocumentBuilderFactory
						.newInstance();
				dbf.setCoalescing(true);
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(new InputSource(url.openStream()));
				doc.getDocumentElement().normalize();
				NodeList nodeList = doc.getElementsByTagName("item");

				for (int i = 0; i < nodeList.getLength(); i++) {

					String tit = null;
					String longDesc = null;
					String image = null;
					String link = null;
					String date = null;
					String shortDesc = null;

					Node node = nodeList.item(i);

					Element fstElmnt = (Element) node;

					try {

						if (fstElmnt.getElementsByTagName("media:content") != null) {

							NodeList media = fstElmnt
									.getElementsByTagName("media:content");
							if (media.item(0) != null
									&& media.item(0).getAttributes() != null
									&& media.item(0).getAttributes()
											.getNamedItem("url") != null) {
								String mediaurl = media.item(0).getAttributes()
										.getNamedItem("url").getNodeValue();

								image = mediaurl;
							}

						} else {
							image = null;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					NodeList linkList = fstElmnt.getElementsByTagName("link");
					Element linkElement = (Element) linkList.item(0);
					linkList = linkElement.getChildNodes();

					link = ((Node) linkList.item(0)).getNodeValue();

					NodeList titleList = fstElmnt.getElementsByTagName("title");
					Element titleElement = (Element) titleList.item(0);
					titleList = titleElement.getChildNodes();

					tit = ((Node) titleList.item(0)).getNodeValue()
							.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
							.replaceAll("&rsquo", "'")
							.replaceAll("&lsquo", "'")
							.replaceAll("&ldquo", "\"")
							.replaceAll("&rdquo", "\"")	
							.replaceAll("&mdash", "--")
							.replaceAll("&ndash", "-")
							.replaceAll(":", "");

					NodeList dateList = fstElmnt
							.getElementsByTagName("pubDate");
					Element dateElement = (Element) dateList.item(0);
					dateList = dateElement.getChildNodes();
					String datee = ((Node) dateList.item(0)).getNodeValue();
					// date=getDate(datee);
					String dates[] = datee.split(" ");
					date = dates[2] + " " + dates[1] + " " + " , " + dates[3];

					NodeList websiteList = fstElmnt
							.getElementsByTagName("media:text");
					Element websiteElement = (Element) websiteList.item(0);
					websiteList = websiteElement.getChildNodes();

					if (websiteList.item(0).toString() != null) {
						
						if (((Node) websiteList.item(0)).getNodeValue().length() > 75) {
							shortDesc = ((Node) websiteList.item(0))
									.getNodeValue()
									.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
									.replaceAll("&mdash", "--")
									.replaceAll("&ndash", "-")
									.replaceAll("&rsquo", "'")
									.replaceAll("&lsquo", "'")
									.replaceAll("&ldquo", "\"")
									.replaceAll("&rdquo", "\"")	
									.replaceAll("&39", "").substring(0, 75)
									+ "...";
						} else {
					
							shortDesc = ((Node) websiteList.item(0))
									.getNodeValue()
									.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
									.replaceAll("&mdash", "--")
									.replaceAll("&ndash", "-")
									.replaceAll("&rsquo", "'")
									.replaceAll("&lsquo", "'")
									.replaceAll("&ldquo", "\"")
									.replaceAll("&rdquo", "\"")	
									.replaceAll("&39", "")
									+ "...";
						}
						
						longDesc = websiteList.item(0).toString();
						// System.out.println("++++++++++++++++"+longDesc);
						if (null != longDesc && !"".equals(longDesc)) {
							longDesc = longDesc.replace("[#text:", "");
							longDesc = longDesc
									.substring(0, longDesc.length() - 1).trim()
									.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
									.replaceAll("&rsquo", "'")
									.replaceAll("&lsquo", "'")
									.replaceAll("&ldquo", "\"")
									.replaceAll("&rdquo", "\"")	
									.replace("&39", "'")
									.replaceAll("&mdash", "--")
									.replaceAll("&ndash", "-");

						}
						String sortPubdate = null;
						/*
						 * if(longDesc.trim().length()>100){
						 * 
						 * shortDesc = longDesc.replaceAll("[\\s\\u00A0]+$",
						 * "").substring(0, 100)+"..."; }
						 */

						Item item = new Item(tit, longDesc, image, link, date,
								shortDesc, sortPubdate);

						item.setId(i + 1);
						items.add(item);

					}

					url1 = new URL(CommonConstants.top);

					DocumentBuilderFactory dbf1 = DocumentBuilderFactory
							.newInstance();
					dbf1.setCoalescing(true);
					DocumentBuilder db1 = dbf1.newDocumentBuilder();
					Document doc1 = db1
							.parse(new InputSource(url1.openStream()));
					doc1.getDocumentElement().normalize();
					NodeList nodeList1 = doc1.getElementsByTagName("item");

					for (int i1 = 0; i1 < nodeList1.getLength(); i1++) {

						String tit1 = null;
						String longDesc1 = null;
						String image1 = null;
						String link1 = null;
						String date1 = null;
						String shortDesc1 = null;

						Node node1 = nodeList1.item(i);

						Element fstElmnt1 = (Element) node1;

						try {

							if (fstElmnt1.getElementsByTagName("media:content") != null) {

								NodeList media1 = fstElmnt1
										.getElementsByTagName("media:content");
								if (media1.item(0) != null
										&& media1.item(0).getAttributes() != null
										&& media1.item(0).getAttributes()
												.getNamedItem("url") != null) {
									String mediaurl = media1.item(0)
											.getAttributes()
											.getNamedItem("url").getNodeValue();

									image1 = mediaurl;
								}

							} else {
								image1 = null;
							}

						} catch (Exception e) {
							e.printStackTrace();
						}

						NodeList linkList1 = fstElmnt1
								.getElementsByTagName("link");
						Element linkElement1 = (Element) linkList1.item(0);
						linkList1 = linkElement1.getChildNodes();

						link1 = ((Node) linkList1.item(0)).getNodeValue();

						NodeList titleList1 = fstElmnt1
								.getElementsByTagName("title");
						Element titleElement1 = (Element) titleList1.item(0);
						titleList1 = titleElement1.getChildNodes();

						tit1 = ((Node) titleList1.item(0)).getNodeValue()
								.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
								.replaceAll("&rsquo", "'")
								.replaceAll("&lsquo", "'")
								.replaceAll("&ldquo", "\"")
								.replaceAll("&rdquo", "\"")	
								.replaceAll("&mdash", "--")
								.replaceAll("&ndash", "-")
								.replaceAll(":", "");

						NodeList dateList1 = fstElmnt1
								.getElementsByTagName("pubDate");
						Element dateElement1 = (Element) dateList1.item(0);
						dateList1 = dateElement1.getChildNodes();
						String datee1 = ((Node) dateList1.item(0))
								.getNodeValue();
						// date=getDate(datee);
						String dates1[] = datee1.split(" ");
						date1 = dates1[2] + " " + dates1[1] + " " + " , "
								+ dates1[3];

						NodeList websiteList1 = fstElmnt1
								.getElementsByTagName("media:text");
						Element websiteElement1 = (Element) websiteList1
								.item(0);
						websiteList1 = websiteElement1.getChildNodes();

						if (websiteList1.item(0).toString() != null) {

							if (((Node) websiteList1.item(0)).getNodeValue()
									.length() > 75) {
								shortDesc1 = ((Node) websiteList1.item(0))
										.getNodeValue()
										.replaceAll("([^\\w\\s\'.,-:&\"<>])",
												"").replaceAll("&rsquo", "'")
												.replaceAll("&lsquo", "'")
												.replaceAll("&ldquo", "\"")
												.replaceAll("&rdquo", "\"")	
												.replaceAll("&mdash", "--")
												.replaceAll("&ndash", "-")
												.replaceAll("&39", "")
												.substring(0, 75)+"...";
							} else {
								// shortDesc1= ((Node)
								// websiteList1.item(0)).getNodeValue().substring(0,
								// 50).replaceAll("([^\\w\\s\'.,-:&\"<>])",
								// "").replaceAll("&mdash",
								// "--").replaceAll("&ldquo",
								// "'").replaceAll("&rdquo",
								// "'").replaceAll("&rsquo",
								// "'").replaceAll("&lsquo",
								// "'").replaceAll("&39", "")+"...";
								shortDesc1 = ((Node) websiteList1.item(0))
										.getNodeValue()
										.replaceAll("([^\\w\\s\'.,-:&\"<>])",
												"").replaceAll("&rsquo", "'")
												.replaceAll("&lsquo", "'")
												.replaceAll("&ldquo", "\"")
												.replaceAll("&rdquo", "\"")	
												.replaceAll("&mdash", "--")
												.replaceAll("&ndash", "-")
												.replaceAll("&39", "") +"...";
							}

							longDesc1 = websiteList1.item(0).toString();
							// System.out.println("++++++++++++++++"+longDesc);
							if (null != longDesc1 && !"".equals(longDesc1)) {
								longDesc1 = longDesc1.replace("[#text:", "");
								longDesc1 = longDesc1
										.substring(0, longDesc.length() - 1)
										.trim()
										.replaceAll("([^\\w\\s\'.,-:&\"<>])","")
										.replaceAll("&rsquo", "'")
												.replaceAll("&lsquo", "'")
												.replaceAll("&ldquo", "\"")
												.replaceAll("&rdquo", "\"")	
												.replace("&39", "'")
												.replaceAll("&mdash", "--")
												.replaceAll("&ndash", "-");
							}
							/*
							 * if(longDesc.trim().length()>100){
							 * 
							 * shortDesc = longDesc.replaceAll("[\\s\\u00A0]+$",
							 * "").substring(0, 100)+"..."; }
							 */
							String sortPubdate = null;
							Item item = new Item(tit1, longDesc1, image1,
									link1, date1, shortDesc1, sortPubdate);

							item.setId(i + 1);
							items.add(item);

						}
					}
				}
			}
		}

		catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}
		return items;
	}

	public static List<Item> getList(String name) {
		List<Item> items = new ArrayList<Item>();

		URL url = null;

		try {

			if (name.equalsIgnoreCase("breaking")) {

				url = new URL(CommonConstants.breaking);

			} else if (name.equalsIgnoreCase("sports")) {
				url = new URL(CommonConstants.sports);

			} else if (name.equalsIgnoreCase("food")) {
				url = new URL(CommonConstants.food);
			} else if (name.equalsIgnoreCase("health")) {
				url = new URL(CommonConstants.health);
			} else if (name.equalsIgnoreCase("business")) {
				url = new URL(CommonConstants.business);
			}

			/* Once batch processing is done remove this */

			/*
			 * else if(name.equalsIgnoreCase("real")){ url = new
			 * URL(CommonConstants.); }
			 */

			else if (name.equalsIgnoreCase("editorial")) {
				url = new URL(CommonConstants.editorial);
			} else if (name.equalsIgnoreCase("top")) {
				url = new URL(CommonConstants.top);
			} else if (name.equalsIgnoreCase("life")) {
				url = new URL(CommonConstants.life);
			} else if (name.equalsIgnoreCase("opinion")) {
				url = new URL(CommonConstants.editorial);
			}

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setCoalescing(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(new InputSource(url.openStream()));
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("item");

			for (int i = 0; i < nodeList.getLength(); i++) {

				String tit = null;
				String longDesc = null;
				String image = null;
				String link = null;
				String date = null;
				String shortDesc = null;

				Node node = nodeList.item(i);

				Element fstElmnt = (Element) node;

				try {

					if (fstElmnt.getElementsByTagName("media:content") != null) {

						NodeList media = fstElmnt
								.getElementsByTagName("media:content");
						if (media.item(0) != null
								&& media.item(0).getAttributes() != null
								&& media.item(0).getAttributes()
										.getNamedItem("url") != null) {
							String mediaurl = media.item(0).getAttributes()
									.getNamedItem("url").getNodeValue();

							image = mediaurl;
						}

					} else {
						image = null;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				NodeList linkList = fstElmnt.getElementsByTagName("link");
				Element linkElement = (Element) linkList.item(0);
				linkList = linkElement.getChildNodes();

				link = ((Node) linkList.item(0)).getNodeValue();

				NodeList titleList = fstElmnt.getElementsByTagName("title");
				Element titleElement = (Element) titleList.item(0);
				titleList = titleElement.getChildNodes();

				tit = ((Node) titleList.item(0)).getNodeValue()
						.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
						.replaceAll("&rsquo", "'")
								.replaceAll("&lsquo", "'")
								.replaceAll("&ldquo", "\"")
								.replaceAll("&rdquo", "\"")	
								.replaceAll("&mdash", "--")
								.replaceAll("&ndash", "-")
								.replaceAll(":", "");

				NodeList dateList = fstElmnt.getElementsByTagName("pubDate");
				Element dateElement = (Element) dateList.item(0);
				dateList = dateElement.getChildNodes();
				String datee = ((Node) dateList.item(0)).getNodeValue();
				// date=getDate(datee);
				String dates[] = datee.split(" ");
				date = dates[1] + " " + dates[2] + " " + " , " + dates[3];

				NodeList websiteList = fstElmnt
						.getElementsByTagName("media:text");
				Element websiteElement = (Element) websiteList.item(0);
				websiteList = websiteElement.getChildNodes();

				if (websiteList.item(0).toString() != null) {
					if (((Node) websiteList.item(0)).getNodeValue().length() > 75) {
						shortDesc = ((Node) websiteList.item(0)).getNodeValue()
								.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
								
								.replaceAll("&rsquo", "'")
								.replaceAll("&lsquo", "'")
								.replaceAll("&ldquo", "\"")
								.replaceAll("&rdquo", "\"")	
								.replaceAll("&mdash", "--")
								.replaceAll("&ndash", "-")
								.replaceAll("&39", "")
								.substring(0, 75)+"...";
					} else {
						// shortDesc= ((Node)
						// websiteList.item(0)).getNodeValue().substring(0,
						// 50).replaceAll("([^\\w\\s\'.,-:&\"<>])",
						// "").replaceAll("&mdash", "--").replaceAll("&ldquo",
						// "'").replaceAll("&rdquo", "'").replaceAll("&rsquo",
						// "'").replaceAll("&lsquo", "'").replaceAll("&39",
						// "")+"...";
						shortDesc = ((Node) websiteList.item(0)).getNodeValue()
								.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
								.replaceAll("&rsquo", "'")
								.replaceAll("&lsquo", "'")
								.replaceAll("&ldquo", "\"")
								.replaceAll("&rdquo", "\"")	
								.replaceAll("&mdash", "--")
								.replaceAll("&ndash", "-")
								.replaceAll("&39", "") +"...";
					}
					longDesc = websiteList.item(0).toString();
					// System.out.println("++++++++++++++++"+longDesc);
					if (null != longDesc && !"".equals(longDesc)) {
						longDesc = longDesc.replace("[#text:", "");
						longDesc = longDesc.substring(0, longDesc.length() - 1)
								.trim()
								.replaceAll("&rsquo", "'")
								.replaceAll("&lsquo", "'")
								.replaceAll("&ldquo", "\"")
								.replaceAll("&rdquo", "\"")	
								.replace("&39", "'")
								.replaceAll("&mdash", "--")
								.replaceAll("&ndash", "-");

					}
					/*
					 * if(longDesc.trim().length()>100){
					 * 
					 * shortDesc = longDesc.replaceAll("[\\s\\u00A0]+$",
					 * "").substring(0, 100)+"..."; }
					 */
					String sortPubdate = null;
					Item item = new Item(tit, longDesc, image, link, date,
							shortDesc, sortPubdate);

					item.setId(i + 1);
					items.add(item);

				}

			}
		}

		catch (Exception e) {
			System.out.println("XML Pasing Excpetion = " + e);
		}
		return items;
	}

	public static String getDate(String s) {
		String currentDate = null;
		try {
			DateFormat df = new SimpleDateFormat("MMMM dd, yyyy");
			Date date1 = df.parse(s);
			currentDate = df.format(date1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currentDate;

	}

	public static Map<String, List<Item>> groupToList(List<Item> items) {

		String sDescription = null;
		Map<String, List<Item>> citiesByCountry = new HashMap<String, List<Item>>();
		Map<String, List<Item>> citiesByCountrySorted = new TreeMap<String, List<Item>>(
				Collections.reverseOrder());

		for (Item city : items) {

			if (city.getDescription().length() > 75) {
				sDescription = city.getDescription()
						.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
						.replaceAll("&mdash", "--").replaceAll("&rsquos", "'")
						.replaceAll("&lsquos", "'").replaceAll("&39", "")
						.substring(0, 75)
						+ "...";
			} else {
				// sDescription = city.getDescription().substring(0,
				// 50).replaceAll("([^\\w\\s\'.,-:&\"<>])",
				// "").replaceAll("&mdash", "--").replaceAll("&ldquo",
				// "'").replaceAll("&rdquo", "'").replaceAll("&rsquo",
				// "'").replaceAll("&lsquo", "'").replaceAll("&39", "")+"...";
				sDescription = city.getDescription()
						.replaceAll("([^\\w\\s\'.,-:&\"<>])", "")
						.replaceAll("&mdash", "--").replaceAll("&ldquo", "'")
						.replaceAll("&rdquo", "'").replaceAll("&rsquo", "'")
						.replaceAll("&lsquo", "'").replaceAll("&39", "")
						+ "...";
			}

			city.setShortDesc(sDescription);

			List citiesForCountry = citiesByCountry
					.get(city.getPublishedDate());

			if (citiesForCountry == null) {
				citiesForCountry = new ArrayList<Item>();
				citiesByCountry.put(city.getPublishedDate(), citiesForCountry);
				citiesByCountrySorted.putAll(citiesByCountry);
			}

			citiesForCountry.add(city);
		}

		ArrayList citLst = new ArrayList(citiesByCountrySorted.entrySet());
		SortRSSFeedByDate sortByDate = new SortRSSFeedByDate();
		Collections.sort(citLst, sortByDate);

		return citiesByCountrySorted;

		/*
		 * ArrayList<HashMap<String,Item>> list=new
		 * ArrayList<HashMap<String,Item>>(); for (Item a : activityList) {
		 * HashMap<String,Item> map = new HashMap<String,Item>(); String key =
		 * a.getDate(); Item group = map.get(key); if (group == null) { group =
		 * new Item(); map.put(key, group); list.add(map); }
		 */
	}

	public static ArrayList<Category> sortHotdealsByAPINames(
			ArrayList<Item> hotDealResultInputList) {
		final HashMap<String, Category> hotDealsAPIInfoMap = new HashMap<String, Category>();
		Category objHotDealAPIResultSet = null;
		ArrayList<Item> hotDealsDetailsList = null;
		Item objHdDetails2 = null;
		// Category
		String key = null;
		for (Item hotDealsDetails : hotDealResultInputList) {
			key = hotDealsDetails.getPubStrtDate();
			if (hotDealsAPIInfoMap.containsKey(key)) {
				objHotDealAPIResultSet = hotDealsAPIInfoMap.get(key);
				hotDealsDetailsList = objHotDealAPIResultSet.getItemLst();
				if (hotDealsDetailsList != null) {
					Item objHdDetails = new Item();
					objHdDetails.setImagePath(hotDealsDetails.getImagePath());
					objHdDetails.setId(hotDealsDetails.getId());
					objHdDetails.setTitle(hotDealsDetails.getTitle());
					objHdDetails.setShortDesc(hotDealsDetails.getShortDesc());
					objHdDetails.setDescription(hotDealsDetails
							.getDescription());
					objHdDetails.setLink(hotDealsDetails.getLink());
					hotDealsDetailsList.add(objHdDetails);
					objHotDealAPIResultSet.setItemLst(hotDealsDetailsList);
				}
			} else {

				objHotDealAPIResultSet = new Category();
				objHotDealAPIResultSet.setPublishedDate(hotDealsDetails
						.getPubStrtDate());
				objHotDealAPIResultSet.setDisplayDate(hotDealsDetails.getPublishedDate());
				objHdDetails2 = new Item();

				hotDealsDetailsList = new ArrayList<Item>();

				objHdDetails2.setImagePath(hotDealsDetails.getImagePath());
				objHdDetails2.setId(hotDealsDetails.getId());
				objHdDetails2.setTitle(hotDealsDetails.getTitle());
				objHdDetails2.setShortDesc(hotDealsDetails.getShortDesc());
				objHdDetails2.setDescription(hotDealsDetails.getDescription());
				objHdDetails2.setLink(hotDealsDetails.getLink());
				hotDealsDetailsList.add(objHdDetails2);
				objHotDealAPIResultSet.setItemLst(hotDealsDetailsList);
			}
			hotDealsAPIInfoMap.put(key, objHotDealAPIResultSet);
		}
		final Set<Map.Entry<String, Category>> set = hotDealsAPIInfoMap
				.entrySet();

		final ArrayList<Category> hotDealsAPIInfolst = new ArrayList<Category>();

		for (Map.Entry<String, Category> entry : set) {
			hotDealsAPIInfolst.add(entry.getValue());
		}

		SortRSSFeedByDate objSortHDbyAPIName = new SortRSSFeedByDate();
		Collections.sort(hotDealsAPIInfolst, objSortHDbyAPIName);

		return hotDealsAPIInfolst;
	}

	/**
	 * This method is used to validate string is empty or null.
	 * 
	 * @param arg
	 *            as input parameter
	 * @return true if string is empty or null otherwise false.
	 */

	public static boolean isEmptyOrNullString(String arg) {

		final String methodName = "isEmptyString";
		final boolean emptyString;

		if (null == arg || "".equals(arg.trim())) {
			emptyString = true;
		} else {
			emptyString = false;
		}
		return emptyString;
	}

	/**
	 * Method Parse date string in format - Sat, 03 Jan 2015 20:27:16 -0600 and
	 * return date object.
	 * 
	 * @param date
	 * @return
	 */
	public static Date getDateFromString(String strDate) {
		Date objDate = null;
		if (null != strDate && !"".equals(strDate)) {
			try {
				objDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.parse(strDate);
			} catch (ParseException e) {
				// LOG.error("Error in parsing date. Error message: " +
				// e.getMessage());
				return null;
			}
		}
		return objDate;
	}

	public static String stripNonValidXMLCharacters(String in) {
		StringBuilder out = new StringBuilder();
		char current;

		if (in == null || ("".equals(in)))
			return "";
		for (int i = 0; i < in.length(); i++) {
			current = in.charAt(i);
			if ((current == 0x9) || (current == 0xA) || (current == 0xD)
					|| ((current >= 0x20) && (current <= 0xD7FF))
					|| ((current >= 0xE000) && (current <= 0xFFFD))
					|| ((current >= 0x10000) && (current <= 0x10FFFF)))
				out.append(current);
		}
		return out.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException,
			JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static String formatDate(
			Map<String, List<Item>> citiesByCountrySorted) {

		String newstring = null;

		for (Map.Entry<String, List<Item>> entry : citiesByCountrySorted
				.entrySet()) {

			String key = entry.getKey();

			try {
				Date date = new SimpleDateFormat("dd/mmm YYYY").parse(key);
				newstring = new SimpleDateFormat("MM-dd-YYYY").format(date);
				System.out.println(newstring); // 2011-01-18
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Date" + key);

		}
		return newstring;

	}

	public static void main(String[] args) {

	}

	public static Item getValues(Item item) {
		Item items = null;
		if (item.getId() > 0) {
			items.setId(item.getId());
			items.setImage(item.getImage());
			items.setTitle(item.getTitle());
			items.setDescription(item.getDescription());
		}
		return items;
	}

	public static String getMP4RssFeedVideo(long videoId) {
		String strMethodName = "getMP4RssFeedVideo";
		System.out.println(CommonConstants.METHODSTART + strMethodName);
		String strVideo = null;
		// Fetch MP4 video by passing video id to below URL

		String url = "http://api.brightcove.com/services/library?command=find_video_by_id&video_fields=name,length,FLVURL&media_delivery=http&token=x95LXczyNI5-G9kX0cjsHM9edPFzaKFTE4PANJ7L2rQfuF-swGUxJg.."
				+ "&video_id=" + videoId;

		try {

			InputStream is = new URL(url).openStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is,
					Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);

			System.out.println("The json is" + json.getString("FLVURL"));
			strVideo = json.getString("FLVURL");
			System.out.println("The json to stirng is" + json.toString());

		} catch (Exception exception) {
			System.out.println("Exception occured in " + strMethodName
					+ exception.getMessage());
		}

		System.out.println(CommonConstants.METHODEND + strMethodName);
		return strVideo;
	}

}
