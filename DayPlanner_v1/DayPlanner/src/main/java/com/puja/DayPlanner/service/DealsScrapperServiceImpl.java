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
public class DealsScrapperServiceImpl {
	public Map<String, String> Scrapper() {
		Map<String, String> deals = new LinkedHashMap<String, String>();
		//deals.put("Best Buy", "Shop Black Friday 2019 Prices Now at Best Buy");
		String data1 = null;
		String data2 = null;
		try {
		Document doc = Jsoup.connect("https://www.redflagdeals.com/in/ottawa/deals/?search_type=popular").get();
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
		}
		return deals;
		
	}
	
	

}
