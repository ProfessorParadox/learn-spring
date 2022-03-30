package com.msbClipboard.ver2.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noteID;
	private String title;
	private String text;
	private int uID;
	private User user;
	
	public Note(String title, String text, User user) {
		super();
		this.title = title;
		this.text = text;
		this.user = user;
	}

	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Note(int noteID, String title, String text, int uID, User user) {
		super();
		this.noteID = noteID;
		this.title = title;
		this.text = text;
		this.uID = uID;
		this.user = user;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
