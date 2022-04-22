package com.msb.msbclipboardAlpha.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notes {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int noteid;
	private String notetitle;
	private String  notetext;
	private int uid;
	
	public int getNoteid() {
		return noteid;
	}
	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}
	public String getNotetitle() {
		return notetitle;
	}
	public void setNotetitle(String notetitle) {
		this.notetitle = notetitle;
	}
	public String getNotetext() {
		return notetext;
	}
	public void setNotetext(String notetext) {
		this.notetext = notetext;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Notes [noteid=" + noteid + ", notetitle=" + notetitle + ", notetext=" + notetext + ", uid=" + uid + "]";
	}
		

}
