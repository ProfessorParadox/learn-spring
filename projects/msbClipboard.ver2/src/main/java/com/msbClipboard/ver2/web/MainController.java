package com.msbClipboard.ver2.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.msbClipboard.ver2.web.dao.NotesDao;
import com.msbClipboard.ver2.web.model.Note;

@Controller
public class MainController {
	
	@Autowired
	private NotesDao notesDao;
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
//	@RequestMapping("/login")
//	public String login() {
//		return "login";
//	}
	
	@RequestMapping("/add_note")
	public String addNote(Model m) {
		m.addAttribute("title","Create A New Note"); 
		return "add_note_form";
	}
	
	@RequestMapping(value= "/handle-note", method= RequestMethod.POST)
	public RedirectView handleNote(@ModelAttribute Note note, HttpServletRequest request) {
		System.out.println(note);
		this.notesDao.createNote(note);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}
	
//	@RequestMapping("/")
//	public String () {
//		return "";
//	}
	
			

}
