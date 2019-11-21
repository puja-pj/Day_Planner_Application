package com.puja.DayPlanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puja.DayPlanner.dao.NotesRepository;
import com.puja.DayPlanner.model.Notes;
import com.puja.DayPlanner.model.User;



@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	private NotesRepository notesRepo;
	
	@Override
	public Notes create(Notes notes) {
		// TODO Auto-generated method stub
		return this.notesRepo.save(notes);
	}


	@Override
	public Notes edit(Notes notes) {
		// TODO Auto-generated method stub
		return this.notesRepo.save(notes);
	}

	@Override
	public List<Notes> findAll(User user) {
		// TODO Auto-generated method stub
		return this.notesRepo.findByUser(user);
		
	}

	@Override
	public void deleteNote(Long id) {
		this.notesRepo.deleteById(id);
		
	}


	@Override
	public Notes getNote(Long id) {
		// TODO Auto-generated method stub
		return this.notesRepo.getOne(id);
	}

}
