package com.puja.DayPlanner.service;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class DealsScrapperServiceImpl implements DealsScrapperService{
	public Map<String, String> Scrapper(String city) {
		
		Map<String, String> deals = new LinkedHashMap<String, String>();
			
			deals.put("Amazon Canada", "Shop Early Black Friday Deals Now at Amazon.ca!");
			deals.put("Shoppers Drug Mart","New Flyer! Royale Bathroom Tissue $4.99 + More!");
			deals.put("IKEA","Take Up to 15% Off Select Speakers at IKEA!");
			deals.put("Shoppers Drug Mart","Black Friday Super Sale!");
			deals.put("Best Buy","Shop Black Friday 2019 Deals Early at Best Buy!");
			deals.put("Canadian Tire","Canadian Tire Early Black Friday 2019 Deals!");
			deals.put("Walmart","Walmart Canada Black Friday 2019 Flyer Early Deals");
			deals.put("Google.com","Preview Google's Black Friday 2019 Deals Now!");
			deals.put("Best Buy","See Best Buy's Black Friday 2019 Flyer Now on RFD!");
			deals.put("Microsoft","Preview Microsoft's Black Friday 2019 Deals Now!");
		
			//String url="https://www.redflagdeals.com/in/"+city+"/deals/?search_type=popular";
		
		//deals.put("Best Buy", "Shop Black Friday 2019 Prices Now at Best Buy");
		/*String data1 = null;
		String data2 = null;
		try {
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.getElementsByClass("list_item_body");
		int i = 1;
		for (Element element : elements) {
			if (i > 10) {
				break;
			}
			data1 = element.getElementsByClass("offer_dealer").text();
			data2 = element.getElementsByClass("offer_title").text();
			System.out.println(data1);
			System.out.println(data2);
			deals.put(data1, data2);
			System.out.println();
			++i;
		}
		}
		catch(IOException e) {
			e.printStackTrace();	
		}*/
		return deals;
		
	}
	
	

}
