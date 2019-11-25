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
			
		String dealUrl="https://www.redflagdeals.com/in/"+city+"/deals/?search_type=popular";
		
		String url = ("http://api.scraperapi.com/?api_key=99869a08744390b2b3c700eac7663298&url="+dealUrl);
		
		
		String data1 = null;
		String data2 = null;
		try {
		Document doc = Jsoup.connect(url).timeout(60000).get();
		Elements elements = doc.getElementsByClass("list_item_body");
		int i = 1;
		for (Element element : elements) {
			if (i > 12) {
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
