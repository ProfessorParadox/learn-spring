package com.msbClipboard.ver2.web.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.msbClipboard.ver2.web.model.Note;

@Component
public class NotesDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//create note
	@Transactional
	public void createNote(Note note) {
		this.hibernateTemplate.save(note);
	}
	
	//get all notes
	public List<Note> getAllNotes(){
		List<Note> notesList = this.hibernateTemplate.loadAll(Note.class);
		return notesList;
	}
	
	//delete note
	@Transactional
	public void deleteNote(int noteID) {
		Note tempNote = this.hibernateTemplate.load(Note.class, noteID); 
		this.hibernateTemplate.delete(tempNote);
	}
	
	//get note
	public Note getNote(int noteID) {
		return this.hibernateTemplate.get(Note.class, noteID);
	}
	

}
