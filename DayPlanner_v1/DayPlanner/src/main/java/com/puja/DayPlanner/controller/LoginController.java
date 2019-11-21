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
@RequestMapping(value="/")
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
		//final RedirectAttributes redirectAttributes
		System.out.println("Outside else username is :"+loginModel.getUsername());
		if(bindingResult.hasErrors()) {
			System.out.println("Inside Binding result username is :"+loginModel.getUsername());
			return "login";
		}
		else {
				User user=userService.getByUsername(loginModel.getUsername());
				System.out.println("Inside else username is :"+loginModel.getUsername());
				System.out.println("Inside else User id is :"+user.getId());
				if((user !=null) & (user.getPassword().equals(loginModel.getPassword()))) {
					System.out.println("Inside if loop username is :"+loginModel.getUsername());
					model.addAttribute("userObj", user);
					return "redirect:/userHome";
	
				}

			else {
				System.out.println("Not porper username and password");
				return "errorPage";
			}
			
			}
		}

		
		@RequestMapping("/userHome")
		public String userHome(@ModelAttribute("userObj") User userObj,SessionStatus sessionStatus,
				Model model) {
			
		System.out.println("flash atrribute:"+userObj.getId());
		
		//Create Notes
		Notes notes=new Notes();
		notes.setUser(userObj);
		model.addAttribute("notes", notes);
		System.out.println("user in create Notes:"+userObj.getUsername());
			
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
	    
	      //view Notes
	     /* List<Notes> AllNotes=noteService.findAll();
			model.addAttribute("AllNotes", llNotes);*/		
			return "userHome";
		}
		

		
		@RequestMapping(value="/userHome",method=RequestMethod.POST)
		public String createNoteProcess(@Valid @ModelAttribute("notes") Notes notes,BindingResult bindingResult){
			System.out.println("Entered Post method");
			if(bindingResult.hasErrors()) {			
				return "userHome";
			}
			else {
				System.out.println("note name :"+notes.getNoteName());
				System.out.println("note name :"+notes.getContent());
				//System.out.println("note with Id:"+notes.getUser().getId());
				//User user2=this.userservice.findById(1L);
				
				System.out.println("note after setting user");
				System.out.println("note username :"+notes.getUser().getUsername());
				noteService.create(notes);
				
				return "redirect:/userHome";
			}
			}
		
		
		
		/*@RequestMapping(value="/createNotes/{userid}",method=RequestMethod.GET)
		public String createNoteProcess(@Valid @ModelAttribute("notes") Notes notes,BindingResult bindingResult,
										@PathVariable Long userid){
			if(bindingResult.hasErrors()) {			
				return "userHome";
			}
			else {
				System.out.println("note name :"+notes.getNoteName());
				System.out.println("note name :"+notes.getContent());
				
				User user=this.userservice.findById(userid);
				notes.setUser(user);
				System.out.println("note after setting user");
				//System.out.println("note username :"+notes.getUser().getUsername());
				noteService.create(notes);
				return "redirect:/userHome";
			}
		}*/
		//#A7BA9E;
		@RequestMapping(value="/logout",method=RequestMethod.GET)
		public String logout(SessionStatus sessionStatus){
			sessionStatus.setComplete();
			return "redirect:/";
		}
		
		
		@RequestMapping(value="/viewNotes",method=RequestMethod.GET)
		public String viewNotes(Model model,
				@ModelAttribute("userObj") User userObj,SessionStatus sessionStatus){

			System.out.println("user name in view notes"+userObj.getUsername());
			List<Notes> notes=noteService.findAll(userObj);
		
			System.out.println("Notes List is "+notes);
			model.addAttribute("AllNotes", notes);
			
			return "viewNotes";
		}
		
		
		@RequestMapping(value="/deleteNotes/{id}",method=RequestMethod.GET)
		public String deleteNotes(Model model,@PathVariable String id) {
			Long noteid=Long.parseLong(id);
			System.out.println("noteid in dlete notes"+noteid);
			this.noteService.deleteNote(noteid);
			return "redirect:/viewNotes";
		}
		
		//<a href="deleteNotes/"+${notes.noteid}"
		
		
		
	}
		


		
	
	
	
	/*@RequestMapping("/viewNote/{noteName}")
	public String getNote(@PathVariable("noteName") String noteName,Model model) {
		Notes notes=this.noteService.getNote(noteName);
		model.addAttribute("Notes",notes);
		return "viewNote";
		}*/
	
	

