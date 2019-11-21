package com.puja.DayPlanner.service;


import java.util.List;

import com.puja.DayPlanner.model.Notes;
import com.puja.DayPlanner.model.User;



public interface NotesService {
	Notes create(Notes notes);
	List<Notes> findAll(User user);
	void deleteNote(Long id);
	Notes getNote(Long id);
	
	
}


