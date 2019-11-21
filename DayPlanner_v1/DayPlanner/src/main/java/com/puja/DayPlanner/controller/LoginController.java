package com.puja.DayPlanner.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.puja.DayPlanner.model.Login;
import com.puja.DayPlanner.model.Notes;
import com.puja.DayPlanner.model.User;
import com.puja.DayPlanner.model.Weather;
import com.puja.DayPlanner.service.DealsScrapperService;
import com.puja.DayPlanner.service.NotesService;
import com.puja.DayPlanner.service.UserService;
import com.puja.DayPlanner.service.WeatherService;



@Controller
@SessionAttributes("userObj")
public class LoginController {

	@Autowired
	private UserService userService;
	
	
	@Autowired
	private NotesService noteService;
	
	@Autowired
	private WeatherService weatherService;
	
	@Autowired
	private DealsScrapperService dealsService;
	
	
	@RequestMapping("/login")
	public String login(Model model) {
		Login login=new Login();
		model.addAttribute("login",login);
		return "login";
	}

		
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String processLogin(@Valid @ModelAttribute("login") Login loginModel, BindingResult bindingResult,Model model) {
		if(bindingResult.hasErrors()) {
			return "login";
		}
		else {
				User user=userService.getByUsername(loginModel.getUsername());
				if((user !=null) & (user.getPassword().equals(loginModel.getPassword()))) {
					model.addAttribute("userObj", user);
					return "redirect:/userHome";
	
				}

			else {
				return "errorPage";
			}
			
			}
		}

		
		@RequestMapping("/userHome")
		public String userHome(@ModelAttribute("userObj") User userObj,SessionStatus sessionStatus,
				Model model) {
			
	
		
		//Create Notes
		Notes notes=new Notes();
		notes.setUser(userObj);
		model.addAttribute("notes", notes);
		
			
		 // Weather Updates	
		 String city=userObj.getCity();
	      Weather weather=this.weatherService.getWeather("canada",city);
	      model.addAttribute("weatherData",weather);
	      String iconurl="http://openweathermap.org/img/w/" + weather.getIcon() + ".png";
	      model.addAttribute("iconurl", iconurl);
	      
	      //Popular Deals
	      Map<String, String> mapObject=this.dealsService.Scrapper(city);
	      model.addAttribute("deals", mapObject);
	      
	      model.addAttribute("user", userObj);
	    
	
			return "userHome";
		}
		

		
		@RequestMapping(value="/userHome",method=RequestMethod.POST)
		public String createNoteProcess(@Valid @ModelAttribute("notes") Notes notes,BindingResult bindingResult){
			
			if(bindingResult.hasErrors()) {			
				return "userHome";
			}
			else {
				
			
				noteService.create(notes);
				
				return "redirect:/userHome";
			}
			}
		
		
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public String logout(SessionStatus sessionStatus){
			sessionStatus.setComplete();
			return "redirect:/";
		}
		
		
		@RequestMapping(value="/viewNotes",method=RequestMethod.GET)
		public String viewNotes(Model model,
				@ModelAttribute("userObj") User userObj,SessionStatus sessionStatus){

		
			List<Notes> notes=noteService.findAll(userObj);
	
			model.addAttribute("AllNotes", notes);
			
			return "viewNotes";
		}
		
		
		@RequestMapping(value="/deleteNotes/{id}",method=RequestMethod.GET)
		public String deleteNotes(Model model,@PathVariable String id) {
			Long noteid=Long.parseLong(id);
			
			this.noteService.deleteNote(noteid);
			return "redirect:/viewNotes";
		}
		
		
		
		
	}
		


	
	

