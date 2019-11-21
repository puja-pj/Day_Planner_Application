package com.puja.DayPlanner.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puja.DayPlanner.model.Notes;
import com.puja.DayPlanner.model.User;



@Repository
public interface NotesRepository extends JpaRepository<Notes, Long>{
	public List<Notes> findByUser(User user);
}
